/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.core.EventListener;

import org.teleal.cling.model.gena.GENASubscription;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.state.StateVariableValue;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.google.common.base.Objects;

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
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(DevicePropertiesServiceClingImpl.class);
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();
    
    private final List<EventListener<SettingsReplicationState>> _changeSettingsReplicationStateListeners = new ArrayList<EventListener<SettingsReplicationState>>();
    private final List<EventListener<ZoneName>> _changeZoneNameListeners = new ArrayList<EventListener<ZoneName>>();
    private final List<EventListener<ChannelMapSet>> _changeChannelMapSetListeners = new ArrayList<EventListener<ChannelMapSet>>();
    private final List<EventListener<Invisible>> _changeInvisibleListeners = new ArrayList<EventListener<Invisible>>();
    private final List<EventListener<IsZoneBridge>> _changeIsZoneBridgeListeners = new ArrayList<EventListener<IsZoneBridge>>();
    private final List<EventListener<Icon>> _changeIconListeners = new ArrayList<EventListener<Icon>>();

    public DevicePropertiesServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("DeviceProperties", upnpService, device, errorStrategy);
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
                 final LEDState value = LEDState.getInstance((String)getValue("string",output[0].getValue()));
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
                 final Invisible value = Invisible.getInstance((Boolean)getValue("boolean",output[0].getValue()));
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
                final ZoneName currentZoneName = ZoneName.getInstance((String)getValue("string",output[0].getValue()));
                final Icon currentIcon = Icon.getInstance((String)getValue("string",output[1].getValue()));
                final GetZoneAttributesResult value = GetZoneAttributesResult.getInstance(currentZoneName,currentIcon);
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
                 final HouseholdID value = HouseholdID.getInstance((String)getValue("string",output[0].getValue()));
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
                final SerialNumber serialNumber = SerialNumber.getInstance((String)getValue("string",output[0].getValue()));
                final SoftwareVersion softwareVersion = SoftwareVersion.getInstance((String)getValue("string",output[1].getValue()));
                final DisplaySoftwareVersion displaySoftwareVersion = DisplaySoftwareVersion.getInstance((String)getValue("string",output[2].getValue()));
                final HardwareVersion hardwareVersion = HardwareVersion.getInstance((String)getValue("string",output[3].getValue()));
                final IPAddress iPAddress = IPAddress.getInstance((String)getValue("string",output[4].getValue()));
                final MACAddress mACAddress = MACAddress.getInstance((String)getValue("string",output[5].getValue()));
                final CopyrightInfo copyrightInfo = CopyrightInfo.getInstance((String)getValue("string",output[6].getValue()));
                final ExtraInfo extraInfo = ExtraInfo.getInstance((String)getValue("string",output[7].getValue()));
                final GetZoneInfoResult value = GetZoneInfoResult.getInstance(serialNumber,softwareVersion,displaySoftwareVersion,hardwareVersion,iPAddress,mACAddress,copyrightInfo,extraInfo);
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
                 final AutoplayIncludeLinkedZones value = AutoplayIncludeLinkedZones.getInstance((Boolean)getValue("boolean",output[0].getValue()));
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
                 final AutoplayRoomUUID value = AutoplayRoomUUID.getInstance((String)getValue("string",output[0].getValue()));
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
                 final AutoplayVolume value = AutoplayVolume.getInstance((Long)getValue("ui2",output[0].getValue()));
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
                 final SpeakerSize value = SpeakerSize.getInstance((Long)getValue("i2",output[0].getValue()));
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
                 final AutoplayUseVolume value = AutoplayUseVolume.getInstance((Boolean)getValue("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        SettingsReplicationState newSettingsReplicationState = null;
        SettingsReplicationState oldSettingsReplicationState = (SettingsReplicationState)stored.get("SettingsReplicationState");
        try {
        newSettingsReplicationState = convertSettingsReplicationState((String)getValue("string", ((StateVariableValue)values.get("SettingsReplicationState")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for SettingsReplicationState, will ignore", e);
            // make sure the value is not changed/overridden
            newSettingsReplicationState = null;
            oldSettingsReplicationState = null;
        }
        if (!Objects.equal(oldSettingsReplicationState, newSettingsReplicationState)) {
            _eventedValues.put("SettingsReplicationState", newSettingsReplicationState);
        }

        ZoneName newZoneName = null;
        ZoneName oldZoneName = (ZoneName)stored.get("ZoneName");
        try {
        newZoneName = convertZoneName((String)getValue("string", ((StateVariableValue)values.get("ZoneName")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for ZoneName, will ignore", e);
            // make sure the value is not changed/overridden
            newZoneName = null;
            oldZoneName = null;
        }
        if (!Objects.equal(oldZoneName, newZoneName)) {
            _eventedValues.put("ZoneName", newZoneName);
        }

        ChannelMapSet newChannelMapSet = null;
        ChannelMapSet oldChannelMapSet = (ChannelMapSet)stored.get("ChannelMapSet");
        try {
        newChannelMapSet = convertChannelMapSet((String)getValue("string", ((StateVariableValue)values.get("ChannelMapSet")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for ChannelMapSet, will ignore", e);
            // make sure the value is not changed/overridden
            newChannelMapSet = null;
            oldChannelMapSet = null;
        }
        if (!Objects.equal(oldChannelMapSet, newChannelMapSet)) {
            _eventedValues.put("ChannelMapSet", newChannelMapSet);
        }

        Invisible newInvisible = null;
        Invisible oldInvisible = (Invisible)stored.get("Invisible");
        try {
        newInvisible = convertInvisible((Boolean)getValue("boolean", ((StateVariableValue)values.get("Invisible")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for Invisible, will ignore", e);
            // make sure the value is not changed/overridden
            newInvisible = null;
            oldInvisible = null;
        }
        if (!Objects.equal(oldInvisible, newInvisible)) {
            _eventedValues.put("Invisible", newInvisible);
        }

        IsZoneBridge newIsZoneBridge = null;
        IsZoneBridge oldIsZoneBridge = (IsZoneBridge)stored.get("IsZoneBridge");
        try {
        newIsZoneBridge = convertIsZoneBridge((Boolean)getValue("boolean", ((StateVariableValue)values.get("IsZoneBridge")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for IsZoneBridge, will ignore", e);
            // make sure the value is not changed/overridden
            newIsZoneBridge = null;
            oldIsZoneBridge = null;
        }
        if (!Objects.equal(oldIsZoneBridge, newIsZoneBridge)) {
            _eventedValues.put("IsZoneBridge", newIsZoneBridge);
        }

        Icon newIcon = null;
        Icon oldIcon = (Icon)stored.get("Icon");
        try {
        newIcon = convertIcon((String)getValue("string", ((StateVariableValue)values.get("Icon")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for Icon, will ignore", e);
            // make sure the value is not changed/overridden
            newIcon = null;
            oldIcon = null;
        }
        if (!Objects.equal(oldIcon, newIcon)) {
            _eventedValues.put("Icon", newIcon);
        }

        // after the values were updated, send the change notifications

        if (!Objects.equal(oldSettingsReplicationState, newSettingsReplicationState)) {
            notifySettingsReplicationStateChanged(oldSettingsReplicationState, newSettingsReplicationState);
        }

        if (!Objects.equal(oldZoneName, newZoneName)) {
            notifyZoneNameChanged(oldZoneName, newZoneName);
        }

        if (!Objects.equal(oldChannelMapSet, newChannelMapSet)) {
            notifyChannelMapSetChanged(oldChannelMapSet, newChannelMapSet);
        }

        if (!Objects.equal(oldInvisible, newInvisible)) {
            notifyInvisibleChanged(oldInvisible, newInvisible);
        }

        if (!Objects.equal(oldIsZoneBridge, newIsZoneBridge)) {
            notifyIsZoneBridgeChanged(oldIsZoneBridge, newIsZoneBridge);
        }

        if (!Objects.equal(oldIcon, newIcon)) {
            notifyIconChanged(oldIcon, newIcon);
        }
    }

    protected Object getEventedValueOrWait(String key) {
        try {
            _eventsReceivedLatch.await();
        } catch (InterruptedException e) {
            LOG.warn("waiting for evented value countdown latch was interrupted, will continue");
        }
        return _eventedValues.get(key);
    }


    public SettingsReplicationState getSettingsReplicationState() {
        return (SettingsReplicationState)getEventedValueOrWait("SettingsReplicationState");
    }

    public void addSettingsReplicationStateListener(EventListener<SettingsReplicationState> listener) {
        synchronized(_changeSettingsReplicationStateListeners) {
            _changeSettingsReplicationStateListeners.add(listener);
        }
    }

    public void removeSettingsReplicationStateListener(EventListener<SettingsReplicationState> listener) {
        synchronized(_changeSettingsReplicationStateListeners) {
            _changeSettingsReplicationStateListeners.remove(listener);
        }
    }

    protected void notifySettingsReplicationStateChanged(SettingsReplicationState oldValue, SettingsReplicationState newValue) {
        final Iterable<EventListener<SettingsReplicationState>> listeners;
        synchronized(_changeSettingsReplicationStateListeners) {
            listeners = new ArrayList<EventListener<SettingsReplicationState>>(_changeSettingsReplicationStateListeners);            
        }
        for(EventListener<SettingsReplicationState> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  SettingsReplicationState convertSettingsReplicationState(String rawValue) {
        return SettingsReplicationState.getInstance(rawValue);
    }

    public ZoneName getZoneName() {
        return (ZoneName)getEventedValueOrWait("ZoneName");
    }

    public void addZoneNameListener(EventListener<ZoneName> listener) {
        synchronized(_changeZoneNameListeners) {
            _changeZoneNameListeners.add(listener);
        }
    }

    public void removeZoneNameListener(EventListener<ZoneName> listener) {
        synchronized(_changeZoneNameListeners) {
            _changeZoneNameListeners.remove(listener);
        }
    }

    protected void notifyZoneNameChanged(ZoneName oldValue, ZoneName newValue) {
        final Iterable<EventListener<ZoneName>> listeners;
        synchronized(_changeZoneNameListeners) {
            listeners = new ArrayList<EventListener<ZoneName>>(_changeZoneNameListeners);            
        }
        for(EventListener<ZoneName> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  ZoneName convertZoneName(String rawValue) {
        return ZoneName.getInstance(rawValue);
    }
    

    public ChannelMapSet getChannelMapSet() {
        return (ChannelMapSet)getEventedValueOrWait("ChannelMapSet");
    }

    public void addChannelMapSetListener(EventListener<ChannelMapSet> listener) {
        synchronized(_changeChannelMapSetListeners) {
            _changeChannelMapSetListeners.add(listener);
        }
    }

    public void removeChannelMapSetListener(EventListener<ChannelMapSet> listener) {
        synchronized(_changeChannelMapSetListeners) {
            _changeChannelMapSetListeners.remove(listener);
        }
    }

    protected void notifyChannelMapSetChanged(ChannelMapSet oldValue, ChannelMapSet newValue) {
        final Iterable<EventListener<ChannelMapSet>> listeners;
        synchronized(_changeChannelMapSetListeners) {
            listeners = new ArrayList<EventListener<ChannelMapSet>>(_changeChannelMapSetListeners);            
        }
        for(EventListener<ChannelMapSet> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  ChannelMapSet convertChannelMapSet(String rawValue) {
        return ChannelMapSet.getInstance(rawValue);
    }
    
    
    
    
    
    
    
    
    
    
    
    

    public Invisible getInvisible() {
        return (Invisible)getEventedValueOrWait("Invisible");
    }

    public void addInvisibleListener(EventListener<Invisible> listener) {
        synchronized(_changeInvisibleListeners) {
            _changeInvisibleListeners.add(listener);
        }
    }

    public void removeInvisibleListener(EventListener<Invisible> listener) {
        synchronized(_changeInvisibleListeners) {
            _changeInvisibleListeners.remove(listener);
        }
    }

    protected void notifyInvisibleChanged(Invisible oldValue, Invisible newValue) {
        final Iterable<EventListener<Invisible>> listeners;
        synchronized(_changeInvisibleListeners) {
            listeners = new ArrayList<EventListener<Invisible>>(_changeInvisibleListeners);            
        }
        for(EventListener<Invisible> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  Invisible convertInvisible(Boolean rawValue) {
        return Invisible.getInstance(rawValue);
    }
    

    public IsZoneBridge getIsZoneBridge() {
        return (IsZoneBridge)getEventedValueOrWait("IsZoneBridge");
    }

    public void addIsZoneBridgeListener(EventListener<IsZoneBridge> listener) {
        synchronized(_changeIsZoneBridgeListeners) {
            _changeIsZoneBridgeListeners.add(listener);
        }
    }

    public void removeIsZoneBridgeListener(EventListener<IsZoneBridge> listener) {
        synchronized(_changeIsZoneBridgeListeners) {
            _changeIsZoneBridgeListeners.remove(listener);
        }
    }

    protected void notifyIsZoneBridgeChanged(IsZoneBridge oldValue, IsZoneBridge newValue) {
        final Iterable<EventListener<IsZoneBridge>> listeners;
        synchronized(_changeIsZoneBridgeListeners) {
            listeners = new ArrayList<EventListener<IsZoneBridge>>(_changeIsZoneBridgeListeners);            
        }
        for(EventListener<IsZoneBridge> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  IsZoneBridge convertIsZoneBridge(Boolean rawValue) {
        return IsZoneBridge.getInstance(rawValue);
    }
    
    

    public Icon getIcon() {
        return (Icon)getEventedValueOrWait("Icon");
    }

    public void addIconListener(EventListener<Icon> listener) {
        synchronized(_changeIconListeners) {
            _changeIconListeners.add(listener);
        }
    }

    public void removeIconListener(EventListener<Icon> listener) {
        synchronized(_changeIconListeners) {
            _changeIconListeners.remove(listener);
        }
    }

    protected void notifyIconChanged(Icon oldValue, Icon newValue) {
        final Iterable<EventListener<Icon>> listeners;
        synchronized(_changeIconListeners) {
            listeners = new ArrayList<EventListener<Icon>>(_changeIconListeners);            
        }
        for(EventListener<Icon> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  Icon convertIcon(String rawValue) {
        return Icon.getInstance(rawValue);
    }
    
}
