/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;
import javax.annotation.CheckForNull;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology.UpdateItem;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.DiagnosticID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.CachedOnly;
import de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology.AvailableSoftwareUpdate;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateFlags;
import de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology.ZoneGroupState;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateURL;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.Version;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UnresponsiveDeviceActionType;
import de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology.ThirdPartyMediaServers;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.AlarmRunSequence;

public interface ZoneGroupTopologyService {


    @CheckForNull
    AvailableSoftwareUpdate getLastValueForAvailableSoftwareUpdate();

    void addAvailableSoftwareUpdateListener(EventListener<AvailableSoftwareUpdate> listener);

    void removeAvailableSoftwareUpdateListener(EventListener<AvailableSoftwareUpdate> listener);

    @CheckForNull
    ZoneGroupState getLastValueForZoneGroupState();

    void addZoneGroupStateListener(EventListener<ZoneGroupState> listener);

    void removeZoneGroupStateListener(EventListener<ZoneGroupState> listener);

    @CheckForNull
    ThirdPartyMediaServers getLastValueForThirdPartyMediaServers();

    void addThirdPartyMediaServersListener(EventListener<ThirdPartyMediaServers> listener);

    void removeThirdPartyMediaServersListener(EventListener<ThirdPartyMediaServers> listener);

    @CheckForNull
    AlarmRunSequence getLastValueForAlarmRunSequence();

    void addAlarmRunSequenceListener(EventListener<AlarmRunSequence> listener);

    void removeAlarmRunSequenceListener(EventListener<AlarmRunSequence> listener);


    <C extends Callback1<UpdateItem>> C checkForUpdate(UpdateType updateType, CachedOnly cachedOnly, Version version, C callback);

    <C extends Callback0> C beginSoftwareUpdate(UpdateURL updateURL, UpdateFlags flags, C callback);

    <C extends Callback0> C reportUnresponsiveDevice(MemberID deviceUUID, UnresponsiveDeviceActionType desiredAction, C callback);

    <C extends Callback0> C reportAlarmStartedRunning(C callback);

    <C extends Callback1<DiagnosticID>> C submitDiagnostics(C callback);

}
