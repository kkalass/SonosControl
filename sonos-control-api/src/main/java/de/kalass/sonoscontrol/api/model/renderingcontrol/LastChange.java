package de.kalass.sonoscontrol.api.model.renderingcontrol;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnull;

import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.model.InstanceID;

public final class LastChange implements Serializable {
    private static final long serialVersionUID = 1L;

    private final InstanceID _instanceId;
    private final Map<Channel, Volume> _volumes;
    private final Map<MuteChannel, Mute> _mutes;
    private final Bass _bass;
    private final Treble _treble;
    private final Loudness _masterLoudness;
    private final OutputFixed _outputFixed;
    private final HeadphoneConnected _headphoneConnected;
    private final PresetNameList _presetNameList;


    public LastChange(InstanceID instanceId, Map<Channel, Volume> volumes,
            Map<MuteChannel, Mute> mutes, Bass bass, Treble treble,
            Loudness masterLoudness, OutputFixed outputFixed,
            HeadphoneConnected headphoneConnected, PresetNameList presetNameList) {
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


    public PresetNameList getPresetNameList() {
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
        if (other instanceof LastChange) {
            LastChange obj = (LastChange)other;
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

    public static LastChange getInstance(
            InstanceID instanceId, Map<Channel, Volume> volumes,
            Map<MuteChannel, Mute> mutes, Bass bass, Treble treble,
            Loudness masterLoudness, OutputFixed outputFixed,
            HeadphoneConnected headphoneConnected, PresetNameList presetNameList
            ) {
        return new LastChange(
                instanceId, volumes, mutes,
                bass, treble, masterLoudness, outputFixed,
                headphoneConnected, presetNameList);
    }
}