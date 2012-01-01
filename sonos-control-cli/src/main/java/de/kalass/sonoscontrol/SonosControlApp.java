package de.kalass.sonoscontrol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosControl.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.LoggingErrorStrategy;
import de.kalass.sonoscontrol.cli.arguments.Arguments;
import de.kalass.sonoscontrol.cli.arguments.ArgumentsVisitor;
import de.kalass.sonoscontrol.cli.arguments.GroupZoneSpec;
import de.kalass.sonoscontrol.cli.arguments.HelpArgs;
import de.kalass.sonoscontrol.cli.arguments.MuteArgs;
import de.kalass.sonoscontrol.cli.arguments.ShowArgs;
import de.kalass.sonoscontrol.cli.arguments.SingleZoneSpec;
import de.kalass.sonoscontrol.cli.arguments.StartArgs;
import de.kalass.sonoscontrol.cli.arguments.StopArgs;
import de.kalass.sonoscontrol.cli.arguments.ZoneSpec;
import de.kalass.sonoscontrol.cli.arguments.ZoneSpecVisitor;
import de.kalass.sonoscontrol.cli.commands.CliCommandResultCallback;
import de.kalass.sonoscontrol.cli.commands.MuteCommand;
import de.kalass.sonoscontrol.cli.commands.ShowCommand;
import de.kalass.sonoscontrol.cli.commands.SonosDeviceCommand;
import de.kalass.sonoscontrol.cli.commands.StartCommand;
import de.kalass.sonoscontrol.cli.commands.StopCommand;
import de.kalass.sonoscontrol.clingimpl.SonosControlClingImpl;

public class SonosControlApp {
	private static final Logger LOG = LoggerFactory.getLogger(SonosControlApp.class);

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
    	
    	final ZoneSpec zoneSpec = command.getZoneSpec();
    	zoneSpec.invite(new ZoneSpecVisitor<Void>() {
    		@Override
    		public Void visitGroup(GroupZoneSpec spec) {
    			// TODO Auto-generated method stub
    			return null;
    		}
    		@Override
    		public Void visitSingleZone(final SingleZoneSpec spec) {
    			sonosControl.executeOnZone(spec.getZoneName(), new SonosDeviceCallback() {
    				
    				@Override
    				public void success(SonosDevice device) {
    					LOG.debug("Found  Sonos device " + device.getZoneName());
    					Preconditions.checkState(device.getZoneName().equals(spec.getZoneName()));
    					try {
    						command.call(device, finish);
    					} catch(Throwable t) {
    						finish.fail(t);
    					}
    				}
    			});    			
    			return null;
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