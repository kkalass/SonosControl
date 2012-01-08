/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;
import javax.annotation.CheckForNull;

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

public interface ConnectionManagerService {


    @CheckForNull
    SinkProtocolInfo getLastValueForSinkProtocolInfo();

    void addSinkProtocolInfoListener(EventListener<SinkProtocolInfo> listener);

    void removeSinkProtocolInfoListener(EventListener<SinkProtocolInfo> listener);

    @CheckForNull
    SourceProtocolInfo getLastValueForSourceProtocolInfo();

    void addSourceProtocolInfoListener(EventListener<SourceProtocolInfo> listener);

    void removeSourceProtocolInfoListener(EventListener<SourceProtocolInfo> listener);

    @CheckForNull
    CurrentConnectionIDs getLastValueForCurrentConnectionIDs();

    void addCurrentConnectionIDsListener(EventListener<CurrentConnectionIDs> listener);

    void removeCurrentConnectionIDsListener(EventListener<CurrentConnectionIDs> listener);


    <C extends Callback1<GetProtocolInfoResult>> C retrieveProtocolInfo(C callback);

    <C extends Callback1<CurrentConnectionIDs>> C retrieveCurrentConnectionIDs(C callback);

    <C extends Callback1<GetCurrentConnectionInfoResult>> C retrieveCurrentConnectionInfo(ConnectionID connectionID, C callback);

}
