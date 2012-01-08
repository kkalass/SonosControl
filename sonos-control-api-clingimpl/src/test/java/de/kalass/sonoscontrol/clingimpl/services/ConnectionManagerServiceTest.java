/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.ConnectionManagerService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

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

public class ConnectionManagerServiceTest extends AbstractSonosServiceTest<ConnectionManagerService> {

    @Override
    protected ConnectionManagerService extractService(SonosDevice device) {
        return device.getConnectionManagerService();
    }

    @Test
    public void testSinkProtocolInfo() {
        final SinkProtocolInfo value = getService().getSinkProtocolInfo();
        Assert.assertNotNull(value);
        System.out.println("Got SinkProtocolInfo: " + value);
    }
    @Test
    public void testSourceProtocolInfo() {
        final SourceProtocolInfo value = getService().getSourceProtocolInfo();
        Assert.assertNotNull(value);
        System.out.println("Got SourceProtocolInfo: " + value);
    }
    @Test
    public void testCurrentConnectionIDs() {
        final CurrentConnectionIDs value = getService().getCurrentConnectionIDs();
        Assert.assertNotNull(value);
        System.out.println("Got CurrentConnectionIDs: " + value);
    }

}

