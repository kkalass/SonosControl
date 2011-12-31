package de.kalass.sonoscontrol;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosControl.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.AsyncValue;
import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.FailableCallback;
import de.kalass.sonoscontrol.api.core.LoggingErrorStrategy;
import de.kalass.sonoscontrol.api.model.ZoneAttributes;
import de.kalass.sonoscontrol.api.services.AVTransportService;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.RenderingControlService;
import de.kalass.sonoscontrol.cli.commands.Arguments;
import de.kalass.sonoscontrol.cli.commands.ArgumentsVisitor;
import de.kalass.sonoscontrol.cli.commands.HelpArgs;
import de.kalass.sonoscontrol.cli.commands.MuteArgs;
import de.kalass.sonoscontrol.cli.commands.ShowArgs;
import de.kalass.sonoscontrol.cli.commands.StartArgs;
import de.kalass.sonoscontrol.cli.commands.StopArgs;
import de.kalass.sonoscontrol.cli.commands.ZoneCommandArgs;
import de.kalass.sonoscontrol.cli.commands.ZoneSpec;
import de.kalass.sonoscontrol.clingimpl.SonosControlClingImpl;

public class SonosControlApp {
	private static final Logger LOG = LoggerFactory.getLogger(SonosControlApp.class);

    private static final class CallbackWrapper implements Callback0, FailableCallback {
    	private final String _msg;
    	private final CliCommandResultCallback _callback;
		public CallbackWrapper(CliCommandResultCallback callback, String msg) {
			super();
			_msg = msg;
			_callback = callback;
		}
    	@Override
    	public void success() {
    		_callback.success(_msg);
    	}
    	@Override
    	public void fail(String defaultMsg) {
    		_callback.fail(new RuntimeException(defaultMsg));
    	}
    }
    
    private static final class MuteCommand extends SonosDeviceCommand {
		private final MuteArgs _muteCmd;

		private MuteCommand(MuteArgs muteArgs) {
			super(muteArgs);
			_muteCmd = muteArgs;
		}

		@Override
		public void call(final SonosDevice device, final CliCommandResultCallback callback) {
			final RenderingControlService renderingControlService = device.getRenderingControlService();
			renderingControlService.setMute(_muteCmd.isMute(), new CallbackWrapper(callback, "Mute " + _muteCmd.isMute()));
		}
	}
    
    private static final class StartCommand extends SonosDeviceCommand {

		private StartCommand(StartArgs args) {
			super(args);
		}

		@Override
		public void call(final SonosDevice device, final CliCommandResultCallback callback) {
			AVTransportService avTransportService = device.getAVTransportService();
			avTransportService.play(new CallbackWrapper(callback, "Started playing "));
		}
	}
    
    private static final class StopCommand extends SonosDeviceCommand {

		private StopCommand(StopArgs args) {
			super(args);
		}

		@Override
		public void call(final SonosDevice device, final CliCommandResultCallback callback) {
			AVTransportService avTransportService = device.getAVTransportService();
			avTransportService.stop(new CallbackWrapper(callback, "Stopped playing "));
		}
	}
    
	private static final class ShowCommand extends SonosDeviceCommand {
		public ShowCommand(ShowArgs args) {
			super(args);
		}

		@Override
		public void call(SonosDevice device, CliCommandResultCallback callback) throws InterruptedException, ExecutionException  {
			final DevicePropertiesService propsService = device.getDevicePropertiesService();
			final RenderingControlService renderingControlService = device.getRenderingControlService();
			
			final AsyncValue<ZoneAttributes> attributes = propsService.retrieveZoneAttributes(new AsyncValue<ZoneAttributes>());

			final AsyncValue<Long> volume = renderingControlService.retrieveVolume(new AsyncValue<Long>());
			final AsyncValue<Boolean> mute = renderingControlService.retrieveMute(new AsyncValue<Boolean>());

			String msg = "VOLUME: " + volume.get() + "\n"  
					+ "MUTE: " + mute.get() + "\n"  
					+ "ATTRIBUTES: " + attributes.get() +  "\n";

			callback.success(msg);
		}
	}
	
	public interface CliCommandResultCallback {
		void success(String output);
		void fail(Throwable t);
	}

	public static abstract class SonosDeviceCommand {
		private final ZoneSpec _zoneSpec;
		
		public SonosDeviceCommand(ZoneCommandArgs args) {
			this(args.getZoneSpec());
		}
		
		public SonosDeviceCommand(ZoneSpec zoneSpec) {
			_zoneSpec = zoneSpec;
		}
		
		public final ZoneSpec getZoneSpec() {
			return _zoneSpec;
		}
		  
    	public abstract void call(SonosDevice device, CliCommandResultCallback callback) throws Exception;
    }

    static Void execute(final SonosDeviceCommand command) {
    	final SonosControl sonosControl = new SonosControlClingImpl();
        Runtime.getRuntime().addShutdownHook(new Thread("shutdown-hook") {
        	@Override
        	public void run() {
        		LOG.debug("Stopping Sonos Control...");
        		sonosControl.shutdown();
        	}
        });
        
        final CliCommandResultCallback finish = new CliCommandResultCallback(){
        	@Override
        	public void success(String message) {
        		System.out.println(message);
        		System.exit(0);
        	}
        	@Override
        	public void fail(Throwable t) {
        		LOG.error(t.getMessage(), t);
        		System.err.println("FAILED!");
        		System.exit(1);
        	}
        };
        
    	sonosControl.setErrorStrategy(new LoggingErrorStrategy());
    	
    	sonosControl.executeOnZone(command.getZoneSpec().getZoneName(), new SonosDeviceCallback() {
			
			@Override
			public void success(SonosDevice device) {
				LOG.debug("Found  Sonos device " + device.getZoneName());
				Preconditions.checkState(device.getZoneName().equals(command.getZoneSpec().getZoneName()));
				try {
					command.call(device, finish);
				} catch(Throwable t) {
					finish.fail(t);
				}
			}
		});
    	
        return null;
    }
    
    public static void main(String[] args) throws Exception {
        // Start a user thread that runs the UPnP stack
    	final Arguments commandArguments = Arguments.parse(args);
    	commandArguments.invite(new ArgumentsVisitor<Void>() {
    		@Override
    		public Void visitHelp(HelpArgs help) {
    			System.out.println("");
    			System.out.println("Usage:");
    			System.out.println("  java -jar SonosControl.jar <cmd> <cmdoptions>");
    			System.out.println("where <cmd> is one of:");
    			System.out.println("  help\tPrints this help");
    			System.out.println("  show <zone>\tShow some information about the given zone");
    			System.out.println("  stop <zone>\tStop playing in the given zone");
    			System.out.println("  start <zone>\tStart playing in the given zone");
    			System.out.println("  mute <zone> [on|off]\tMute the given zone");
    			System.out.println("");
    			System.out.println("Example:");
    			System.out.println("  java -jar SonosControl.jar show Wohnzimmer");
    			System.out.println("");
    			System.exit(-1);
    			return null;
    		}
    		
    		@Override
    		public Void visitShow(ShowArgs args) {
    			return execute(new ShowCommand(args));
    		}
    		@Override
    		public Void visitMute(final MuteArgs args) {
    			return execute(new MuteCommand(args));
    		}
    		@Override
    		public Void visitStart(StartArgs args) {
    			return execute(new StartCommand(args));
    		}
    		@Override
    		public Void visitStop(StopArgs args) {
    			return execute(new StopCommand(args));
    		}
		});
    }
    
}