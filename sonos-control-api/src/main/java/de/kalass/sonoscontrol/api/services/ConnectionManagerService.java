/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

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

public interface ConnectionManagerService {


    SinkProtocolInfo getSinkProtocolInfo();

    SourceProtocolInfo getSourceProtocolInfo();

    CurrentConnectionIDs getCurrentConnectionIDs();


    <C extends Callback1<ProtocolInfo>> C retrieveProtocolInfo(C callback);

    <C extends Callback1<CurrentConnectionIDs>> C retrieveCurrentConnectionIDs(C callback);

    <C extends Callback1<CurrentConnectionInfo>> C retrieveCurrentConnectionInfo(ConnectionID connectionID, C callback);

}
