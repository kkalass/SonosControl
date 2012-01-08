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

  @Override
    protected String getServiceName() {
        return "ConnectionManagerService";
    }
    
    @Test
    public void testGetSinkProtocolInfo() {
        final SinkProtocolInfo value = getService().getLastValueForSinkProtocolInfo();
        Assert.assertNotNull(value);
        System.out.println("Got SinkProtocolInfo: " + value);
    }
    @Test
    public void testGetSourceProtocolInfo() {
        final SourceProtocolInfo value = getService().getLastValueForSourceProtocolInfo();
        Assert.assertNotNull(value);
        System.out.println("Got SourceProtocolInfo: " + value);
    }
    @Test
    public void testGetCurrentConnectionIDs() {
        final CurrentConnectionIDs value = getService().getLastValueForCurrentConnectionIDs();
        Assert.assertNotNull(value);
        System.out.println("Got CurrentConnectionIDs: " + value);
    }

}

