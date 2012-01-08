/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.services.ConnectionManagerService;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

public class ConnectionManagerServiceTest extends AbstractSonosServiceTest<ConnectionManagerService> {

    @Override
    protected ConnectionManagerService extractService(SonosDevice device) {
        return device.getConnectionManagerService();
    }

    @Override
    protected String getServiceName() {
        return "ConnectionManagerService";
    }
    /**
     * ConnectionManager is announced, but not actually available on my Sonos Systems (KK, 07.01.2012).
     */
    /*
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
        final GetProtocolInfoResult value = getService().retrieveProtocolInfo(new de.kalass.sonoscontrol.api.core.AsyncValue<GetProtocolInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveProtocolInfo: " + value);
    }

    @Test
    public void retrieveCurrentConnectionIDsTest() throws Exception{
        final CurrentConnectionIDs value = getService().retrieveCurrentConnectionIDs(new de.kalass.sonoscontrol.api.core.AsyncValue<CurrentConnectionIDs>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveCurrentConnectionIDs: " + value);
    }
     */
}

