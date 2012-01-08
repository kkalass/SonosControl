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

    @Test
    public void testGetSettingsReplicationState() {
        final SettingsReplicationState value = getService().getSettingsReplicationState();
        Assert.assertNotNull(value);
        System.out.println("Got SettingsReplicationState: " + value);
    }
    @Test
    public void testGetZoneName() {
        final ZoneName value = getService().getZoneName();
        Assert.assertNotNull(value);
        System.out.println("Got ZoneName: " + value);
    }
    @Test
    public void testGetChannelMapSet() {
        final ChannelMapSet value = getService().getChannelMapSet();
        Assert.assertNotNull(value);
        System.out.println("Got ChannelMapSet: " + value);
    }
    @Test
    public void testGetInvisible() {
        final Invisible value = getService().getInvisible();
        Assert.assertNotNull(value);
        System.out.println("Got Invisible: " + value);
    }
    @Test
    public void testGetIsZoneBridge() {
        final IsZoneBridge value = getService().getIsZoneBridge();
        Assert.assertNotNull(value);
        System.out.println("Got IsZoneBridge: " + value);
    }
    @Test
    public void testGetIcon() {
        final Icon value = getService().getIcon();
        Assert.assertNotNull(value);
        System.out.println("Got Icon: " + value);
    }

}

