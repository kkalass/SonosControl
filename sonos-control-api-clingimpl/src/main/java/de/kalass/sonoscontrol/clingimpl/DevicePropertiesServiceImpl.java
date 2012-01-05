package de.kalass.sonoscontrol.clingimpl;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayIncludeLinkedZones;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayRoomUUID;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayUseVolume;
import de.kalass.sonoscontrol.api.model.deviceproperties.AutoplayVolume;
import de.kalass.sonoscontrol.api.model.deviceproperties.ChannelMapSet;
import de.kalass.sonoscontrol.api.model.deviceproperties.HouseholdID;
import de.kalass.sonoscontrol.api.model.deviceproperties.Icon;
import de.kalass.sonoscontrol.api.model.deviceproperties.Invisible;
import de.kalass.sonoscontrol.api.model.deviceproperties.IsZoneBridge;
import de.kalass.sonoscontrol.api.model.deviceproperties.LEDState;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingID;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingURI;
import de.kalass.sonoscontrol.api.model.deviceproperties.SettingsReplicationState;
import de.kalass.sonoscontrol.api.model.deviceproperties.SpeakerSize;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneAttributes;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneInfo;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

@SuppressWarnings("rawtypes")
public class DevicePropertiesServiceImpl extends AbstractServiceImpl implements DevicePropertiesService {
    //private static final Logger LOG = LoggerFactory.getLogger(DevicePropertiesServiceImpl.class);

    public DevicePropertiesServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("DeviceProperties", upnpService, device, errorStrategy);
    }

    @Override
    public <C extends Callback1<ZoneAttributes>> C retrieveZoneAttributes(final C successHandler) {
        return execute(successHandler, new Call2<ZoneAttributes>("GetZoneAttributes") {
            @Override
            public void success(
                    Callback1<ZoneAttributes> handler,
                    ActionArgumentValue p1, ActionArgumentValue p2) {
                final ZoneName currentZoneName = ZoneName.getInstance((String)p1.getValue());
                final Icon currentIcon = Icon.getInstance((String)p2.getValue());
                successHandler.success(new ZoneAttributes(currentZoneName, currentIcon));
            }
        });
    }

    @Override
    public <C extends Callback0> C setLEDState(LEDState desiredLEDState,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<LEDState>> C retrieveLEDState(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setInvisible(Invisible desiredInvisible,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<Invisible>> C retrieveInvisible(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C addBondedZones(ChannelMapSet channelMapSet,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C removeBondedZones(
            ChannelMapSet channelMapSet, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C createStereoPair(
            ChannelMapSet channelMapSet, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C separateStereoPair(
            ChannelMapSet channelMapSet, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setZoneAttributes(ZoneName desiredZoneName,
            Icon desiredIcon, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<HouseholdID>> C retrieveHouseholdID(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<ZoneInfo>> C retrieveZoneInfo(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setAutoplayLinkedZones(
            AutoplayIncludeLinkedZones includeLinkedZones, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<AutoplayIncludeLinkedZones>> C retrieveAutoplayLinkedZones(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setAutoplayRoomUUID(
            AutoplayRoomUUID roomUUID, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<AutoplayRoomUUID>> C retrieveAutoplayRoomUUID(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setAutoplayVolume(AutoplayVolume volume,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<AutoplayVolume>> C retrieveAutoplayVolume(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C importSetting(SettingID settingID,
            SettingURI settingURI, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setSpeakerSize(SpeakerSize speakerSize,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<SpeakerSize>> C retrieveSpeakerSize(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setUseAutoplayVolume(
            AutoplayUseVolume useVolume, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<AutoplayUseVolume>> C retrieveUseAutoplayVolume(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SettingsReplicationState getSettingsReplicationState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ZoneName getZoneName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelMapSet getChannelMapSet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Invisible getInvisible() {
        throw new UnsupportedOperationException();
    }

    @Override
    public IsZoneBridge getIsZoneBridge() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Icon getIcon() {
        throw new UnsupportedOperationException();
    }


}
