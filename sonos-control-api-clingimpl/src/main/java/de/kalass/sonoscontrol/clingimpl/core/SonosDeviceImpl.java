package de.kalass.sonoscontrol.clingimpl.core;

import javax.annotation.Nonnull;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.api.services.AVTransportService;
import de.kalass.sonoscontrol.api.services.AlarmClockService;
import de.kalass.sonoscontrol.api.services.AudioInService;
import de.kalass.sonoscontrol.api.services.ConnectionManagerService;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.GroupManagementService;
import de.kalass.sonoscontrol.api.services.MusicServicesService;
import de.kalass.sonoscontrol.api.services.RenderingControlService;
import de.kalass.sonoscontrol.api.services.SystemPropertiesService;
import de.kalass.sonoscontrol.clingimpl.services.AVTransportServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.AlarmClockServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.AudioInServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.ConnectionManagerServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.GroupManagementServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.MusicServicesServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.RenderingControlServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.SystemPropertiesServiceClingImpl;

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
        return new RenderingControlServiceClingImpl(_service, _device, _errorStrategy);
    }
    @Override
    public AVTransportService getAVTransportService() {
        return new AVTransportServiceClingImpl(_service, _device, _errorStrategy);
    }

    @Override
    public AlarmClockService getAlarmClockService() {
        return new AlarmClockServiceClingImpl(_service, _device, _errorStrategy);
    }

    @Override
    public AudioInService getAudioInService() {
        return new AudioInServiceClingImpl(_service, _device, _errorStrategy);
    }

    @Override
    public ConnectionManagerService getConnectionManagerService() {
        return new ConnectionManagerServiceClingImpl(_service, _device, _errorStrategy);
    }

    @Override
    public GroupManagementService getGroupManagementService() {
        return new GroupManagementServiceClingImpl(_service, _device, _errorStrategy);
    }

    @Override
    public MusicServicesService getMusicServicesService() {
        return new MusicServicesServiceClingImpl(_service, _device, _errorStrategy);
    }

    @Override
    public SystemPropertiesService getSystemPropertiesService() {
        return new SystemPropertiesServiceClingImpl(_service, _device, _errorStrategy);
    }

}
