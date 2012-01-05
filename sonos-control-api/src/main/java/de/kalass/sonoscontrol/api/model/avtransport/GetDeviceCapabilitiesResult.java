/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetDeviceCapabilitiesResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final PossiblePlaybackStorageMedia _playMedia;
    private final PossibleRecordStorageMedia _recMedia;
    private final PossibleRecordQualityModes _recQualityModes;

    private GetDeviceCapabilitiesResult(
        final PossiblePlaybackStorageMedia playMedia,
        final PossibleRecordStorageMedia recMedia,
        final PossibleRecordQualityModes recQualityModes
    ) {
        _playMedia = playMedia;
        _recMedia = recMedia;
        _recQualityModes = recQualityModes;
    } 

    public static GetDeviceCapabilitiesResult getInstance(
        final PossiblePlaybackStorageMedia playMedia,
        final PossibleRecordStorageMedia recMedia,
        final PossibleRecordQualityModes recQualityModes
    ) {
        return new GetDeviceCapabilitiesResult(playMedia, recMedia, recQualityModes);
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

    public String toString() {
        return Objects.toStringHelper(this)
        .add("playMedia", _playMedia)
        .add("recMedia", _recMedia)
        .add("recQualityModes", _recQualityModes)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _playMedia,
            _recMedia,
            _recQualityModes
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetDeviceCapabilitiesResult) {
            GetDeviceCapabilitiesResult obj = (GetDeviceCapabilitiesResult)other;
            return 
                    Objects.equal(_playMedia, obj._playMedia) &&
                    Objects.equal(_recMedia, obj._recMedia) &&
                    Objects.equal(_recQualityModes, obj._recQualityModes) 
            ;
        }
        return false;
    }

}