package de.kalass.sonoscontrol.clingimpl;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.core.Callback2;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.core.ZoneIcon;
import de.kalass.sonoscontrol.api.core.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;

@SuppressWarnings("rawtypes")
public class DevicePropertiesServiceImpl extends AbstractServiceImpl implements DevicePropertiesService {
	//private static final Logger LOG = LoggerFactory.getLogger(DevicePropertiesServiceImpl.class);
	
	public DevicePropertiesServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
		super("DeviceProperties", upnpService, device, errorStrategy);
	}

	@Override
	public void retrieveZoneAttributes(final Callback2<ZoneName, ZoneIcon> successHandler) {
		execute(new Call2<ZoneName, ZoneIcon>("GetZoneAttributes", successHandler) {
			@Override
			public void success(
					Callback2<ZoneName, ZoneIcon> handler,
					ActionArgumentValue p1, ActionArgumentValue p2) {
				final ZoneName currentZoneName = ZoneName.getInstance((String)p1.getValue());
				final ZoneIcon currentIcon = ZoneIcon.getInstance((String)p2.getValue());
				successHandler.success(currentZoneName, currentIcon);
			}
		});
	}
}
