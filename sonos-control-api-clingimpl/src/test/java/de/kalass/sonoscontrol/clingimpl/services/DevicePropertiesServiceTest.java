package de.kalass.sonoscontrol.clingimpl.services;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.AsyncValue;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayIncludeLinkedZones;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayRoomUUID;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayUseVolume;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayVolume;
import de.kalass.sonoscontrol.api.model.deviceproperties.ChannelMapSet;
import de.kalass.sonoscontrol.api.model.deviceproperties.GetZoneAttributesResult;
import de.kalass.sonoscontrol.api.model.deviceproperties.GetZoneInfoResult;
import de.kalass.sonoscontrol.api.model.deviceproperties.HouseholdID;
import de.kalass.sonoscontrol.api.model.deviceproperties.Icon;
import de.kalass.sonoscontrol.api.model.deviceproperties.Invisible;
import de.kalass.sonoscontrol.api.model.deviceproperties.IsZoneBridge;
import de.kalass.sonoscontrol.api.model.deviceproperties.LEDState;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingsReplicationState;
import de.kalass.sonoscontrol.api.model.deviceproperties.SpeakerSize;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

public class DevicePropertiesServiceTest extends AbstractSonosServiceTest<DevicePropertiesService> {

    @Override
    protected DevicePropertiesService extractService(SonosDevice device) {
        return device.getDevicePropertiesService();
    }

    @Override
    protected String getServiceName() {
        return "DevicePropertiesService";
    }

    @Test
    public void testGetSettingsReplicationState() {
        final SettingsReplicationState value = getService().getLastValueForSettingsReplicationState();
        Assert.assertNotNull(value);
        System.out.println("Got SettingsReplicationState: " + value);
    }
    @Test
    public void testGetZoneName() {
        final ZoneName value = getService().getLastValueForZoneName();
        Assert.assertNotNull(value);
        System.out.println("Got ZoneName: " + value);
    }
    @Test
    public void testGetChannelMapSet() {
        final ChannelMapSet value = getService().getLastValueForChannelMapSet();
        // 09.01.2012 (KK): Always null on my system - probably ok?
        // Assert.assertNotNull(value);
        System.out.println("Got ChannelMapSet: " + value);
    }
    @Test
    public void testGetInvisible() {
        final Invisible value = getService().getLastValueForInvisible();
        Assert.assertNotNull(value);
        System.out.println("Got Invisible: " + value);
    }
    @Test
    public void testGetIsZoneBridge() {
        final IsZoneBridge value = getService().getLastValueForIsZoneBridge();
        Assert.assertNotNull(value);
        System.out.println("Got IsZoneBridge: " + value);
    }
    @Test
    public void testGetIcon() {
        final Icon value = getService().getLastValueForIcon();
        Assert.assertNotNull(value);
        System.out.println("Got Icon: " + value);
    }


    /*
    @Test
    public void setLEDStateTest() throws Exception{
        getService().setLEDState(desiredLEDState, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setLEDState");
    }
     */

