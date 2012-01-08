package de.kalass.sonoscontrol.api.control;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

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
import de.kalass.sonoscontrol.api.services.ZoneGroupTopologyService;

public interface SonosDevice {

    @Nonnull
    ZoneName getZoneName();

    @Nonnull
    AlarmClockService getAlarmClockService();

    @CheckForNull
    AudioInService getAudioInService();

    @Nonnull
    AVTransportService getAVTransportService();

    @CheckForNull
    ConnectionManagerService getConnectionManagerService();

    @Nonnull
    DevicePropertiesService getDevicePropertiesService();

    @Nonnull
    GroupManagementService getGroupManagementService();

    @Nonnull
    MusicServicesService getMusicServicesService();

    @Nonnull
    RenderingControlService getRenderingControlService();

    @Nonnull
    SystemPropertiesService getSystemPropertiesService();

    @Nonnull
    ZoneGroupTopologyService getZoneGroupTopologyService();
}
