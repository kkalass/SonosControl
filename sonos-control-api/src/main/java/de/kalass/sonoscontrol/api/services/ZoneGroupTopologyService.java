/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateItem;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.DiagnosticID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.CachedOnly;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.AvailableSoftwareUpdate;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateFlags;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroupState;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateURL;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.Version;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UnresponsiveDeviceActionType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ThirdPartyMediaServers;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.AlarmRunSequence;

public interface ZoneGroupTopologyService {


    AvailableSoftwareUpdate getAvailableSoftwareUpdate();

    ZoneGroupState getZoneGroupState();

    ThirdPartyMediaServers getThirdPartyMediaServers();

    AlarmRunSequence getAlarmRunSequence();


    <C extends Callback1<UpdateItem>> C checkForUpdate(UpdateType updateType, CachedOnly cachedOnly, Version version, C callback);

    <C extends Callback0> C beginSoftwareUpdate(UpdateURL updateURL, UpdateFlags flags, C callback);

    <C extends Callback0> C reportUnresponsiveDevice(MemberID deviceUUID, UnresponsiveDeviceActionType desiredAction, C callback);

    <C extends Callback0> C reportAlarmStartedRunning(C callback);

    <C extends Callback1<DiagnosticID>> C submitDiagnostics(C callback);

}
