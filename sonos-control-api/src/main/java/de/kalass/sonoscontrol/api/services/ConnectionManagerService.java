package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.connectionmanager.ConnectionID;
import de.kalass.sonoscontrol.api.model.connectionmanager.CurrentConnectionIDs;
import de.kalass.sonoscontrol.api.model.connectionmanager.CurrentConnectionInfo;
import de.kalass.sonoscontrol.api.model.connectionmanager.ProtocolInfo;

public interface ConnectionManagerService {

    public <C extends Callback1<ProtocolInfo>> C getProtocolInfo(C callback);

    public <C extends Callback1<CurrentConnectionIDs>> C getCurrentConnectionIDs(C callback);

    public <C extends Callback1<CurrentConnectionInfo>> C getCurrentConnectionInfo(ConnectionID connectionID, C callback);
}
