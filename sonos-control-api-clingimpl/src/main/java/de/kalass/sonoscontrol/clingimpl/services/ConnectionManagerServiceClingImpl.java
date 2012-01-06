

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.ConnectionManagerService;
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
import de.kalass.sonoscontrol.api.model.connectionmanager.GetProtocolInfoResult;
import de.kalass.sonoscontrol.api.model.connectionmanager.CurrentConnectionIDs;
import de.kalass.sonoscontrol.api.model.connectionmanager.GetCurrentConnectionInfoResult;
import de.kalass.sonoscontrol.api.model.connectionmanager.Direction;
import de.kalass.sonoscontrol.api.model.connectionmanager.SinkProtocolInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.RcsID;
import de.kalass.sonoscontrol.api.model.connectionmanager.ConnectionManager;
import de.kalass.sonoscontrol.api.model.connectionmanager.ProtocolInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.SourceProtocolInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.ConnectionID;
import de.kalass.sonoscontrol.api.model.connectionmanager.ConnectionStatus;
import de.kalass.sonoscontrol.api.model.connectionmanager.AVTransportID;

@SuppressWarnings("rawtypes")
public final class ConnectionManagerServiceClingImpl extends AbstractServiceImpl implements ConnectionManagerService {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(ConnectionManagerServiceClingImpl.class);
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();
    private final CountDownLatch _eventsReceivedLatch = new CountDownLatch(1);
    private final List<EventListener<SinkProtocolInfo>> _changeSinkProtocolInfoListeners = new ArrayList<EventListener<SinkProtocolInfo>>();
    private final List<EventListener<SourceProtocolInfo>> _changeSourceProtocolInfoListeners = new ArrayList<EventListener<SourceProtocolInfo>>();
    private final List<EventListener<CurrentConnectionIDs>> _changeCurrentConnectionIDsListeners = new ArrayList<EventListener<CurrentConnectionIDs>>();

