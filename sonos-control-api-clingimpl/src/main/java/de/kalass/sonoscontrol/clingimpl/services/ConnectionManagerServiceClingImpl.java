

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.ConnectionManagerService;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

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

    public ConnectionManagerServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
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
                final SourceProtocolInfo value0 = SourceProtocolInfo.getInstance(getString("string",output[0].getValue()));
                final SinkProtocolInfo value1 = SinkProtocolInfo.getInstance(getString("string",output[1].getValue()));
                final GetProtocolInfoResult value = GetProtocolInfoResult.getInstance(value0,value1);
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
                 final CurrentConnectionIDs value = CurrentConnectionIDs.getInstance(getString("string",output[0].getValue()));
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
                final RcsID value0 = RcsID.getInstance(getLong("i4",output[0].getValue()));
                final AVTransportID value1 = AVTransportID.getInstance(getLong("i4",output[1].getValue()));
                final ProtocolInfo value2 = ProtocolInfo.getInstance(getString("string",output[2].getValue()));
                final ConnectionManager value3 = ConnectionManager.getInstance(getString("string",output[3].getValue()));
                final ConnectionID value4 = ConnectionID.getInstance(getLong("i4",output[4].getValue()));
                final Direction value5 = Direction.getInstance(getString("string",output[5].getValue()));
                final ConnectionStatus value6 = ConnectionStatus.getInstance(getString("string",output[6].getValue()));
                final GetCurrentConnectionInfoResult value = GetCurrentConnectionInfoResult.getInstance(value0,value1,value2,value3,value4,value5,value6);
                handler.success(value);
            }
        });
    }

}
