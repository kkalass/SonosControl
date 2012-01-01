package de.kalass.sonoscontrol.clingimpl;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.types.UnsignedIntegerTwoBytes;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Bass;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Channel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ChannelMap;
import de.kalass.sonoscontrol.api.model.renderingcontrol.EQType;
import de.kalass.sonoscontrol.api.model.renderingcontrol.EQValue;
import de.kalass.sonoscontrol.api.model.renderingcontrol.HeadphoneConnected;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Loudness;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Mute;
import de.kalass.sonoscontrol.api.model.renderingcontrol.MuteChannel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.OutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ProgramURI;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RampTimeSeconds;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RampType;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ResetBasicEQResult;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.renderingcontrol.SupportsOutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Treble;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Volume;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeAdjustment;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeDB;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeDBRange;
import de.kalass.sonoscontrol.api.services.RenderingControlService;

@SuppressWarnings("rawtypes")
public class RenderingControlServiceImpl extends AbstractServiceImpl implements RenderingControlService {
	private static final UnsignedIntegerFourBytes INSTANCE_ID = new UnsignedIntegerFourBytes(0l);


	//private static final Logger LOG = LoggerFactory.getLogger(RenderingControlServiceImpl.class);
	
	public RenderingControlServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
		super("RenderingControl", upnpService, device, errorStrategy);
	}

	@Override
	public <C extends Callback1<Volume>> C getVolume(final Channel channel, final C successHandler) {
		return execute(successHandler, new Call1<Volume>("GetVolume") {
			@Override
			public void prepareArguments(ActionInvocation invocation)
					throws InvalidValueException {
				// Throws InvalidValueException if the value is of wrong type
				invocation.setInput("Channel", channel.getSonosValue());
				invocation.setInput("InstanceID", INSTANCE_ID);
			}
			@Override
			public void success(Callback1<Volume> handler, ActionArgumentValue p) {
				final UnsignedIntegerTwoBytes volume = (UnsignedIntegerTwoBytes)p.getValue();
				successHandler.success(Volume.valueOf(volume.getValue()));
			}
		});
	}
	
	@Override
	public <C extends Callback1<Mute>> C getMute(final MuteChannel channel,final C successHandler) {
		
		// FIXME: do something about the hard coded channel and instance params...
		
		return execute(successHandler, new Call1<Mute>("GetMute") {
			@Override
			public void prepareArguments(ActionInvocation invocation)
					throws InvalidValueException {
				// Throws InvalidValueException if the value is of wrong type
				invocation.setInput("Channel", channel.getSonosValue());
				invocation.setInput("InstanceID", INSTANCE_ID);
			}
			@Override
			public void success(Callback1<Mute> handler, ActionArgumentValue p) {
				final Boolean mute = (Boolean)p.getValue();
				successHandler.success(Mute.valueOf(mute));
			}
		});
	}
	
	
	@Override
	public <C extends Callback0> C setMute(final MuteChannel channel, final Mute mute, C successHandler) {
		return execute(successHandler, new Call0("SetMute") {
			@Override
			public void prepareArguments(ActionInvocation invocation)
					throws InvalidValueException {
				// Throws InvalidValueException if the value is of wrong type
				invocation.setInput("Channel", channel.getSonosValue());
				invocation.setInput("InstanceID", INSTANCE_ID);
				invocation.setInput("DesiredMute", Boolean.valueOf(mute.asBoolean()));
			}
			
		});		
	}

	@Override
	public <C extends Callback1<ResetBasicEQResult>> C resetBasicEQ(C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C resetExtEQ(EQType eQType, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C setVolume(Channel channel,
			Volume desiredVolume, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<Volume>> C setRelativeVolume(Channel channel,
			VolumeAdjustment adjustment, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<VolumeDB>> C getVolumeDB(Channel channel,
			C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C setVolumeDB(Channel channel,
			VolumeDB desiredVolume, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<VolumeDBRange>> C getVolumeDBRange(
			Channel channel, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<Bass>> C getBass(C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C setBass(Bass desiredBass, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<Treble>> C getTreble(C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C setTreble(Treble desiredTreble, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<EQValue>> C getEQ(EQType eQType, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C setEQ(EQType eQType, EQValue desiredValue,
			C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<Loudness>> C getLoudness(Channel channel,
			C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C setLoudness(Channel channel,
			Loudness desiredLoudness, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<SupportsOutputFixed>> C getSupportsOutputFixed(
			C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<OutputFixed>> C getOutputFixed(C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C setOutputFixed(OutputFixed desiredFixed,
			C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<HeadphoneConnected>> C getHeadphoneConnected(
			C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback1<RampTimeSeconds>> C rampToVolume(
			Channel channel, RampType rampType, Volume desiredVolume,
			ResetVolumeAfter resetVolumeAfter, ProgramURI programURI, C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C restoreVolumePriorToRamp(Channel channel,
			C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <C extends Callback0> C setChannelMap(ChannelMap channelMap,
			C callback) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
