/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.deviceproperties.LEDState;
import de.kalass.sonoscontrol.api.model.deviceproperties.Invisible;
import de.kalass.sonoscontrol.api.model.deviceproperties.GetZoneAttributesResult;
import de.kalass.sonoscontrol.api.model.deviceproperties.HouseholdID;
import de.kalass.sonoscontrol.api.model.deviceproperties.GetZoneInfoResult;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayIncludeLinkedZones;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayRoomUUID;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayVolume;
import de.kalass.sonoscontrol.api.model.deviceproperties.SpeakerSize;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayUseVolume;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingsReplicationState;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.api.model.deviceproperties.ExtraInfo;
import de.kalass.sonoscontrol.api.model.deviceproperties.ChannelMapSet;
import de.kalass.sonoscontrol.api.model.deviceproperties.DisplaySoftwareVersion;
import de.kalass.sonoscontrol.api.model.deviceproperties.MACAddress;
import de.kalass.sonoscontrol.api.model.deviceproperties.HardwareVersion;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingID;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingURI;
import de.kalass.sonoscontrol.api.model.deviceproperties.SerialNumber;
import de.kalass.sonoscontrol.api.model.deviceproperties.SoftwareVersion;
import de.kalass.sonoscontrol.api.model.deviceproperties.IPAddress;
import de.kalass.sonoscontrol.api.model.deviceproperties.IsZoneBridge;
import de.kalass.sonoscontrol.api.model.deviceproperties.CopyrightInfo;
import de.kalass.sonoscontrol.api.model.deviceproperties.Icon;

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
        Assert.assertNotNull(value);
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



    @Test
    public void retrieveLEDStateTest() throws Exception{
        final LEDState value = getService().retrieveLEDState(new de.kalass.sonoscontrol.api.core.AsyncValue<LEDState>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveLEDState: " + value);
    }


    @Test
    public void retrieveInvisibleTest() throws Exception{
        final Invisible value = getService().retrieveInvisible(new de.kalass.sonoscontrol.api.core.AsyncValue<Invisible>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveInvisible: " + value);
    }






    @Test
    public void retrieveZoneAttributesTest() throws Exception{
        final GetZoneAttributesResult value = getService().retrieveZoneAttributes(new de.kalass.sonoscontrol.api.core.AsyncValue<GetZoneAttributesResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveZoneAttributes: " + value);
    }

    @Test
    public void retrieveHouseholdIDTest() throws Exception{
        final HouseholdID value = getService().retrieveHouseholdID(new de.kalass.sonoscontrol.api.core.AsyncValue<HouseholdID>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveHouseholdID: " + value);
    }

    @Test
    public void retrieveZoneInfoTest() throws Exception{
        final GetZoneInfoResult value = getService().retrieveZoneInfo(new de.kalass.sonoscontrol.api.core.AsyncValue<GetZoneInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveZoneInfo: " + value);
    }


    @Test
    public void retrieveAutoplayLinkedZonesTest() throws Exception{
        final AutoplayIncludeLinkedZones value = getService().retrieveAutoplayLinkedZones(new de.kalass.sonoscontrol.api.core.AsyncValue<AutoplayIncludeLinkedZones>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveAutoplayLinkedZones: " + value);
    }


    @Test
    public void retrieveAutoplayRoomUUIDTest() throws Exception{
        final AutoplayRoomUUID value = getService().retrieveAutoplayRoomUUID(new de.kalass.sonoscontrol.api.core.AsyncValue<AutoplayRoomUUID>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveAutoplayRoomUUID: " + value);
    }


    @Test
    public void retrieveAutoplayVolumeTest() throws Exception{
        final AutoplayVolume value = getService().retrieveAutoplayVolume(new de.kalass.sonoscontrol.api.core.AsyncValue<AutoplayVolume>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveAutoplayVolume: " + value);
    }



    @Test
    public void retrieveSpeakerSizeTest() throws Exception{
        final SpeakerSize value = getService().retrieveSpeakerSize(new de.kalass.sonoscontrol.api.core.AsyncValue<SpeakerSize>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveSpeakerSize: " + value);
    }


    @Test
    public void retrieveUseAutoplayVolumeTest() throws Exception{
        final AutoplayUseVolume value = getService().retrieveUseAutoplayVolume(new de.kalass.sonoscontrol.api.core.AsyncValue<AutoplayUseVolume>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveUseAutoplayVolume: " + value);
    }
}

