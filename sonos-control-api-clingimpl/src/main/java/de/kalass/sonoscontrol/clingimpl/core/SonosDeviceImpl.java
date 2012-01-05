package de.kalass.sonoscontrol.clingimpl.core;

import javax.annotation.Nonnull;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.api.services.AVTransportService;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.RenderingControlService;
import de.kalass.sonoscontrol.clingimpl.AVTransportServiceImpl;
import de.kalass.sonoscontrol.clingimpl.RenderingControlServiceImpl;

public class SonosDeviceImpl implements SonosDevice {

    private final DevicePropertiesService _propsService;
    private final ZoneName _zoneName;
    @SuppressWarnings("rawtypes")
    private final Device _device;
    private final UpnpService _service;
    private final ErrorStrategy _errorStrategy;

    @SuppressWarnings("rawtypes")
    SonosDeviceImpl(@Nonnull ZoneName zoneName, @Nonnull DevicePropertiesService propsService,
            @Nonnull UpnpService service, @Nonnull Device device, @Nonnull ErrorStrategy errorStrategy) {
        this._zoneName = zoneName;
        this._propsService = propsService;
        this._service = service;
        this._device = device;
        this._errorStrategy = errorStrategy;
    }

    @Override
    public ZoneName getZoneName() {
        return _zoneName;
    }

    @Override
    public DevicePropertiesService getDevicePropertiesService() {
        return _propsService;
    }

    @Override
    public RenderingControlService getRenderingControlService() {
        return new RenderingControlServiceImpl(_service, _device, _errorStrategy);
    }
    @Override
    public AVTransportService getAVTransportService() {
        return new AVTransportServiceImpl(_service, _device, _errorStrategy);
    }
}
