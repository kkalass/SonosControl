/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.GroupManagementService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.groupmanagement.AddMemberResult;
import de.kalass.sonoscontrol.api.model.groupmanagement.LocalGroupUUID;
import de.kalass.sonoscontrol.api.model.groupmanagement.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.groupmanagement.GroupCoordinatorIsLocal;
import de.kalass.sonoscontrol.api.model.groupmanagement.VolumeAVTransportURI;
import de.kalass.sonoscontrol.api.model.groupmanagement.BufferingResultCode;
import de.kalass.sonoscontrol.api.model.groupmanagement.TransportSettings;

public class GroupManagementServiceTest extends AbstractSonosServiceTest<GroupManagementService> {

    @Override
    protected GroupManagementService extractService(SonosDevice device) {
        return device.getGroupManagementService();
    }

  @Override
    protected String getServiceName() {
        return "GroupManagementService";
    }
    
    @Test
    public void testGetLocalGroupUUID() {
        final LocalGroupUUID value = getService().getLastValueForLocalGroupUUID();
        Assert.assertNotNull(value);
        System.out.println("Got LocalGroupUUID: " + value);
    }
    @Test
    public void testGetResetVolumeAfter() {
        final ResetVolumeAfter value = getService().getLastValueForResetVolumeAfter();
        Assert.assertNotNull(value);
        System.out.println("Got ResetVolumeAfter: " + value);
    }
    @Test
    public void testGetGroupCoordinatorIsLocal() {
        final GroupCoordinatorIsLocal value = getService().getLastValueForGroupCoordinatorIsLocal();
        Assert.assertNotNull(value);
        System.out.println("Got GroupCoordinatorIsLocal: " + value);
    }
    @Test
    public void testGetVolumeAVTransportURI() {
        final VolumeAVTransportURI value = getService().getLastValueForVolumeAVTransportURI();
        Assert.assertNotNull(value);
        System.out.println("Got VolumeAVTransportURI: " + value);
    }




}