    public ConnectionManagerServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("ConnectionManager", upnpService, device, errorStrategy);
    }


    public <C extends Callback1<GetProtocolInfoResult>> C retrieveProtocolInfo(final C successHandler) {
        return execute(successHandler, new Call<C>("GetProtocolInfo") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final SourceProtocolInfo source = SourceProtocolInfo.getInstance((String)getValue("string",output[0].getValue()));
                final SinkProtocolInfo sink = SinkProtocolInfo.getInstance((String)getValue("string",output[1].getValue()));
                final GetProtocolInfoResult value = GetProtocolInfoResult.getInstance(source,sink);
                handler.success(value);
            }
        });
    }

    public <C extends Callback1<CurrentConnectionIDs>> C retrieveCurrentConnectionIDs(final C successHandler) {
        return execute(successHandler, new Call<C>("GetCurrentConnectionIDs") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final CurrentConnectionIDs value = CurrentConnectionIDs.getInstance((String)getValue("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback1<GetCurrentConnectionInfoResult>> C retrieveCurrentConnectionInfo(final ConnectionID connectionID, final C successHandler) {
        return execute(successHandler, new Call<C>("GetCurrentConnectionInfo") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"i4", "ConnectionID", connectionID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final RcsID rcsID = RcsID.getInstance((Long)getValue("i4",output[0].getValue()));
                final AVTransportID aVTransportID = AVTransportID.getInstance((Long)getValue("i4",output[1].getValue()));
                final ProtocolInfo protocolInfo = ProtocolInfo.getInstance((String)getValue("string",output[2].getValue()));
                final ConnectionManager peerConnectionManager = ConnectionManager.getInstance((String)getValue("string",output[3].getValue()));
                final ConnectionID peerConnectionID = ConnectionID.getInstance((Long)getValue("i4",output[4].getValue()));
                final Direction direction = Direction.getInstance((String)getValue("string",output[5].getValue()));
                final ConnectionStatus status = ConnectionStatus.getInstance((String)getValue("string",output[6].getValue()));
                final GetCurrentConnectionInfoResult value = GetCurrentConnectionInfoResult.getInstance(rcsID,aVTransportID,protocolInfo,peerConnectionManager,peerConnectionID,direction,status);
                handler.success(value);
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        final SinkProtocolInfo newSinkProtocolInfo = convertSinkProtocolInfo((String)getValue("string", ((StateVariableValue)values.get("SinkProtocolInfo")).getValue()));
        final SinkProtocolInfo oldSinkProtocolInfo = (SinkProtocolInfo)stored.get("SinkProtocolInfo");
        if (!Objects.equal(oldSinkProtocolInfo, newSinkProtocolInfo)) {
            _eventedValues.put("SinkProtocolInfo", newSinkProtocolInfo);
        }

        final SourceProtocolInfo newSourceProtocolInfo = convertSourceProtocolInfo((String)getValue("string", ((StateVariableValue)values.get("SourceProtocolInfo")).getValue()));
        final SourceProtocolInfo oldSourceProtocolInfo = (SourceProtocolInfo)stored.get("SourceProtocolInfo");
        if (!Objects.equal(oldSourceProtocolInfo, newSourceProtocolInfo)) {
            _eventedValues.put("SourceProtocolInfo", newSourceProtocolInfo);
        }

        final CurrentConnectionIDs newCurrentConnectionIDs = convertCurrentConnectionIDs((String)getValue("string", ((StateVariableValue)values.get("CurrentConnectionIDs")).getValue()));
        final CurrentConnectionIDs oldCurrentConnectionIDs = (CurrentConnectionIDs)stored.get("CurrentConnectionIDs");
        if (!Objects.equal(oldCurrentConnectionIDs, newCurrentConnectionIDs)) {
            _eventedValues.put("CurrentConnectionIDs", newCurrentConnectionIDs);
        }

        // after the values were updated, send the change notifications

        if (!Objects.equal(oldSinkProtocolInfo, newSinkProtocolInfo)) {
            notifySinkProtocolInfoChanged(oldSinkProtocolInfo, newSinkProtocolInfo);
        }

        if (!Objects.equal(oldSourceProtocolInfo, newSourceProtocolInfo)) {
            notifySourceProtocolInfoChanged(oldSourceProtocolInfo, newSourceProtocolInfo);
        }

        if (!Objects.equal(oldCurrentConnectionIDs, newCurrentConnectionIDs)) {
            notifyCurrentConnectionIDsChanged(oldCurrentConnectionIDs, newCurrentConnectionIDs);
        }
        _eventsReceivedLatch.countDown();
    }

    protected Object getEventedValueOrWait(String key) {
        try {
            _eventsReceivedLatch.await();
        } catch (InterruptedException e) {
            LOG.warn("waiting for evented value countdown latch was interrupted, will continue");
        }
        return _eventedValues.get(key);
    }


    public SinkProtocolInfo getSinkProtocolInfo() {
        return (SinkProtocolInfo)getEventedValueOrWait("SinkProtocolInfo");
    }

    public void addSinkProtocolInfoListener(EventListener<SinkProtocolInfo> listener) {
        synchronized(_changeSinkProtocolInfoListeners) {
            _changeSinkProtocolInfoListeners.add(listener);
        }
    }

    public void removeSinkProtocolInfoListener(EventListener<SinkProtocolInfo> listener) {
        synchronized(_changeSinkProtocolInfoListeners) {
            _changeSinkProtocolInfoListeners.remove(listener);
        }
    }

    protected void notifySinkProtocolInfoChanged(SinkProtocolInfo oldValue, SinkProtocolInfo newValue) {
        final Iterable<EventListener<SinkProtocolInfo>> listeners;
        synchronized(_changeSinkProtocolInfoListeners) {
            listeners = new ArrayList<EventListener<SinkProtocolInfo>>(_changeSinkProtocolInfoListeners);            
        }
        for(EventListener<SinkProtocolInfo> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected SinkProtocolInfo convertSinkProtocolInfo(String rawValue) {
        return SinkProtocolInfo.getInstance(rawValue);
    }

    public SourceProtocolInfo getSourceProtocolInfo() {
        return (SourceProtocolInfo)getEventedValueOrWait("SourceProtocolInfo");
    }

    public void addSourceProtocolInfoListener(EventListener<SourceProtocolInfo> listener) {
        synchronized(_changeSourceProtocolInfoListeners) {
            _changeSourceProtocolInfoListeners.add(listener);
        }
    }

    public void removeSourceProtocolInfoListener(EventListener<SourceProtocolInfo> listener) {
        synchronized(_changeSourceProtocolInfoListeners) {
            _changeSourceProtocolInfoListeners.remove(listener);
        }
    }

    protected void notifySourceProtocolInfoChanged(SourceProtocolInfo oldValue, SourceProtocolInfo newValue) {
        final Iterable<EventListener<SourceProtocolInfo>> listeners;
        synchronized(_changeSourceProtocolInfoListeners) {
            listeners = new ArrayList<EventListener<SourceProtocolInfo>>(_changeSourceProtocolInfoListeners);            
        }
        for(EventListener<SourceProtocolInfo> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected SourceProtocolInfo convertSourceProtocolInfo(String rawValue) {
        return SourceProtocolInfo.getInstance(rawValue);
    }

    public CurrentConnectionIDs getCurrentConnectionIDs() {
        return (CurrentConnectionIDs)getEventedValueOrWait("CurrentConnectionIDs");
    }

    public void addCurrentConnectionIDsListener(EventListener<CurrentConnectionIDs> listener) {
        synchronized(_changeCurrentConnectionIDsListeners) {
            _changeCurrentConnectionIDsListeners.add(listener);
        }
    }

    public void removeCurrentConnectionIDsListener(EventListener<CurrentConnectionIDs> listener) {
        synchronized(_changeCurrentConnectionIDsListeners) {
            _changeCurrentConnectionIDsListeners.remove(listener);
        }
    }

    protected void notifyCurrentConnectionIDsChanged(CurrentConnectionIDs oldValue, CurrentConnectionIDs newValue) {
        final Iterable<EventListener<CurrentConnectionIDs>> listeners;
        synchronized(_changeCurrentConnectionIDsListeners) {
            listeners = new ArrayList<EventListener<CurrentConnectionIDs>>(_changeCurrentConnectionIDsListeners);            
        }
        for(EventListener<CurrentConnectionIDs> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected CurrentConnectionIDs convertCurrentConnectionIDs(String rawValue) {
        return CurrentConnectionIDs.getInstance(rawValue);
    }
}
