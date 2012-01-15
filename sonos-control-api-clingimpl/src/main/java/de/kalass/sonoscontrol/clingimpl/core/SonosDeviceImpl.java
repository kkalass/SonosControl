package de.kalass.sonoscontrol.clingimpl.core;

import javax.annotation.Nonnull;

import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.types.DeviceType;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.api.services.AVTransportService;
import de.kalass.sonoscontrol.api.services.AlarmClockService;
import de.kalass.sonoscontrol.api.services.AudioInService;
import de.kalass.sonoscontrol.api.services.ConnectionManagerService;
import de.kalass.sonoscontrol.api.services.ContentDirectoryService;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.GroupManagementService;
import de.kalass.sonoscontrol.api.services.MusicServicesService;
import de.kalass.sonoscontrol.api.services.RenderingControlService;
import de.kalass.sonoscontrol.api.services.SystemPropertiesService;
import de.kalass.sonoscontrol.api.services.ZoneGroupTopologyService;
import de.kalass.sonoscontrol.clingimpl.services.AVTransportServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.AlarmClockServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.AudioInServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.ConnectionManagerServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.ContentDirectoryServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.GroupManagementServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.MusicServicesServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.RenderingControlServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.SystemPropertiesServiceClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.ZoneGroupTopologyServiceClingImpl;

public class SonosDeviceImpl implements SonosDevice {

    private final DevicePropertiesService _propsService;
    private final ZoneName _zoneName;
    @SuppressWarnings("rawtypes")
    private final Device _device;
    private final UpnpService _service;
    private final ErrorStrategy _errorStrategy;
    private final MemberID _deviceId;

    @SuppressWarnings("rawtypes")
    SonosDeviceImpl(
            @Nonnull MemberID deviceId, @Nonnull ZoneName zoneName, @Nonnull DevicePropertiesService propsService,
            @Nonnull UpnpService service, @Nonnull Device device, @Nonnull ErrorStrategy errorStrategy) {
        _deviceId = deviceId;
        this._zoneName = zoneName;
        this._propsService = propsService;
        this._service = service;
        this._device = device;
        this._errorStrategy = errorStrategy;
    }

    @Override
    public MemberID getDeviceId() {
        return _deviceId;
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
        final RenderingControlServiceClingImpl service = new RenderingControlServiceClingImpl(_service, _device, _errorStrategy);
        return service.isAvailable() ? service : null;
    }
    @Override
    public AVTransportService getAVTransportService() {
        final AVTransportServiceClingImpl service = new AVTransportServiceClingImpl(_service, _device, _errorStrategy);
        return service.isAvailable() ? service : null;
    }

    @Override
    public AlarmClockService getAlarmClockService() {
        final AlarmClockServiceClingImpl service = new AlarmClockServiceClingImpl(_service, _device, _errorStrategy);
        return service.isAvailable() ? service : null;
    }

    @Override
    public AudioInService getAudioInService() {
        final AudioInServiceClingImpl service = new AudioInServiceClingImpl(_service, _device, _errorStrategy);
        return service.isAvailable() ? service : null;
    }

    @Override
    public ConnectionManagerService getMediaRendererConnectionManagerService() {
        @SuppressWarnings("rawtypes")
        Device mediaServerDevice = Preconditions.checkNotNull(_device.findDevices(DeviceType.valueOf("urn:schemas-upnp-org:device:MediaRenderer:1"))[0]);
        final ConnectionManagerServiceClingImpl service = new ConnectionManagerServiceClingImpl(_service, mediaServerDevice, _errorStrategy);
        return service.isAvailable() ? service : null;
    }

    @Override
    public ConnectionManagerService getConnectionManagerService() {
        @SuppressWarnings("rawtypes")
        Device mediaServerDevice = Preconditions.checkNotNull(_device.findDevices(DeviceType.valueOf("urn:schemas-upnp-org:device:MediaServer:1"))[0]);
        final ConnectionManagerServiceClingImpl service = new ConnectionManagerServiceClingImpl(_service, mediaServerDevice, _errorStrategy);
        return service.isAvailable() ? service : null;
    }
    @Override
    public ContentDirectoryService getContentDirectoryService() {
        @SuppressWarnings("rawtypes")
        Device mediaServerDevice = Preconditions.checkNotNull(_device.findDevices(DeviceType.valueOf("urn:schemas-upnp-org:device:MediaServer:1"))[0]);
        final ContentDirectoryServiceClingImpl service = new ContentDirectoryServiceClingImpl(_service, mediaServerDevice, _errorStrategy);
        return service.isAvailable() ? service : null;
    }

    @Override
    public GroupManagementService getGroupManagementService() {
        final GroupManagementServiceClingImpl service = new GroupManagementServiceClingImpl(_service, _device, _errorStrategy);
        return service.isAvailable() ? service : null;
    }

    @Override
    public MusicServicesService getMusicServicesService() {
        final MusicServicesServiceClingImpl service = new MusicServicesServiceClingImpl(_service, _device, _errorStrategy);
        return service.isAvailable() ? service : null;
    }

    @Override
    public SystemPropertiesService getSystemPropertiesService() {
        final SystemPropertiesServiceClingImpl service = new SystemPropertiesServiceClingImpl(_service, _device, _errorStrategy);
        return service.isAvailable() ? service : null;
    }

    @Override
    public ZoneGroupTopologyService getZoneGroupTopologyService() {
        final ZoneGroupTopologyServiceClingImpl service = new ZoneGroupTopologyServiceClingImpl(_service, _device, _errorStrategy);
        return service.isAvailable() ? service : null;
    }
}
