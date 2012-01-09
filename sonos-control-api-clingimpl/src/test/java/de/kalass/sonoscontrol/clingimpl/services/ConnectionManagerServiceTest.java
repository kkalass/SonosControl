// AUTOGENERATED: c957b19a7258f3efb31c47c3e077fb24
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.ConnectionManagerService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.core.VoidCallback;
import de.kalass.sonoscontrol.api.core.AsyncValue;
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


    @Test
    public void retrieveProtocolInfoTest() throws Exception{
        final GetProtocolInfoResult value = getService().retrieveProtocolInfo(new AsyncValue<GetProtocolInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveProtocolInfo: " + value);
    }

    @Test
    public void retrieveCurrentConnectionIDsTest() throws Exception{
        final CurrentConnectionIDs value = getService().retrieveCurrentConnectionIDs(new AsyncValue<CurrentConnectionIDs>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveCurrentConnectionIDs: " + value);
    }

    /*
    @Test
    public void retrieveCurrentConnectionInfoTest() throws Exception{
        final GetCurrentConnectionInfoResult value = getService().retrieveCurrentConnectionInfo(connectionID, new AsyncValue<GetCurrentConnectionInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveCurrentConnectionInfo: " + value);
    }
    */
}

