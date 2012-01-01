package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.groupmanagement.AddMemberResult;
import de.kalass.sonoscontrol.api.model.groupmanagement.BufferingResultCode;
import de.kalass.sonoscontrol.api.model.groupmanagement.MemberID;

public interface GroupManagementService {

    public <C extends Callback1<AddMemberResult>> C addMember(MemberID memberID, C callback);

    public <C extends Callback0> C removeMember(MemberID memberID, C callback);

    public <C extends Callback0> C reportTrackBufferingResult(MemberID memberID, BufferingResultCode resultCode, C callback);
}
