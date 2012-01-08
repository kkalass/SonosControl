/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.eventmodels.renderingcontrol;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.model.InstanceID;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Bass;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Channel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.HeadphoneConnected;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Loudness;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Mute;
import de.kalass.sonoscontrol.api.model.renderingcontrol.OutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Treble;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Volume;

public final class LastRenderingControlChange implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
 <Event xmlns="urn:schemas-upnp-org:metadata-1-0/RCS/">
    <InstanceID val="0">
        <Volume channel="Master" val="75" />
        <Volume channel="LF" val="100" />
        <Volume channel="RF" val="100" />
        <Mute channel="Master" val="0" />
        <Mute channel="LF" val="0" />
        <Mute channel="RF" val="0" />
        <Bass val="0" />
        <Treble val="0" />
        <Loudness channel="Master" val="0" />
        <OutputFixed val="0" />
        <HeadphoneConnected val="0" />
        <PresetNameList>FactoryDefaults</PresetNameList>
    </InstanceID>
</Event>
     */
    private final InstanceID _instanceId;
    private final Map<Channel, Volume> _volumes;
    private final Map<Channel, Mute> _mutes;
    private final Bass _bass;
    private final Treble _treble;
    private final Loudness _masterLoudness;
    private final OutputFixed _outputFixed;
    private final HeadphoneConnected _headphoneConnected;
    private final List<String> _presetNameList;


    public LastRenderingControlChange(InstanceID instanceId, Map<Channel, Volume> volumes,
            Map<Channel, Mute> mutes, Bass bass, Treble treble,
            Loudness masterLoudness, OutputFixed outputFixed,
            HeadphoneConnected headphoneConnected, List<String> presetNameList) {
        super();
        _instanceId = instanceId;
        _volumes = volumes;
        _mutes = mutes;
        _bass = bass;
        _treble = treble;
        _masterLoudness = masterLoudness;
        _outputFixed = outputFixed;
        _headphoneConnected = headphoneConnected;
        _presetNameList = presetNameList;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public InstanceID getInstanceId() {
        return _instanceId;
    }

    public Volume getVolume(@Nonnull Channel channel) {
        return _volumes.get(channel);
    }

    public Mute getMute(@Nonnull Channel channel) {
        return _mutes.get(channel);
    }

    public Bass getBass() {
        return _bass;
    }

    public Treble getTreble() {
        return _treble;
    }

    public Loudness getMasterLoudness() {
        return _masterLoudness;
    }

    public OutputFixed getOutputFixed() {
        return _outputFixed;
    }


    public HeadphoneConnected getHeadphoneConnected() {
        return _headphoneConnected;
    }


    public List<String> getPresetNameList() {
        return _presetNameList;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("bass", _bass)
                .add("headphoneConnected", _headphoneConnected)
                .add("instanceId", _instanceId)
                .add("masterLoudness", _masterLoudness)
                .add("mutes", _mutes)
                .add("outputFixed", _outputFixed)
                .add("presetNameList", _presetNameList)
                .add("treble", _treble)
                .add("volumes", _volumes)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_bass, _headphoneConnected, _instanceId,
                _masterLoudness, _mutes, _outputFixed, _presetNameList,
                _treble, _volumes);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof LastRenderingControlChange) {
            LastRenderingControlChange obj = (LastRenderingControlChange)other;
            return Objects.equal(_bass, obj._bass) &&
                    Objects.equal(_headphoneConnected, obj._headphoneConnected) &&
                    Objects.equal(_instanceId, obj._instanceId) &&
                    Objects.equal(_masterLoudness, obj._masterLoudness) &&
                    Objects.equal(_mutes, obj._mutes) &&
                    Objects.equal(_outputFixed, obj._outputFixed) &&
                    Objects.equal(_presetNameList, obj._presetNameList) &&
                    Objects.equal(_treble, obj._treble) &&
                    Objects.equal(_volumes, obj._volumes);
        }
        return false;
    }

    public static LastRenderingControlChange getInstance(
            InstanceID instanceId, Map<Channel, Volume> volumes,
            Map<Channel, Mute> mutes, Bass bass, Treble treble,
            Loudness masterLoudness, OutputFixed outputFixed,
            HeadphoneConnected headphoneConnected, List<String> presetNameList
            ) {
        return new LastRenderingControlChange(
                instanceId, volumes, mutes,
                bass, treble, masterLoudness, outputFixed,
                headphoneConnected, presetNameList);
    }
}
