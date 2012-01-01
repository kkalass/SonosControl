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

    public <C extends Callback0> C setLEDState(LEDState desiredLEDState, C callback);

    public <C extends Callback1<LEDState>> C getLEDState(C callback);

    public <C extends Callback0> C setInvisible(Invisible desiredInvisible, C callback);

    public <C extends Callback1<Invisible>> C getInvisible(C callback);

    public <C extends Callback0> C addBondedZones(ChannelMapSet channelMapSet, C callback);

    public <C extends Callback0> C removeBondedZones(ChannelMapSet channelMapSet, C callback);

    public <C extends Callback0> C createStereoPair(ChannelMapSet channelMapSet, C callback);

    public <C extends Callback0> C separateStereoPair(ChannelMapSet channelMapSet, C callback);

    public <C extends Callback0> C setZoneAttributes(ZoneName desiredZoneName, Icon desiredIcon, C callback);

    public <C extends Callback1<ZoneAttributes>> C getZoneAttributes(C callback);

    public <C extends Callback1<HouseholdID>> C getHouseholdID(C callback);

    public <C extends Callback1<ZoneInfo>> C getZoneInfo(C callback);

    public <C extends Callback0> C setAutoplayLinkedZones(AutoplayIncludeLinkedZones includeLinkedZones, C callback);

    public <C extends Callback1<AutoplayIncludeLinkedZones>> C getAutoplayLinkedZones(C callback);

    public <C extends Callback0> C setAutoplayRoomUUID(AutoplayRoomUUID roomUUID, C callback);

    public <C extends Callback1<AutoplayRoomUUID>> C getAutoplayRoomUUID(C callback);

    public <C extends Callback0> C setAutoplayVolume(AutoplayVolume volume, C callback);

    public <C extends Callback1<AutoplayVolume>> C getAutoplayVolume(C callback);

    public <C extends Callback0> C importSetting(SettingID settingID, SettingURI settingURI, C callback);

    public <C extends Callback0> C setSpeakerSize(SpeakerSize speakerSize, C callback);

    public <C extends Callback1<SpeakerSize>> C getSpeakerSize(C callback);

    public <C extends Callback0> C setUseAutoplayVolume(AutoplayUseVolume useVolume, C callback);

    public <C extends Callback1<AutoplayUseVolume>> C getUseAutoplayVolume(C callback);
}
