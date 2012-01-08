

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.RenderingControlService;
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
import de.kalass.sonoscontrol.api.model.renderingcontrol.Mute;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ResetBasicEQResult;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Volume;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeDB;
import de.kalass.sonoscontrol.api.model.renderingcontrol.GetVolumeDBRangeResult;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Bass;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Treble;
import de.kalass.sonoscontrol.api.model.renderingcontrol.EQValue;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Loudness;
import de.kalass.sonoscontrol.api.model.renderingcontrol.SupportsOutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.OutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.HeadphoneConnected;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RampTimeSeconds;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RampType;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeAdjustment;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RightVolume;
import de.kalass.sonoscontrol.api.model.renderingcontrol.MuteChannel;
import de.kalass.sonoscontrol.api.model.InstanceID;
import de.kalass.sonoscontrol.api.model.renderingcontrol.LeftVolume;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ProgramURI;
import de.kalass.sonoscontrol.api.model.renderingcontrol.EQType;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ChannelMap;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Channel;
import de.kalass.sonoscontrol.api.eventmodels.renderingcontrol.LastRenderingControlChange;

@SuppressWarnings("rawtypes")
public abstract class RenderingControlServiceClingImpl extends AbstractServiceImpl implements RenderingControlService {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(RenderingControlServiceClingImpl.class);
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();
    private final CountDownLatch _eventsReceivedLatch = new CountDownLatch(1);
    private final List<EventListener<LastRenderingControlChange>> _changeLastChangeListeners = new ArrayList<EventListener<LastRenderingControlChange>>();

