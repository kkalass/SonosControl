package de.kalass.sonoscontrol.api.control;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import de.kalass.sonoscontrol.api.model.MemberID;
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
    MemberID getDeviceId();

    @Nonnull
    ZoneName getZoneName();

    @Nonnull
    AlarmClockService getAlarmClockService();

    /**
     * Some Sonos Player devices do not have this service (I believe the Play:3 does not have it).
     * @return
     */
    @CheckForNull
    AudioInService getAudioInService();

    @Nonnull
    AVTransportService getAVTransportService();

    /**
     * Please note: ConnectionManager is announced, but not actually available at least on my Sonos Systems (Play:3, ZP-90 and ZP-120) (KK, 07.01.2012).
     */
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
