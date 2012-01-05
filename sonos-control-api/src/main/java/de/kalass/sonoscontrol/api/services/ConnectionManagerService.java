package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.connectionmanager.ConnectionID;
import de.kalass.sonoscontrol.api.model.connectionmanager.CurrentConnectionIDs;
import de.kalass.sonoscontrol.api.model.connectionmanager.CurrentConnectionInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.ProtocolInfo;

public interface ConnectionManagerService {


    <C extends Callback1<ProtocolInfo>> C retrieveProtocolInfo(C callback);

    <C extends Callback1<CurrentConnectionIDs>> C retrieveCurrentConnectionIDs(C callback);

    <C extends Callback1<CurrentConnectionInfo>> C retrieveCurrentConnectionInfo(ConnectionID connectionID, C callback);

}
