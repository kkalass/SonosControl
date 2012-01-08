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

    @Test
    public void testLocalGroupUUID() {
        final LocalGroupUUID value = getService().getLocalGroupUUID();
        Assert.assertNotNull(value);
        System.out.println("Got LocalGroupUUID: " + value);
    }
    @Test
    public void testResetVolumeAfter() {
        final ResetVolumeAfter value = getService().getResetVolumeAfter();
        Assert.assertNotNull(value);
        System.out.println("Got ResetVolumeAfter: " + value);
    }
    @Test
    public void testGroupCoordinatorIsLocal() {
        final GroupCoordinatorIsLocal value = getService().getGroupCoordinatorIsLocal();
        Assert.assertNotNull(value);
        System.out.println("Got GroupCoordinatorIsLocal: " + value);
    }
    @Test
    public void testVolumeAVTransportURI() {
        final VolumeAVTransportURI value = getService().getVolumeAVTransportURI();
        Assert.assertNotNull(value);
        System.out.println("Got VolumeAVTransportURI: " + value);
    }

}

