/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.groupmanagement;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class AddMemberResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final TransportSettings _currentTransportSettings;
    private final LocalGroupUUID _groupUUIDJoined;
    private final ResetVolumeAfter _resetVolumeAfter;
    private final VolumeAVTransportURI _volumeAVTransportURI;

    private AddMemberResult(
        final TransportSettings currentTransportSettings,
        final LocalGroupUUID groupUUIDJoined,
        final ResetVolumeAfter resetVolumeAfter,
        final VolumeAVTransportURI volumeAVTransportURI
    ) {
        _currentTransportSettings = currentTransportSettings;
        _groupUUIDJoined = groupUUIDJoined;
        _resetVolumeAfter = resetVolumeAfter;
        _volumeAVTransportURI = volumeAVTransportURI;
    } 

    public static AddMemberResult getInstance(
        final TransportSettings currentTransportSettings,
        final LocalGroupUUID groupUUIDJoined,
        final ResetVolumeAfter resetVolumeAfter,
        final VolumeAVTransportURI volumeAVTransportURI
    ) {
        return new AddMemberResult(currentTransportSettings, groupUUIDJoined, resetVolumeAfter, volumeAVTransportURI);
    } 
    public TransportSettings getCurrentTransportSettings() {
        return _currentTransportSettings;
    }
    public LocalGroupUUID getGroupUUIDJoined() {
        return _groupUUIDJoined;
    }
    public ResetVolumeAfter getResetVolumeAfter() {
        return _resetVolumeAfter;
    }
    public VolumeAVTransportURI getVolumeAVTransportURI() {
        return _volumeAVTransportURI;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("currentTransportSettings", _currentTransportSettings)
        .add("groupUUIDJoined", _groupUUIDJoined)
        .add("resetVolumeAfter", _resetVolumeAfter)
        .add("volumeAVTransportURI", _volumeAVTransportURI)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _currentTransportSettings,
            _groupUUIDJoined,
            _resetVolumeAfter,
            _volumeAVTransportURI
        );
    }

    public boolean equals(Object other) {
        if (other instanceof AddMemberResult) {
            AddMemberResult obj = (AddMemberResult)other;
            return 
                    Objects.equal(_currentTransportSettings, obj._currentTransportSettings) &&
                    Objects.equal(_groupUUIDJoined, obj._groupUUIDJoined) &&
                    Objects.equal(_resetVolumeAfter, obj._resetVolumeAfter) &&
                    Objects.equal(_volumeAVTransportURI, obj._volumeAVTransportURI) 
            ;
        }
        return false;
    }

}
