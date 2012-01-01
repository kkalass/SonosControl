package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;

public class TransportSettings {
    private final CurrentPlayMode _playMode;
    private final CurrentRecordQualityMode _recQualityMode;

    public TransportSettings(
        CurrentPlayMode playMode,
        CurrentRecordQualityMode recQualityMode
    ) {
        _playMode = playMode;
        _recQualityMode = recQualityMode;
    }


    public CurrentPlayMode getPlayMode() {
        return _playMode;
    }

    public CurrentRecordQualityMode getRecQualityMode() {
        return _recQualityMode;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _playMode,
             _recQualityMode
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TransportSettings) {
            TransportSettings obj = (TransportSettings)other;
            return 
             Objects.equal(_playMode, obj._playMode) &&
             Objects.equal(_recQualityMode, obj._recQualityMode);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("playMode",_playMode)
             .add("recQualityMode",_recQualityMode)
             .toString();
    }

}
