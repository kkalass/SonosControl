package de.kalass.sonoscontrol.clingimpl;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.services.AVTransportService;

@SuppressWarnings("rawtypes")
public class AVTransportServiceImpl extends AbstractServiceImpl implements AVTransportService {
	//private static final Logger LOG = LoggerFactory.getLogger(RenderingControlServiceImpl.class);
	
	public AVTransportServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
		super("AVTransport", upnpService, device, errorStrategy);
	}

	@Override
	public <C extends Callback0> C stop(C successHandler) {
		return execute(successHandler, new Call0("Stop") {
			@Override
			public void prepareArguments(ActionInvocation invocation)
					throws InvalidValueException {
				// Throws InvalidValueException if the value is of wrong type
				invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(0l));
			}
			
		});		
	}
	
	@Override
	public <C extends Callback0> C play(C successHandler) {
		return execute(successHandler, new Call0("Play") {
			@Override
			public void prepareArguments(ActionInvocation invocation)
					throws InvalidValueException {
				// Throws InvalidValueException if the value is of wrong type
				invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(0l));
				invocation.setInput("Speed", "1");
			}
			
		});		
	}
}
