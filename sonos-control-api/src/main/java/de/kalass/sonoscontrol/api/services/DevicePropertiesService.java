package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayIncludeLinkedZones;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayRoomUUID;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayUseVolume;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayVolume;
import de.kalass.sonoscontrol.api.model.deviceproperties.ChannelMapSet;
import de.kalass.sonoscontrol.api.model.deviceproperties.HouseholdID;
import de.kalass.sonoscontrol.api.model.deviceproperties.Icon;
import de.kalass.sonoscontrol.api.model.deviceproperties.Invisible;
import de.kalass.sonoscontrol.api.model.deviceproperties.LEDState;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingID;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingURI;
import de.kalass.sonoscontrol.api.model.deviceproperties.SpeakerSize;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneAttributes;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneInfo;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

public interface DevicePropertiesService {


    <C extends Callback0> C setLEDState(LEDState desiredLEDState, C callback);

    <C extends Callback1<LEDState>> C retrieveLEDState(C callback);

    <C extends Callback0> C setInvisible(Invisible desiredInvisible, C callback);

    <C extends Callback1<Invisible>> C retrieveInvisible(C callback);

    <C extends Callback0> C addBondedZones(ChannelMapSet channelMapSet, C callback);

    <C extends Callback0> C removeBondedZones(ChannelMapSet channelMapSet, C callback);

    <C extends Callback0> C createStereoPair(ChannelMapSet channelMapSet, C callback);

    <C extends Callback0> C separateStereoPair(ChannelMapSet channelMapSet, C callback);

    <C extends Callback0> C setZoneAttributes(ZoneName desiredZoneName, Icon desiredIcon, C callback);

    <C extends Callback1<ZoneAttributes>> C retrieveZoneAttributes(C callback);

    <C extends Callback1<HouseholdID>> C retrieveHouseholdID(C callback);

    <C extends Callback1<ZoneInfo>> C retrieveZoneInfo(C callback);

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
