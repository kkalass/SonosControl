package de.kalass.sonoscontrol.clingimpl;

import javax.annotation.Nonnull;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;

public class SonosDeviceImpl implements SonosDevice {

	private final DevicePropertiesService _propsService;
	private final ZoneName _zoneName;
	private final Device _device;
	private final UpnpService _service;

	@SuppressWarnings("rawtypes")
	SonosDeviceImpl(@Nonnull ZoneName zoneName, @Nonnull DevicePropertiesService propsService, @Nonnull UpnpService service, @Nonnull Device device) {
		this._zoneName = zoneName;
		this._propsService = propsService;
		this._service = service;
		this._device = device;
	}
	
	@Override
	public ZoneName getZoneName() {
		return _zoneName;
	}
	
	@Override
	public DevicePropertiesService getDevicePropertiesService() {
		return _propsService;
	}
}
