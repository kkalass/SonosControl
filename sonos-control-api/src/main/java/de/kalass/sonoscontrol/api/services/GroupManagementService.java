/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.groupmanagement.AddMemberResult;
import de.kalass.sonoscontrol.api.model.groupmanagement.LocalGroupUUID;
import de.kalass.sonoscontrol.api.model.groupmanagement.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.groupmanagement.GroupCoordinatorIsLocal;
import de.kalass.sonoscontrol.api.model.groupmanagement.VolumeAVTransportURI;
import de.kalass.sonoscontrol.api.model.groupmanagement.BufferingResultCode;
import de.kalass.sonoscontrol.api.model.groupmanagement.TransportSettings;

public interface GroupManagementService {


    LocalGroupUUID getLocalGroupUUID();

    void addLocalGroupUUIDListener(EventListener<LocalGroupUUID> listener);

    void removeLocalGroupUUIDListener(EventListener<LocalGroupUUID> listener);

    ResetVolumeAfter getResetVolumeAfter();

    void addResetVolumeAfterListener(EventListener<ResetVolumeAfter> listener);

    void removeResetVolumeAfterListener(EventListener<ResetVolumeAfter> listener);

    GroupCoordinatorIsLocal getGroupCoordinatorIsLocal();

    void addGroupCoordinatorIsLocalListener(EventListener<GroupCoordinatorIsLocal> listener);

    void removeGroupCoordinatorIsLocalListener(EventListener<GroupCoordinatorIsLocal> listener);

    VolumeAVTransportURI getVolumeAVTransportURI();

    void addVolumeAVTransportURIListener(EventListener<VolumeAVTransportURI> listener);

    void removeVolumeAVTransportURIListener(EventListener<VolumeAVTransportURI> listener);


    <C extends Callback1<AddMemberResult>> C addMember(MemberID memberID, C callback);

    <C extends Callback0> C removeMember(MemberID memberID, C callback);

    <C extends Callback0> C reportTrackBufferingResult(MemberID memberID, BufferingResultCode resultCode, C callback);

}
