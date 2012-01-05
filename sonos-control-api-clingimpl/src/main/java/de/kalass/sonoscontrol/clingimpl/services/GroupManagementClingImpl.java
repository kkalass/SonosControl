

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

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

@SuppressWarnings("rawtypes")
public final class GroupManagementClingImpl extends AbstractServiceImpl {

    public GroupManagementClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("GroupManagement", upnpService, device, errorStrategy);
    }


    public LocalGroupUUID getLocalGroupUUID() {
        throw new UnsupportedOperationException();
    }

    public ResetVolumeAfter getResetVolumeAfter() {
        throw new UnsupportedOperationException();
    }

    public GroupCoordinatorIsLocal getGroupCoordinatorIsLocal() {
        throw new UnsupportedOperationException();
    }

    public VolumeAVTransportURI getVolumeAVTransportURI() {
        throw new UnsupportedOperationException();
    }


    public <C extends Callback1<AddMemberResult>> C addMember(final MemberID memberID, final C successHandler) {
        return execute(successHandler, new Call<C>("AddMember") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "MemberID", memberID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                handler.success();
            }
        });
    }

    public <C extends Callback0> C removeMember(final MemberID memberID, final C successHandler) {
        return execute(successHandler, new Call<C>("RemoveMember") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "MemberID", memberID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                handler.success();
            }
        });
    }

    public <C extends Callback0> C reportTrackBufferingResult(final MemberID memberID, final BufferingResultCode resultCode, final C successHandler) {
        return execute(successHandler, new Call<C>("ReportTrackBufferingResult") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "MemberID", memberID.getValue());
                setInput(invocation,"i4", "ResultCode", resultCode.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                handler.success();
            }
        });
    }

}
