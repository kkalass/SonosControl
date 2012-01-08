/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;
import javax.annotation.CheckForNull;

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

public interface RenderingControlService {


    @CheckForNull
    LastRenderingControlChange getLastValueForLastChange();

    void addLastChangeListener(EventListener<LastRenderingControlChange> listener);

    void removeLastChangeListener(EventListener<LastRenderingControlChange> listener);


    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<Mute>> C retrieveMute(MuteChannel channel, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setMute(MuteChannel channel, Mute desiredMute, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<ResetBasicEQResult>> C resetBasicEQ(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C resetExtEQ(EQType eQType, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<Volume>> C retrieveVolume(Channel channel, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setVolume(Channel channel, Volume desiredVolume, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<Volume>> C setRelativeVolume(Channel channel, VolumeAdjustment adjustment, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<VolumeDB>> C retrieveVolumeDB(Channel channel, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setVolumeDB(Channel channel, VolumeDB desiredVolume, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<GetVolumeDBRangeResult>> C retrieveVolumeDBRange(Channel channel, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<Bass>> C retrieveBass(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setBass(Bass desiredBass, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<Treble>> C retrieveTreble(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setTreble(Treble desiredTreble, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<EQValue>> C retrieveEQ(EQType eQType, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setEQ(EQType eQType, EQValue desiredValue, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<Loudness>> C retrieveLoudness(Channel channel, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setLoudness(Channel channel, Loudness desiredLoudness, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<SupportsOutputFixed>> C retrieveSupportsOutputFixed(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<OutputFixed>> C retrieveOutputFixed(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setOutputFixed(OutputFixed desiredFixed, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<HeadphoneConnected>> C retrieveHeadphoneConnected(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<RampTimeSeconds>> C rampToVolume(Channel channel, RampType rampType, Volume desiredVolume, ResetVolumeAfter resetVolumeAfter, ProgramURI programURI, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C restoreVolumePriorToRamp(Channel channel, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setChannelMap(ChannelMap channelMap, C callback);

}