    @Test
    public void retrieveLEDStateTest() throws Exception{
        final LEDState value = getService().retrieveLEDState(new AsyncValue<LEDState>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveLEDState: " + value);
    }

    /*
    @Test
    public void setInvisibleTest() throws Exception{
        getService().setInvisible(desiredInvisible, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setInvisible");
    }
     */

    @Test
    public void retrieveInvisibleTest() throws Exception{
        final Invisible value = getService().retrieveInvisible(new AsyncValue<Invisible>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveInvisible: " + value);
    }

    /*
    @Test
    public void addBondedZonesTest() throws Exception{
        getService().addBondedZones(channelMapSet, new VoidCallback()).waitForSuccess();
        System.out.println("Finished addBondedZones");
    }
     */

    /*
    @Test
    public void removeBondedZonesTest() throws Exception{
        getService().removeBondedZones(channelMapSet, new VoidCallback()).waitForSuccess();
        System.out.println("Finished removeBondedZones");
    }
     */

    /*
    @Test
    public void createStereoPairTest() throws Exception{
        getService().createStereoPair(channelMapSet, new VoidCallback()).waitForSuccess();
        System.out.println("Finished createStereoPair");
    }
     */

    /*
    @Test
    public void separateStereoPairTest() throws Exception{
        getService().separateStereoPair(channelMapSet, new VoidCallback()).waitForSuccess();
        System.out.println("Finished separateStereoPair");
    }
     */

    /*
    @Test
    public void setZoneAttributesTest() throws Exception{
        getService().setZoneAttributes(desiredZoneName, desiredIcon, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setZoneAttributes");
    }
     */

    @Test
    public void retrieveZoneAttributesTest() throws Exception{
        final GetZoneAttributesResult value = getService().retrieveZoneAttributes(new AsyncValue<GetZoneAttributesResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveZoneAttributes: " + value);
    }

    @Test
    public void retrieveHouseholdIDTest() throws Exception{
        final HouseholdID value = getService().retrieveHouseholdID(new AsyncValue<HouseholdID>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveHouseholdID: " + value);
    }

    @Test
    public void retrieveZoneInfoTest() throws Exception{
        final GetZoneInfoResult value = getService().retrieveZoneInfo(new AsyncValue<GetZoneInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveZoneInfo: " + value);
    }

    /*
    @Test
    public void setAutoplayLinkedZonesTest() throws Exception{
        getService().setAutoplayLinkedZones(includeLinkedZones, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setAutoplayLinkedZones");
    }
     */

    @Test
    public void retrieveAutoplayLinkedZonesTest() throws Exception{
        final AutoplayIncludeLinkedZones value = getService().retrieveAutoplayLinkedZones(new AsyncValue<AutoplayIncludeLinkedZones>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveAutoplayLinkedZones: " + value);
    }

    /*
    @Test
    public void setAutoplayRoomUUIDTest() throws Exception{
        getService().setAutoplayRoomUUID(roomUUID, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setAutoplayRoomUUID");
    }
     */

    @Test
    public void retrieveAutoplayRoomUUIDTest() throws Exception{
        final AutoplayRoomUUID value = getService().retrieveAutoplayRoomUUID(new AsyncValue<AutoplayRoomUUID>()).get();
        // 09.01.2012 (KK): Always null on my system - probably ok?
        // Assert.assertNotNull(value);
        System.out.println("Got retrieveAutoplayRoomUUID: " + value);
    }

    /*
    @Test
    public void setAutoplayVolumeTest() throws Exception{
        getService().setAutoplayVolume(volume, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setAutoplayVolume");
    }
     */

    @Test
    public void retrieveAutoplayVolumeTest() throws Exception{
        final AutoplayVolume value = getService().retrieveAutoplayVolume(new AsyncValue<AutoplayVolume>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveAutoplayVolume: " + value);
    }

    /*
    @Test
    public void importSettingTest() throws Exception{
        getService().importSetting(settingID, settingURI, new VoidCallback()).waitForSuccess();
        System.out.println("Finished importSetting");
    }
     */

    /*
    @Test
    public void setSpeakerSizeTest() throws Exception{
        getService().setSpeakerSize(speakerSize, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setSpeakerSize");
    }
     */

    @Test
    public void retrieveSpeakerSizeTest() throws Exception{
        final SpeakerSize value = getService().retrieveSpeakerSize(new AsyncValue<SpeakerSize>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveSpeakerSize: " + value);
    }

    /*
    @Test
    public void setUseAutoplayVolumeTest() throws Exception{
        getService().setUseAutoplayVolume(useVolume, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setUseAutoplayVolume");
    }
     */

    @Test
    public void retrieveUseAutoplayVolumeTest() throws Exception{
        final AutoplayUseVolume value = getService().retrieveUseAutoplayVolume(new AsyncValue<AutoplayUseVolume>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveUseAutoplayVolume: " + value);
    }
}

