package de.kalass.sonoscontrol.clingimpl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.teleal.cling.UpnpService;
import org.teleal.cling.controlpoint.ActionCallback;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.message.UpnpResponse;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.meta.Service;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.ServiceId;
import org.teleal.cling.model.types.UDAServiceId;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.core.ZoneIcon;
import de.kalass.sonoscontrol.api.core.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;

@SuppressWarnings("rawtypes")
public class DevicePropertiesServiceImpl implements DevicePropertiesService {
	private static final Logger LOG = LoggerFactory.getLogger(DevicePropertiesServiceImpl.class);
	
	private static final ServiceId SERVICE_ID = new UDAServiceId("DeviceProperties");
	
	private final UpnpService _upnpService;
	private final Device _device;

	private final ErrorStrategy _errorStrategy;

	static class GetZoneAttributesInvocation extends ActionInvocation {

        @SuppressWarnings("unchecked")
		GetZoneAttributesInvocation(Service service) {
            super(service.getAction("GetZoneAttributes"));
            try {

                // Throws InvalidValueException if the value is of wrong type
                //setInput("NewTargetValue", true);

            } catch (InvalidValueException ex) {
                System.err.println(ex.getMessage());
                System.exit(1);
            }
        }
    }
	
	public DevicePropertiesServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
		this._upnpService = upnpService;
		this._device = device;
		this._errorStrategy = errorStrategy;
	}

	@Override
	public void retrieveZoneAttributes(final RetrieveZoneAttributes successHandler) {
		Service devicePropertiesService;
		if ((devicePropertiesService = this._device.findService(SERVICE_ID)) != null) {

			ActionInvocation actionInvocation =
					new GetZoneAttributesInvocation(devicePropertiesService);

			// Executes asynchronous in the background
			this._upnpService.getControlPoint().execute(
					new ActionCallback(actionInvocation) {

						@Override
						public void success(ActionInvocation invocation) {
							//assert invocation.getOutput().length == 0;
							final ActionArgumentValue[] output = invocation.getOutput();
							final ZoneName currentZoneName = ZoneName.getInstance((String)output[0].getValue());
							final ZoneIcon currentIcon = ZoneIcon.getInstance((String)output[1].getValue());
							LOG.debug("Successfully called action! " + Arrays.toString(output));
							successHandler.success(currentZoneName, currentIcon);
						}

						@Override
						public void failure(ActionInvocation invocation, UpnpResponse operation, String defaultMsg) {
							_errorStrategy.onFailure(successHandler, defaultMsg);
						}
					}
					);
		}
	}
}
