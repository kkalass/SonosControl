package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;

public class DeviceCapabilities {
    private final PossiblePlaybackStorageMedia _playMedia;
    private final PossibleRecordStorageMedia _recMedia;
    private final PossibleRecordQualityModes _recQualityModes;

    public DeviceCapabilities(
        PossiblePlaybackStorageMedia playMedia,
        PossibleRecordStorageMedia recMedia,
        PossibleRecordQualityModes recQualityModes
    ) {
        _playMedia = playMedia;
        _recMedia = recMedia;
        _recQualityModes = recQualityModes;
    }


    public PossiblePlaybackStorageMedia getPlayMedia() {
        return _playMedia;
    }

    public PossibleRecordStorageMedia getRecMedia() {
        return _recMedia;
    }

    public PossibleRecordQualityModes getRecQualityModes() {
        return _recQualityModes;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _playMedia,
             _recMedia,
             _recQualityModes
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof DeviceCapabilities) {
            DeviceCapabilities obj = (DeviceCapabilities)other;
            return 
             Objects.equal(_playMedia, obj._playMedia) &&
             Objects.equal(_recMedia, obj._recMedia) &&
             Objects.equal(_recQualityModes, obj._recQualityModes);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("playMedia",_playMedia)
             .add("recMedia",_recMedia)
             .add("recQualityModes",_recQualityModes)
             .toString();
    }

}
