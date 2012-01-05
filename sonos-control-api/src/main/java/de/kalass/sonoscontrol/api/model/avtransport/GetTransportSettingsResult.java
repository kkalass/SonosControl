/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetTransportSettingsResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final CurrentPlayMode _playMode;
    private final CurrentRecordQualityMode _recQualityMode;

    private GetTransportSettingsResult(
        final CurrentPlayMode playMode,
        final CurrentRecordQualityMode recQualityMode
    ) {
        _playMode = playMode;
        _recQualityMode = recQualityMode;
    } 

    public static GetTransportSettingsResult getInstance(
        final CurrentPlayMode playMode,
        final CurrentRecordQualityMode recQualityMode
    ) {
        return new GetTransportSettingsResult(playMode, recQualityMode);
    } 
    public CurrentPlayMode getPlayMode() {
        return _playMode;
    }
    public CurrentRecordQualityMode getRecQualityMode() {
        return _recQualityMode;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("playMode", _playMode)
        .add("recQualityMode", _recQualityMode)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _playMode,
            _recQualityMode
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetTransportSettingsResult) {
            GetTransportSettingsResult obj = (GetTransportSettingsResult)other;
            return 
                    Objects.equal(_playMode, obj._playMode) &&
                    Objects.equal(_recQualityMode, obj._recQualityMode) 
            ;
        }
        return false;
    }

}
