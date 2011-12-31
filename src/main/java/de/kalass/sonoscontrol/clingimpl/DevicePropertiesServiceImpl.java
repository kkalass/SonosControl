package de.kalass.sonoscontrol.clingimpl;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.ZoneAttributes;
import de.kalass.sonoscontrol.api.model.ZoneIcon;
import de.kalass.sonoscontrol.api.model.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;

@SuppressWarnings("rawtypes")
public class DevicePropertiesServiceImpl extends AbstractServiceImpl implements DevicePropertiesService {
	//private static final Logger LOG = LoggerFactory.getLogger(DevicePropertiesServiceImpl.class);
	
	public DevicePropertiesServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
		super("DeviceProperties", upnpService, device, errorStrategy);
	}

	@Override
	public <C extends Callback1<ZoneAttributes>> C retrieveZoneAttributes(final C successHandler) {
		return execute(successHandler, new Call2<ZoneAttributes>("GetZoneAttributes") {
			@Override
			public void success(
					Callback1<ZoneAttributes> handler,
					ActionArgumentValue p1, ActionArgumentValue p2) {
				final ZoneName currentZoneName = ZoneName.getInstance((String)p1.getValue());
				final ZoneIcon currentIcon = ZoneIcon.getInstance((String)p2.getValue());
				successHandler.success(new ZoneAttributes(currentZoneName, currentIcon));
			}
		});
	}
}
