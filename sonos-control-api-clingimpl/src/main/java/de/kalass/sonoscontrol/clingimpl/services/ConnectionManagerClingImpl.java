

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
import de.kalass.sonoscontrol.api.model.connectionmanager.ProtocolInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.CurrentConnectionIDs;
import de.kalass.sonoscontrol.api.model.connectionmanager.CurrentConnectionInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.Direction;
import de.kalass.sonoscontrol.api.model.connectionmanager.SinkProtocolInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.RcsID;
import de.kalass.sonoscontrol.api.model.connectionmanager.ConnectionManager;
import de.kalass.sonoscontrol.api.model.connectionmanager.SourceProtocolInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.ConnectionID;
import de.kalass.sonoscontrol.api.model.connectionmanager.ConnectionStatus;
import de.kalass.sonoscontrol.api.model.connectionmanager.AVTransportID;

@SuppressWarnings("rawtypes")
public final class ConnectionManagerClingImpl extends AbstractServiceImpl {

    public ConnectionManagerClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("ConnectionManager", upnpService, device, errorStrategy);
    }


    public SinkProtocolInfo getSinkProtocolInfo() {
        throw new UnsupportedOperationException();
    }

    public SourceProtocolInfo getSourceProtocolInfo() {
        throw new UnsupportedOperationException();
    }

    public CurrentConnectionIDs getCurrentConnectionIDs() {
        throw new UnsupportedOperationException();
    }


    public <C extends Callback1<ProtocolInfo>> C retrieveProtocolInfo(final C successHandler) {
        return execute(successHandler, new Call<C>("GetProtocolInfo") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                handler.success();
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
                handler.success();
            }
        });
    }

    public <C extends Callback1<CurrentConnectionInfo>> C retrieveCurrentConnectionInfo(final ConnectionID connectionID, final C successHandler) {
        return execute(successHandler, new Call<C>("GetCurrentConnectionInfo") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"i4", "ConnectionID", connectionID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                handler.success();
            }
        });
    }

}
