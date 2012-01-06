

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.ZoneGroupTopologyService;
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
import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

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

@SuppressWarnings("rawtypes")
public final class ZoneGroupTopologyServiceClingImpl extends AbstractServiceImpl implements ZoneGroupTopologyService {
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();

    public ZoneGroupTopologyServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("ZoneGroupTopology", upnpService, device, errorStrategy);
    }


    public <C extends Callback1<UpdateItem>> C checkForUpdate(final UpdateType updateType, final CachedOnly cachedOnly, final Version version, final C successHandler) {
        return execute(successHandler, new Call<C>("CheckForUpdate") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "UpdateType", updateType.getValue());
                setInput(invocation,"boolean", "CachedOnly", cachedOnly.getValue());
                setInput(invocation,"string", "Version", version.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final UpdateItem value = UpdateItem.getInstance((String)getValue("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C beginSoftwareUpdate(final UpdateURL updateURL, final UpdateFlags flags, final C successHandler) {
        return execute(successHandler, new Call<C>("BeginSoftwareUpdate") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "UpdateURL", updateURL.getValue());
                setInput(invocation,"ui4", "Flags", flags.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C reportUnresponsiveDevice(final MemberID deviceUUID, final UnresponsiveDeviceActionType desiredAction, final C successHandler) {
        return execute(successHandler, new Call<C>("ReportUnresponsiveDevice") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DeviceUUID", deviceUUID.getValue());
                setInput(invocation,"string", "DesiredAction", desiredAction.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C reportAlarmStartedRunning(final C successHandler) {
        return execute(successHandler, new Call<C>("ReportAlarmStartedRunning") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<DiagnosticID>> C submitDiagnostics(final C successHandler) {
        return execute(successHandler, new Call<C>("SubmitDiagnostics") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final DiagnosticID value = DiagnosticID.getInstance((Long)getValue("ui4",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        final AvailableSoftwareUpdate newAvailableSoftwareUpdate = convertAvailableSoftwareUpdate((String)getValue("string", ((StateVariableValue)values.get("AvailableSoftwareUpdate")).getValue()));
        final AvailableSoftwareUpdate oldAvailableSoftwareUpdate = (AvailableSoftwareUpdate)stored.get("AvailableSoftwareUpdate");
        if (!Objects.equal(oldAvailableSoftwareUpdate, newAvailableSoftwareUpdate)) {
            _eventedValues.put("AvailableSoftwareUpdate", newAvailableSoftwareUpdate);
        }

        final ZoneGroupState newZoneGroupState = convertZoneGroupState((String)getValue("string", ((StateVariableValue)values.get("ZoneGroupState")).getValue()));
        final ZoneGroupState oldZoneGroupState = (ZoneGroupState)stored.get("ZoneGroupState");
        if (!Objects.equal(oldZoneGroupState, newZoneGroupState)) {
            _eventedValues.put("ZoneGroupState", newZoneGroupState);
        }

        final ThirdPartyMediaServers newThirdPartyMediaServers = convertThirdPartyMediaServers((String)getValue("string", ((StateVariableValue)values.get("ThirdPartyMediaServers")).getValue()));
        final ThirdPartyMediaServers oldThirdPartyMediaServers = (ThirdPartyMediaServers)stored.get("ThirdPartyMediaServers");
        if (!Objects.equal(oldThirdPartyMediaServers, newThirdPartyMediaServers)) {
            _eventedValues.put("ThirdPartyMediaServers", newThirdPartyMediaServers);
        }

        final AlarmRunSequence newAlarmRunSequence = convertAlarmRunSequence((String)getValue("string", ((StateVariableValue)values.get("AlarmRunSequence")).getValue()));
        final AlarmRunSequence oldAlarmRunSequence = (AlarmRunSequence)stored.get("AlarmRunSequence");
        if (!Objects.equal(oldAlarmRunSequence, newAlarmRunSequence)) {
            _eventedValues.put("AlarmRunSequence", newAlarmRunSequence);
        }

        // after the values were updated, send the change notifications

        if (!Objects.equal(oldAvailableSoftwareUpdate, newAvailableSoftwareUpdate)) {
            notifyAvailableSoftwareUpdateChanged(oldAvailableSoftwareUpdate, newAvailableSoftwareUpdate);
        }

        if (!Objects.equal(oldZoneGroupState, newZoneGroupState)) {
            notifyZoneGroupStateChanged(oldZoneGroupState, newZoneGroupState);
        }

        if (!Objects.equal(oldThirdPartyMediaServers, newThirdPartyMediaServers)) {
            notifyThirdPartyMediaServersChanged(oldThirdPartyMediaServers, newThirdPartyMediaServers);
        }

        if (!Objects.equal(oldAlarmRunSequence, newAlarmRunSequence)) {
            notifyAlarmRunSequenceChanged(oldAlarmRunSequence, newAlarmRunSequence);
        }

    }

    public AvailableSoftwareUpdate getAvailableSoftwareUpdate() {
        return (AvailableSoftwareUpdate)_eventedValues.get("AvailableSoftwareUpdate");
    }

    private final List<EventListener<AvailableSoftwareUpdate>> _changeAvailableSoftwareUpdateListeners = new ArrayList<EventListener<AvailableSoftwareUpdate>>();

    public void addAvailableSoftwareUpdateListener(EventListener<AvailableSoftwareUpdate> listener) {
        synchronized(_changeAvailableSoftwareUpdateListeners) {
            _changeAvailableSoftwareUpdateListeners.add(listener);
        }
    }

    public void removeAvailableSoftwareUpdateListener(EventListener<AvailableSoftwareUpdate> listener) {
        synchronized(_changeAvailableSoftwareUpdateListeners) {
            _changeAvailableSoftwareUpdateListeners.remove(listener);
        }
    }

    protected void notifyAvailableSoftwareUpdateChanged(AvailableSoftwareUpdate oldValue, AvailableSoftwareUpdate newValue) {
        final Iterable<EventListener<AvailableSoftwareUpdate>> listeners;
        synchronized(_changeAvailableSoftwareUpdateListeners) {
            listeners = new ArrayList<EventListener<AvailableSoftwareUpdate>>(_changeAvailableSoftwareUpdateListeners);            
        }
        for(EventListener<AvailableSoftwareUpdate> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected AvailableSoftwareUpdate convertAvailableSoftwareUpdate(String rawValue) {
        return AvailableSoftwareUpdate.getInstance(rawValue);
    }
    public ZoneGroupState getZoneGroupState() {
        return (ZoneGroupState)_eventedValues.get("ZoneGroupState");
    }

    private final List<EventListener<ZoneGroupState>> _changeZoneGroupStateListeners = new ArrayList<EventListener<ZoneGroupState>>();

    public void addZoneGroupStateListener(EventListener<ZoneGroupState> listener) {
        synchronized(_changeZoneGroupStateListeners) {
            _changeZoneGroupStateListeners.add(listener);
        }
    }

    public void removeZoneGroupStateListener(EventListener<ZoneGroupState> listener) {
        synchronized(_changeZoneGroupStateListeners) {
            _changeZoneGroupStateListeners.remove(listener);
        }
    }

    protected void notifyZoneGroupStateChanged(ZoneGroupState oldValue, ZoneGroupState newValue) {
        final Iterable<EventListener<ZoneGroupState>> listeners;
        synchronized(_changeZoneGroupStateListeners) {
            listeners = new ArrayList<EventListener<ZoneGroupState>>(_changeZoneGroupStateListeners);            
        }
        for(EventListener<ZoneGroupState> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected ZoneGroupState convertZoneGroupState(String rawValue) {
        return ZoneGroupState.getInstance(rawValue);
    }
    public ThirdPartyMediaServers getThirdPartyMediaServers() {
        return (ThirdPartyMediaServers)_eventedValues.get("ThirdPartyMediaServers");
    }

    private final List<EventListener<ThirdPartyMediaServers>> _changeThirdPartyMediaServersListeners = new ArrayList<EventListener<ThirdPartyMediaServers>>();

    public void addThirdPartyMediaServersListener(EventListener<ThirdPartyMediaServers> listener) {
        synchronized(_changeThirdPartyMediaServersListeners) {
            _changeThirdPartyMediaServersListeners.add(listener);
        }
    }

    public void removeThirdPartyMediaServersListener(EventListener<ThirdPartyMediaServers> listener) {
        synchronized(_changeThirdPartyMediaServersListeners) {
            _changeThirdPartyMediaServersListeners.remove(listener);
        }
    }

    protected void notifyThirdPartyMediaServersChanged(ThirdPartyMediaServers oldValue, ThirdPartyMediaServers newValue) {
        final Iterable<EventListener<ThirdPartyMediaServers>> listeners;
        synchronized(_changeThirdPartyMediaServersListeners) {
            listeners = new ArrayList<EventListener<ThirdPartyMediaServers>>(_changeThirdPartyMediaServersListeners);            
        }
        for(EventListener<ThirdPartyMediaServers> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected ThirdPartyMediaServers convertThirdPartyMediaServers(String rawValue) {
        return ThirdPartyMediaServers.getInstance(rawValue);
    }
    public AlarmRunSequence getAlarmRunSequence() {
        return (AlarmRunSequence)_eventedValues.get("AlarmRunSequence");
    }

    private final List<EventListener<AlarmRunSequence>> _changeAlarmRunSequenceListeners = new ArrayList<EventListener<AlarmRunSequence>>();

    public void addAlarmRunSequenceListener(EventListener<AlarmRunSequence> listener) {
        synchronized(_changeAlarmRunSequenceListeners) {
            _changeAlarmRunSequenceListeners.add(listener);
        }
    }

    public void removeAlarmRunSequenceListener(EventListener<AlarmRunSequence> listener) {
        synchronized(_changeAlarmRunSequenceListeners) {
            _changeAlarmRunSequenceListeners.remove(listener);
        }
    }

    protected void notifyAlarmRunSequenceChanged(AlarmRunSequence oldValue, AlarmRunSequence newValue) {
        final Iterable<EventListener<AlarmRunSequence>> listeners;
        synchronized(_changeAlarmRunSequenceListeners) {
            listeners = new ArrayList<EventListener<AlarmRunSequence>>(_changeAlarmRunSequenceListeners);            
        }
        for(EventListener<AlarmRunSequence> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected AlarmRunSequence convertAlarmRunSequence(String rawValue) {
        return AlarmRunSequence.getInstance(rawValue);
    }
}
