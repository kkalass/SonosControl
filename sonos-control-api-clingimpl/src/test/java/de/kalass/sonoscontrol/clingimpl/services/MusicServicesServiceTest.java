/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.MusicServicesService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.musicservices.ListAvailableServicesResult;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceListVersion;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceTypeList;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceDescriptorList;

public class MusicServicesServiceTest extends AbstractSonosServiceTest<MusicServicesService> {

    @Override
    protected MusicServicesService extractService(SonosDevice device) {
        return device.getMusicServicesService();
    }

  @Override
    protected String getServiceName() {
        return "MusicServicesService";
    }
    
    @Test
    public void testGetServiceListVersion() {
        final ServiceListVersion value = getService().getLastValueForServiceListVersion();
        Assert.assertNotNull(value);
        System.out.println("Got ServiceListVersion: " + value);
    }


    @Test
    public void listAvailableServicesTest() throws Exception{
        final ListAvailableServicesResult value = getService().listAvailableServices(new de.kalass.sonoscontrol.api.core.AsyncValue<ListAvailableServicesResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got listAvailableServices: " + value);
    }

    /*
    @Test
    public void updateAvailableServicesTest() throws Exception{
        getService().updateAvailableServices(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished updateAvailableServices");
    }
    */
}

