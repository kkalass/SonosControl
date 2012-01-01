package de.kalass.sonoscontrol.api.model.groupmanagement;

import com.google.common.base.Objects;

public class AddMemberResult {
    private final TransportSettings _currentTransportSettings;
    private final LocalGroupUUID _groupUUIDJoined;
    private final ResetVolumeAfter _resetVolumeAfter;
    private final VolumeAVTransportURI _volumeAVTransportURI;

    public AddMemberResult(
        TransportSettings currentTransportSettings,
        LocalGroupUUID groupUUIDJoined,
        ResetVolumeAfter resetVolumeAfter,
        VolumeAVTransportURI volumeAVTransportURI
    ) {
        _currentTransportSettings = currentTransportSettings;
        _groupUUIDJoined = groupUUIDJoined;
        _resetVolumeAfter = resetVolumeAfter;
        _volumeAVTransportURI = volumeAVTransportURI;
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

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _currentTransportSettings,
             _groupUUIDJoined,
             _resetVolumeAfter,
             _volumeAVTransportURI
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AddMemberResult) {
            AddMemberResult obj = (AddMemberResult)other;
            return 
             Objects.equal(_currentTransportSettings, obj._currentTransportSettings) &&
             Objects.equal(_groupUUIDJoined, obj._groupUUIDJoined) &&
             Objects.equal(_resetVolumeAfter, obj._resetVolumeAfter) &&
             Objects.equal(_volumeAVTransportURI, obj._volumeAVTransportURI);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("currentTransportSettings",_currentTransportSettings)
             .add("groupUUIDJoined",_groupUUIDJoined)
             .add("resetVolumeAfter",_resetVolumeAfter)
             .add("volumeAVTransportURI",_volumeAVTransportURI)
             .toString();
    }

}
