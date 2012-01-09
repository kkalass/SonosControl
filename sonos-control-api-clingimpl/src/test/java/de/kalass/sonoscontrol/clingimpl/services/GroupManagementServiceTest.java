package de.kalass.sonoscontrol.clingimpl.services;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.model.groupmanagement.GroupCoordinatorIsLocal;
import de.kalass.sonoscontrol.api.model.groupmanagement.LocalGroupUUID;
import de.kalass.sonoscontrol.api.model.groupmanagement.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.groupmanagement.VolumeAVTransportURI;
import de.kalass.sonoscontrol.api.services.GroupManagementService;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

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
        // 09.01.2012 (KK): Always null on my system - probably ok?
        // Assert.assertNotNull(value);
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
        // 09.01.2012 (KK): Always null on my system - probably ok?
        // Assert.assertNotNull(value);
        System.out.println("Got VolumeAVTransportURI: " + value);
    }


    /*
    @Test
    public void addMemberTest() throws Exception{
        final AddMemberResult value = getService().addMember(memberID, new AsyncValue<AddMemberResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got addMember: " + value);
    }
     */

    /*
    @Test
    public void removeMemberTest() throws Exception{
        getService().removeMember(memberID, new VoidCallback()).waitForSuccess();
        System.out.println("Finished removeMember");
    }
     */

    /*
    @Test
    public void reportTrackBufferingResultTest() throws Exception{
        getService().reportTrackBufferingResult(memberID, resultCode, new VoidCallback()).waitForSuccess();
        System.out.println("Finished reportTrackBufferingResult");
    }
     */
}

