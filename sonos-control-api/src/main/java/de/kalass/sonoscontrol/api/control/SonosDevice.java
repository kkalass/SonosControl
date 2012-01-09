package de.kalass.sonoscontrol.api.control;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

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
     * The ConnectionManager Service of the MediaRenderer (sub)device.
     */
    @CheckForNull
    ConnectionManagerService getMediaRendererConnectionManagerService();

    /**
     * The ConnectionManager Service of the MediaServer (sub)device.
     */
    @CheckForNull
    ConnectionManagerService getConnectionManagerService();

    @Nonnull
    ContentDirectoryService getContentDirectoryService();

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