    public RenderingControlServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("RenderingControl", upnpService, device, errorStrategy);
    }


    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<Mute>> C retrieveMute(final MuteChannel channel, final C successHandler) {
        return execute(successHandler, new Call<C>("GetMute") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final Mute value = Mute.getInstance((Boolean)getValue("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setMute(final MuteChannel channel, final Mute desiredMute, final C successHandler) {
        return execute(successHandler, new Call<C>("SetMute") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
                setInput(invocation,"boolean", "DesiredMute", desiredMute.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<ResetBasicEQResult>> C resetBasicEQ(final C successHandler) {
        return execute(successHandler, new Call<C>("ResetBasicEQ") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final Bass bass = Bass.getInstance((Long)getValue("i2",output[0].getValue()));
                final Treble treble = Treble.getInstance((Long)getValue("i2",output[1].getValue()));
                final Loudness loudness = Loudness.getInstance((Boolean)getValue("boolean",output[2].getValue()));
                final LeftVolume leftVolume = LeftVolume.getInstance((Long)getValue("ui2",output[3].getValue()));
                final RightVolume rightVolume = RightVolume.getInstance((Long)getValue("ui2",output[4].getValue()));
                final ResetBasicEQResult value = ResetBasicEQResult.getInstance(bass,treble,loudness,leftVolume,rightVolume);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C resetExtEQ(final EQType eQType, final C successHandler) {
        return execute(successHandler, new Call<C>("ResetExtEQ") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "EQType", eQType.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<Volume>> C retrieveVolume(final Channel channel, final C successHandler) {
        return execute(successHandler, new Call<C>("GetVolume") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final Volume value = Volume.getInstance((Long)getValue("ui2",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setVolume(final Channel channel, final Volume desiredVolume, final C successHandler) {
        return execute(successHandler, new Call<C>("SetVolume") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
                setInput(invocation,"ui2", "DesiredVolume", desiredVolume.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<Volume>> C setRelativeVolume(final Channel channel, final VolumeAdjustment adjustment, final C successHandler) {
        return execute(successHandler, new Call<C>("SetRelativeVolume") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
                setInput(invocation,"i4", "Adjustment", adjustment.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final Volume value = Volume.getInstance((Long)getValue("ui2",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<VolumeDB>> C retrieveVolumeDB(final Channel channel, final C successHandler) {
        return execute(successHandler, new Call<C>("GetVolumeDB") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final VolumeDB value = VolumeDB.getInstance((Long)getValue("i2",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setVolumeDB(final Channel channel, final VolumeDB desiredVolume, final C successHandler) {
        return execute(successHandler, new Call<C>("SetVolumeDB") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
                setInput(invocation,"i2", "DesiredVolume", desiredVolume.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<GetVolumeDBRangeResult>> C retrieveVolumeDBRange(final Channel channel, final C successHandler) {
        return execute(successHandler, new Call<C>("GetVolumeDBRange") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final VolumeDB minValue = VolumeDB.getInstance((Long)getValue("i2",output[0].getValue()));
                final VolumeDB maxValue = VolumeDB.getInstance((Long)getValue("i2",output[1].getValue()));
                final GetVolumeDBRangeResult value = GetVolumeDBRangeResult.getInstance(minValue,maxValue);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<Bass>> C retrieveBass(final C successHandler) {
        return execute(successHandler, new Call<C>("GetBass") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final Bass value = Bass.getInstance((Long)getValue("i2",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setBass(final Bass desiredBass, final C successHandler) {
        return execute(successHandler, new Call<C>("SetBass") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"i2", "DesiredBass", desiredBass.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<Treble>> C retrieveTreble(final C successHandler) {
        return execute(successHandler, new Call<C>("GetTreble") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final Treble value = Treble.getInstance((Long)getValue("i2",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setTreble(final Treble desiredTreble, final C successHandler) {
        return execute(successHandler, new Call<C>("SetTreble") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"i2", "DesiredTreble", desiredTreble.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<EQValue>> C retrieveEQ(final EQType eQType, final C successHandler) {
        return execute(successHandler, new Call<C>("GetEQ") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "EQType", eQType.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final EQValue value = EQValue.getInstance((Long)getValue("i2",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setEQ(final EQType eQType, final EQValue desiredValue, final C successHandler) {
        return execute(successHandler, new Call<C>("SetEQ") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "EQType", eQType.getValue());
                setInput(invocation,"i2", "DesiredValue", desiredValue.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<Loudness>> C retrieveLoudness(final Channel channel, final C successHandler) {
        return execute(successHandler, new Call<C>("GetLoudness") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final Loudness value = Loudness.getInstance((Boolean)getValue("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setLoudness(final Channel channel, final Loudness desiredLoudness, final C successHandler) {
        return execute(successHandler, new Call<C>("SetLoudness") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
                setInput(invocation,"boolean", "DesiredLoudness", desiredLoudness.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<SupportsOutputFixed>> C retrieveSupportsOutputFixed(final C successHandler) {
        return execute(successHandler, new Call<C>("GetSupportsOutputFixed") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final SupportsOutputFixed value = SupportsOutputFixed.getInstance((Boolean)getValue("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<OutputFixed>> C retrieveOutputFixed(final C successHandler) {
        return execute(successHandler, new Call<C>("GetOutputFixed") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final OutputFixed value = OutputFixed.getInstance((Boolean)getValue("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setOutputFixed(final OutputFixed desiredFixed, final C successHandler) {
        return execute(successHandler, new Call<C>("SetOutputFixed") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"boolean", "DesiredFixed", desiredFixed.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<HeadphoneConnected>> C retrieveHeadphoneConnected(final C successHandler) {
        return execute(successHandler, new Call<C>("GetHeadphoneConnected") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final HeadphoneConnected value = HeadphoneConnected.getInstance((Boolean)getValue("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<RampTimeSeconds>> C rampToVolume(final Channel channel, final RampType rampType, final Volume desiredVolume, final ResetVolumeAfter resetVolumeAfter, final ProgramURI programURI, final C successHandler) {
        return execute(successHandler, new Call<C>("RampToVolume") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
                setInput(invocation,"string", "RampType", rampType.getValue());
                setInput(invocation,"ui2", "DesiredVolume", desiredVolume.getValue());
                setInput(invocation,"boolean", "ResetVolumeAfter", resetVolumeAfter.getValue());
                setInput(invocation,"string", "ProgramURI", programURI.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final RampTimeSeconds value = RampTimeSeconds.getInstance((Long)getValue("ui4",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C restoreVolumePriorToRamp(final Channel channel, final C successHandler) {
        return execute(successHandler, new Call<C>("RestoreVolumePriorToRamp") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Channel", channel.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setChannelMap(final ChannelMap channelMap, final C successHandler) {
        return execute(successHandler, new Call<C>("SetChannelMap") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "ChannelMap", channelMap.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        final LastRenderingControlChange newLastChange = convertLastChange((String)getValue("string", ((StateVariableValue)values.get("LastChange")).getValue()));
        final LastRenderingControlChange oldLastChange = (LastRenderingControlChange)stored.get("LastChange");
        if (!Objects.equal(oldLastChange, newLastChange)) {
            _eventedValues.put("LastChange", newLastChange);
        }

        // after the values were updated, send the change notifications

        if (!Objects.equal(oldLastChange, newLastChange)) {
            notifyLastChangeChanged(oldLastChange, newLastChange);
        }
        _eventsReceivedLatch.countDown();
    }

    protected Object getEventedValueOrWait(String key) {
        try {
            _eventsReceivedLatch.await();
        } catch (InterruptedException e) {
            LOG.warn("waiting for evented value countdown latch was interrupted, will continue");
        }
        return _eventedValues.get(key);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public LastRenderingControlChange getLastChange() {
        return (LastRenderingControlChange)getEventedValueOrWait("LastChange");
    }

    public void addLastChangeListener(EventListener<LastRenderingControlChange> listener) {
        synchronized(_changeLastChangeListeners) {
            _changeLastChangeListeners.add(listener);
        }
    }

    public void removeLastChangeListener(EventListener<LastRenderingControlChange> listener) {
        synchronized(_changeLastChangeListeners) {
            _changeLastChangeListeners.remove(listener);
        }
    }

    protected void notifyLastChangeChanged(LastRenderingControlChange oldValue, LastRenderingControlChange newValue) {
        final Iterable<EventListener<LastRenderingControlChange>> listeners;
        synchronized(_changeLastChangeListeners) {
            listeners = new ArrayList<EventListener<LastRenderingControlChange>>(_changeLastChangeListeners);            
        }
        for(EventListener<LastRenderingControlChange> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected abstract LastRenderingControlChange convertLastChange(String rawValue);
}
