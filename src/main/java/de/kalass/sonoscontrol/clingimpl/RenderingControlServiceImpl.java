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
import de.kalass.sonoscontrol.api.services.RenderingControlService;

@SuppressWarnings("rawtypes")
public class RenderingControlServiceImpl extends AbstractServiceImpl implements RenderingControlService {
	//private static final Logger LOG = LoggerFactory.getLogger(RenderingControlServiceImpl.class);
	
	public RenderingControlServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
		super("RenderingControl", upnpService, device, errorStrategy);
	}

	@Override
	public void retrieveVolume(final Callback1<Long> successHandler) {
		execute(new Call1<Long>("GetVolume", successHandler) {
			@Override
			public void prepareArguments(ActionInvocation invocation)
					throws InvalidValueException {
				// Throws InvalidValueException if the value is of wrong type
				invocation.setInput("Channel", "Master" /* Master/LF/RF*/);
				invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(0l));
			}
			@Override
			public void success(Callback1<Long> handler, ActionArgumentValue p) {
				final UnsignedIntegerTwoBytes volume = (UnsignedIntegerTwoBytes)p.getValue();
				successHandler.success(volume.getValue());
			}
		});
	}
	
	@Override
	public void retrieveMute(final Callback1<Boolean> successHandler) {
		
		// FIXME: do something about the hard coded channel and instance params...
		
		execute(new Call1<Boolean>("GetMute", successHandler) {
			@Override
			public void prepareArguments(ActionInvocation invocation)
					throws InvalidValueException {
				// Throws InvalidValueException if the value is of wrong type
				invocation.setInput("Channel", "Master" /* Master/LF/RF*/);
				invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(0l));
			}
			@Override
			public void success(Callback1<Boolean> handler, ActionArgumentValue p) {
				final Boolean mute = (Boolean)p.getValue();
				successHandler.success(mute);
			}
		});
	}
	
	@Override
	public void setMute(final boolean mute, Callback0 successHandler) {
		execute(new Call0("SetMute", successHandler) {
			@Override
			public void prepareArguments(ActionInvocation invocation)
					throws InvalidValueException {
				// Throws InvalidValueException if the value is of wrong type
				invocation.setInput("Channel", "Master" /* Master/LF/RF*/);
				invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(0l));
				invocation.setInput("DesiredMute", Boolean.valueOf(mute));
			}
			
		});		
	}
}
