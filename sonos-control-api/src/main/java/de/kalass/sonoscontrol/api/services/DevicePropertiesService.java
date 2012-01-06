/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;

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

public interface DevicePropertiesService {


    SettingsReplicationState getSettingsReplicationState();

    void addSettingsReplicationStateListener(EventListener<SettingsReplicationState> listener);

    void removeSettingsReplicationStateListener(EventListener<SettingsReplicationState> listener);

    ZoneName getZoneName();

    void addZoneNameListener(EventListener<ZoneName> listener);

    void removeZoneNameListener(EventListener<ZoneName> listener);

    ChannelMapSet getChannelMapSet();

    void addChannelMapSetListener(EventListener<ChannelMapSet> listener);

    void removeChannelMapSetListener(EventListener<ChannelMapSet> listener);

    Invisible getInvisible();

    void addInvisibleListener(EventListener<Invisible> listener);

    void removeInvisibleListener(EventListener<Invisible> listener);

    IsZoneBridge getIsZoneBridge();

    void addIsZoneBridgeListener(EventListener<IsZoneBridge> listener);

    void removeIsZoneBridgeListener(EventListener<IsZoneBridge> listener);

    Icon getIcon();

    void addIconListener(EventListener<Icon> listener);

    void removeIconListener(EventListener<Icon> listener);


    <C extends Callback0> C setLEDState(LEDState desiredLEDState, C callback);

    <C extends Callback1<LEDState>> C retrieveLEDState(C callback);

    <C extends Callback0> C setInvisible(Invisible desiredInvisible, C callback);

    <C extends Callback1<Invisible>> C retrieveInvisible(C callback);

    <C extends Callback0> C addBondedZones(ChannelMapSet channelMapSet, C callback);

    <C extends Callback0> C removeBondedZones(ChannelMapSet channelMapSet, C callback);

    <C extends Callback0> C createStereoPair(ChannelMapSet channelMapSet, C callback);

    <C extends Callback0> C separateStereoPair(ChannelMapSet channelMapSet, C callback);

    <C extends Callback0> C setZoneAttributes(ZoneName desiredZoneName, Icon desiredIcon, C callback);

    <C extends Callback1<GetZoneAttributesResult>> C retrieveZoneAttributes(C callback);

    <C extends Callback1<HouseholdID>> C retrieveHouseholdID(C callback);

    <C extends Callback1<GetZoneInfoResult>> C retrieveZoneInfo(C callback);

    <C extends Callback0> C setAutoplayLinkedZones(AutoplayIncludeLinkedZones includeLinkedZones, C callback);

    <C extends Callback1<AutoplayIncludeLinkedZones>> C retrieveAutoplayLinkedZones(C callback);

    <C extends Callback0> C setAutoplayRoomUUID(AutoplayRoomUUID roomUUID, C callback);

    <C extends Callback1<AutoplayRoomUUID>> C retrieveAutoplayRoomUUID(C callback);

    <C extends Callback0> C setAutoplayVolume(AutoplayVolume volume, C callback);

    <C extends Callback1<AutoplayVolume>> C retrieveAutoplayVolume(C callback);

    <C extends Callback0> C importSetting(SettingID settingID, SettingURI settingURI, C callback);

    <C extends Callback0> C setSpeakerSize(SpeakerSize speakerSize, C callback);

    <C extends Callback1<SpeakerSize>> C retrieveSpeakerSize(C callback);

    <C extends Callback0> C setUseAutoplayVolume(AutoplayUseVolume useVolume, C callback);

    <C extends Callback1<AutoplayUseVolume>> C retrieveUseAutoplayVolume(C callback);

}
