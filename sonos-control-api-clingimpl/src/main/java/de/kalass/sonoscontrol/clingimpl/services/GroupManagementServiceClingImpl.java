/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.GroupManagementService;
import de.kalass.sonoscontrol.api.core.EventListener;

import org.teleal.cling.model.gena.GENASubscription;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.state.StateVariableValue;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.google.common.base.Objects;

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
public final class GroupManagementServiceClingImpl extends AbstractServiceImpl implements GroupManagementService {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(GroupManagementServiceClingImpl.class);
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();
    
    private final List<EventListener<LocalGroupUUID>> _changeLocalGroupUUIDListeners = new ArrayList<EventListener<LocalGroupUUID>>();
    private final List<EventListener<ResetVolumeAfter>> _changeResetVolumeAfterListeners = new ArrayList<EventListener<ResetVolumeAfter>>();
    private final List<EventListener<GroupCoordinatorIsLocal>> _changeGroupCoordinatorIsLocalListeners = new ArrayList<EventListener<GroupCoordinatorIsLocal>>();
    private final List<EventListener<VolumeAVTransportURI>> _changeVolumeAVTransportURIListeners = new ArrayList<EventListener<VolumeAVTransportURI>>();

    public GroupManagementServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("GroupManagement", upnpService, device, errorStrategy);
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
                final ActionArgumentValue[] output = invocation.getOutput();
                final TransportSettings currentTransportSettings = TransportSettings.getInstance((String)getValue("string",output[0].getValue()));
                final LocalGroupUUID groupUUIDJoined = LocalGroupUUID.getInstance((String)getValue("string",output[1].getValue()));
                final ResetVolumeAfter resetVolumeAfter = ResetVolumeAfter.getInstance((Boolean)getValue("boolean",output[2].getValue()));
                final VolumeAVTransportURI volumeAVTransportURI = VolumeAVTransportURI.getInstance((String)getValue("string",output[3].getValue()));
                final AddMemberResult value = AddMemberResult.getInstance(currentTransportSettings,groupUUIDJoined,resetVolumeAfter,volumeAVTransportURI);
                handler.success(value);
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
                // no return values
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
                // no return values
                handler.success();
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        LocalGroupUUID newLocalGroupUUID = null;
        LocalGroupUUID oldLocalGroupUUID = (LocalGroupUUID)stored.get("LocalGroupUUID");
        try {
        newLocalGroupUUID = convertLocalGroupUUID((String)getValue("string", ((StateVariableValue)values.get("LocalGroupUUID")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for LocalGroupUUID, will ignore", e);
            // make sure the value is not changed/overridden
            newLocalGroupUUID = null;
            oldLocalGroupUUID = null;
        }
        if (!Objects.equal(oldLocalGroupUUID, newLocalGroupUUID)) {
            _eventedValues.put("LocalGroupUUID", newLocalGroupUUID);
        }

        ResetVolumeAfter newResetVolumeAfter = null;
        ResetVolumeAfter oldResetVolumeAfter = (ResetVolumeAfter)stored.get("ResetVolumeAfter");
        try {
        newResetVolumeAfter = convertResetVolumeAfter((Boolean)getValue("boolean", ((StateVariableValue)values.get("ResetVolumeAfter")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for ResetVolumeAfter, will ignore", e);
            // make sure the value is not changed/overridden
            newResetVolumeAfter = null;
            oldResetVolumeAfter = null;
        }
        if (!Objects.equal(oldResetVolumeAfter, newResetVolumeAfter)) {
            _eventedValues.put("ResetVolumeAfter", newResetVolumeAfter);
        }

        GroupCoordinatorIsLocal newGroupCoordinatorIsLocal = null;
        GroupCoordinatorIsLocal oldGroupCoordinatorIsLocal = (GroupCoordinatorIsLocal)stored.get("GroupCoordinatorIsLocal");
        try {
        newGroupCoordinatorIsLocal = convertGroupCoordinatorIsLocal((Boolean)getValue("boolean", ((StateVariableValue)values.get("GroupCoordinatorIsLocal")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for GroupCoordinatorIsLocal, will ignore", e);
            // make sure the value is not changed/overridden
            newGroupCoordinatorIsLocal = null;
            oldGroupCoordinatorIsLocal = null;
        }
        if (!Objects.equal(oldGroupCoordinatorIsLocal, newGroupCoordinatorIsLocal)) {
            _eventedValues.put("GroupCoordinatorIsLocal", newGroupCoordinatorIsLocal);
        }

        VolumeAVTransportURI newVolumeAVTransportURI = null;
        VolumeAVTransportURI oldVolumeAVTransportURI = (VolumeAVTransportURI)stored.get("VolumeAVTransportURI");
        try {
        newVolumeAVTransportURI = convertVolumeAVTransportURI((String)getValue("string", ((StateVariableValue)values.get("VolumeAVTransportURI")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for VolumeAVTransportURI, will ignore", e);
            // make sure the value is not changed/overridden
            newVolumeAVTransportURI = null;
            oldVolumeAVTransportURI = null;
        }
        if (!Objects.equal(oldVolumeAVTransportURI, newVolumeAVTransportURI)) {
            _eventedValues.put("VolumeAVTransportURI", newVolumeAVTransportURI);
        }

        // after the values were updated, send the change notifications

        if (!Objects.equal(oldLocalGroupUUID, newLocalGroupUUID)) {
            notifyLocalGroupUUIDChanged(oldLocalGroupUUID, newLocalGroupUUID);
        }

        if (!Objects.equal(oldResetVolumeAfter, newResetVolumeAfter)) {
            notifyResetVolumeAfterChanged(oldResetVolumeAfter, newResetVolumeAfter);
        }

        if (!Objects.equal(oldGroupCoordinatorIsLocal, newGroupCoordinatorIsLocal)) {
            notifyGroupCoordinatorIsLocalChanged(oldGroupCoordinatorIsLocal, newGroupCoordinatorIsLocal);
        }

        if (!Objects.equal(oldVolumeAVTransportURI, newVolumeAVTransportURI)) {
            notifyVolumeAVTransportURIChanged(oldVolumeAVTransportURI, newVolumeAVTransportURI);
        }
    }

    protected Object getEventedValueOrWait(String key) {
        try {
            _eventsReceivedLatch.await();
        } catch (InterruptedException e) {
            LOG.warn("waiting for evented value countdown latch was interrupted, will continue");
        }
        return _eventedValues.get(key);
    }


    public LocalGroupUUID getLocalGroupUUID() {
        return (LocalGroupUUID)getEventedValueOrWait("LocalGroupUUID");
    }

    public void addLocalGroupUUIDListener(EventListener<LocalGroupUUID> listener) {
        synchronized(_changeLocalGroupUUIDListeners) {
            _changeLocalGroupUUIDListeners.add(listener);
        }
    }

    public void removeLocalGroupUUIDListener(EventListener<LocalGroupUUID> listener) {
        synchronized(_changeLocalGroupUUIDListeners) {
            _changeLocalGroupUUIDListeners.remove(listener);
        }
    }

    protected void notifyLocalGroupUUIDChanged(LocalGroupUUID oldValue, LocalGroupUUID newValue) {
        final Iterable<EventListener<LocalGroupUUID>> listeners;
        synchronized(_changeLocalGroupUUIDListeners) {
            listeners = new ArrayList<EventListener<LocalGroupUUID>>(_changeLocalGroupUUIDListeners);            
        }
        for(EventListener<LocalGroupUUID> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  LocalGroupUUID convertLocalGroupUUID(String rawValue) {
        return LocalGroupUUID.getInstance(rawValue);
    }

    public ResetVolumeAfter getResetVolumeAfter() {
        return (ResetVolumeAfter)getEventedValueOrWait("ResetVolumeAfter");
    }

    public void addResetVolumeAfterListener(EventListener<ResetVolumeAfter> listener) {
        synchronized(_changeResetVolumeAfterListeners) {
            _changeResetVolumeAfterListeners.add(listener);
        }
    }

    public void removeResetVolumeAfterListener(EventListener<ResetVolumeAfter> listener) {
        synchronized(_changeResetVolumeAfterListeners) {
            _changeResetVolumeAfterListeners.remove(listener);
        }
    }

    protected void notifyResetVolumeAfterChanged(ResetVolumeAfter oldValue, ResetVolumeAfter newValue) {
        final Iterable<EventListener<ResetVolumeAfter>> listeners;
        synchronized(_changeResetVolumeAfterListeners) {
            listeners = new ArrayList<EventListener<ResetVolumeAfter>>(_changeResetVolumeAfterListeners);            
        }
        for(EventListener<ResetVolumeAfter> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  ResetVolumeAfter convertResetVolumeAfter(Boolean rawValue) {
        return ResetVolumeAfter.getInstance(rawValue);
    }
    

    public GroupCoordinatorIsLocal getGroupCoordinatorIsLocal() {
        return (GroupCoordinatorIsLocal)getEventedValueOrWait("GroupCoordinatorIsLocal");
    }

    public void addGroupCoordinatorIsLocalListener(EventListener<GroupCoordinatorIsLocal> listener) {
        synchronized(_changeGroupCoordinatorIsLocalListeners) {
            _changeGroupCoordinatorIsLocalListeners.add(listener);
        }
    }

    public void removeGroupCoordinatorIsLocalListener(EventListener<GroupCoordinatorIsLocal> listener) {
        synchronized(_changeGroupCoordinatorIsLocalListeners) {
            _changeGroupCoordinatorIsLocalListeners.remove(listener);
        }
    }

    protected void notifyGroupCoordinatorIsLocalChanged(GroupCoordinatorIsLocal oldValue, GroupCoordinatorIsLocal newValue) {
        final Iterable<EventListener<GroupCoordinatorIsLocal>> listeners;
        synchronized(_changeGroupCoordinatorIsLocalListeners) {
            listeners = new ArrayList<EventListener<GroupCoordinatorIsLocal>>(_changeGroupCoordinatorIsLocalListeners);            
        }
        for(EventListener<GroupCoordinatorIsLocal> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  GroupCoordinatorIsLocal convertGroupCoordinatorIsLocal(Boolean rawValue) {
        return GroupCoordinatorIsLocal.getInstance(rawValue);
    }

    public VolumeAVTransportURI getVolumeAVTransportURI() {
        return (VolumeAVTransportURI)getEventedValueOrWait("VolumeAVTransportURI");
    }

    public void addVolumeAVTransportURIListener(EventListener<VolumeAVTransportURI> listener) {
        synchronized(_changeVolumeAVTransportURIListeners) {
            _changeVolumeAVTransportURIListeners.add(listener);
        }
    }

    public void removeVolumeAVTransportURIListener(EventListener<VolumeAVTransportURI> listener) {
        synchronized(_changeVolumeAVTransportURIListeners) {
            _changeVolumeAVTransportURIListeners.remove(listener);
        }
    }

    protected void notifyVolumeAVTransportURIChanged(VolumeAVTransportURI oldValue, VolumeAVTransportURI newValue) {
        final Iterable<EventListener<VolumeAVTransportURI>> listeners;
        synchronized(_changeVolumeAVTransportURIListeners) {
            listeners = new ArrayList<EventListener<VolumeAVTransportURI>>(_changeVolumeAVTransportURIListeners);            
        }
        for(EventListener<VolumeAVTransportURI> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  VolumeAVTransportURI convertVolumeAVTransportURI(String rawValue) {
        return VolumeAVTransportURI.getInstance(rawValue);
    }
    
    
}
