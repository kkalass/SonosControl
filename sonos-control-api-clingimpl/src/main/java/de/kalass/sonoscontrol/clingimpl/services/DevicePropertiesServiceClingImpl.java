

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

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

@SuppressWarnings("rawtypes")
public final class DevicePropertiesServiceClingImpl extends AbstractServiceImpl implements DevicePropertiesService {

    public DevicePropertiesServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("DeviceProperties", upnpService, device, errorStrategy);
    }


    public SettingsReplicationState getSettingsReplicationState() {
        throw new UnsupportedOperationException();
    }

    public ZoneName getZoneName() {
        throw new UnsupportedOperationException();
    }

    public ChannelMapSet getChannelMapSet() {
        throw new UnsupportedOperationException();
    }

    public Invisible getInvisible() {
        throw new UnsupportedOperationException();
    }

    public IsZoneBridge getIsZoneBridge() {
        throw new UnsupportedOperationException();
    }

    public Icon getIcon() {
        throw new UnsupportedOperationException();
    }


    public <C extends Callback0> C setLEDState(final LEDState desiredLEDState, final C successHandler) {
        return execute(successHandler, new Call<C>("SetLEDState") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DesiredLEDState", desiredLEDState.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<LEDState>> C retrieveLEDState(final C successHandler) {
        return execute(successHandler, new Call<C>("GetLEDState") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final LEDState value = LEDState.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setInvisible(final Invisible desiredInvisible, final C successHandler) {
        return execute(successHandler, new Call<C>("SetInvisible") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"boolean", "DesiredInvisible", desiredInvisible.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<Invisible>> C retrieveInvisible(final C successHandler) {
        return execute(successHandler, new Call<C>("GetInvisible") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final Invisible value = Invisible.getInstance(getBoolean("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C addBondedZones(final ChannelMapSet channelMapSet, final C successHandler) {
        return execute(successHandler, new Call<C>("AddBondedZones") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "ChannelMapSet", channelMapSet.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C removeBondedZones(final ChannelMapSet channelMapSet, final C successHandler) {
        return execute(successHandler, new Call<C>("RemoveBondedZones") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "ChannelMapSet", channelMapSet.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C createStereoPair(final ChannelMapSet channelMapSet, final C successHandler) {
        return execute(successHandler, new Call<C>("CreateStereoPair") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "ChannelMapSet", channelMapSet.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C separateStereoPair(final ChannelMapSet channelMapSet, final C successHandler) {
        return execute(successHandler, new Call<C>("SeparateStereoPair") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "ChannelMapSet", channelMapSet.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C setZoneAttributes(final ZoneName desiredZoneName, final Icon desiredIcon, final C successHandler) {
        return execute(successHandler, new Call<C>("SetZoneAttributes") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DesiredZoneName", desiredZoneName.getValue());
                setInput(invocation,"string", "DesiredIcon", desiredIcon.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<GetZoneAttributesResult>> C retrieveZoneAttributes(final C successHandler) {
        return execute(successHandler, new Call<C>("GetZoneAttributes") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final ZoneName value0 = ZoneName.getInstance(getString("string",output[0].getValue()));
                final Icon value1 = Icon.getInstance(getString("string",output[1].getValue()));
                final GetZoneAttributesResult value = GetZoneAttributesResult.getInstance(value0,value1);
                handler.success(value);
            }
        });
    }

    public <C extends Callback1<HouseholdID>> C retrieveHouseholdID(final C successHandler) {
        return execute(successHandler, new Call<C>("GetHouseholdID") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final HouseholdID value = HouseholdID.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback1<GetZoneInfoResult>> C retrieveZoneInfo(final C successHandler) {
        return execute(successHandler, new Call<C>("GetZoneInfo") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final SerialNumber value0 = SerialNumber.getInstance(getString("string",output[0].getValue()));
                final SoftwareVersion value1 = SoftwareVersion.getInstance(getString("string",output[1].getValue()));
                final DisplaySoftwareVersion value2 = DisplaySoftwareVersion.getInstance(getString("string",output[2].getValue()));
                final HardwareVersion value3 = HardwareVersion.getInstance(getString("string",output[3].getValue()));
                final IPAddress value4 = IPAddress.getInstance(getString("string",output[4].getValue()));
                final MACAddress value5 = MACAddress.getInstance(getString("string",output[5].getValue()));
                final CopyrightInfo value6 = CopyrightInfo.getInstance(getString("string",output[6].getValue()));
                final ExtraInfo value7 = ExtraInfo.getInstance(getString("string",output[7].getValue()));
                final GetZoneInfoResult value = GetZoneInfoResult.getInstance(value0,value1,value2,value3,value4,value5,value6,value7);
                handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setAutoplayLinkedZones(final AutoplayIncludeLinkedZones includeLinkedZones, final C successHandler) {
        return execute(successHandler, new Call<C>("SetAutoplayLinkedZones") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"boolean", "IncludeLinkedZones", includeLinkedZones.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<AutoplayIncludeLinkedZones>> C retrieveAutoplayLinkedZones(final C successHandler) {
        return execute(successHandler, new Call<C>("GetAutoplayLinkedZones") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final AutoplayIncludeLinkedZones value = AutoplayIncludeLinkedZones.getInstance(getBoolean("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setAutoplayRoomUUID(final AutoplayRoomUUID roomUUID, final C successHandler) {
        return execute(successHandler, new Call<C>("SetAutoplayRoomUUID") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "RoomUUID", roomUUID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<AutoplayRoomUUID>> C retrieveAutoplayRoomUUID(final C successHandler) {
        return execute(successHandler, new Call<C>("GetAutoplayRoomUUID") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final AutoplayRoomUUID value = AutoplayRoomUUID.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setAutoplayVolume(final AutoplayVolume volume, final C successHandler) {
        return execute(successHandler, new Call<C>("SetAutoplayVolume") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui2", "Volume", volume.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<AutoplayVolume>> C retrieveAutoplayVolume(final C successHandler) {
        return execute(successHandler, new Call<C>("GetAutoplayVolume") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final AutoplayVolume value = AutoplayVolume.getInstance(getLong("ui2",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C importSetting(final SettingID settingID, final SettingURI settingURI, final C successHandler) {
        return execute(successHandler, new Call<C>("ImportSetting") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "SettingID", settingID.getValue());
                setInput(invocation,"string", "SettingURI", settingURI.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C setSpeakerSize(final SpeakerSize speakerSize, final C successHandler) {
        return execute(successHandler, new Call<C>("SetSpeakerSize") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"i2", "SpeakerSize", speakerSize.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<SpeakerSize>> C retrieveSpeakerSize(final C successHandler) {
        return execute(successHandler, new Call<C>("GetSpeakerSize") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final SpeakerSize value = SpeakerSize.getInstance(getLong("i2",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setUseAutoplayVolume(final AutoplayUseVolume useVolume, final C successHandler) {
        return execute(successHandler, new Call<C>("SetUseAutoplayVolume") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"boolean", "UseVolume", useVolume.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<AutoplayUseVolume>> C retrieveUseAutoplayVolume(final C successHandler) {
        return execute(successHandler, new Call<C>("GetUseAutoplayVolume") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final AutoplayUseVolume value = AutoplayUseVolume.getInstance(getBoolean("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

}
