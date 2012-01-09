package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;

import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.model.InstanceID;

public final class LastChange implements Serializable {
    private static final long serialVersionUID = 1L;
    private final InstanceID _instanceId;
    private final TransportState _transportState;
    private final CurrentPlayMode _currentPlayMode;
    private final CurrentCrossfadeMode _currentCrossfadeMode;
    private final NumberOfTracks _numberOfTracks;
    private final CurrentTrack _currentTrack;
    private final CurrentSection _currentSection;
    private final CurrentTrackURI _currentTrackUri;
    private final CurrentTrackDuration _currentTrackDuration;
    private final CurrentTrackMetaData _currentTrackMetaData;

    public LastChange(
            InstanceID instanceId, TransportState transportState,
            CurrentPlayMode currentPlayMode,
            CurrentCrossfadeMode currentCrossfadeMode,
            NumberOfTracks numberOfTracks, CurrentTrack currentTrack,
            CurrentSection currentSection, CurrentTrackURI currentTrackUri,
            CurrentTrackDuration currentTrackDuration,
            CurrentTrackMetaData currentTrackMetaData) {
        super();
        _instanceId = instanceId;
        _transportState = transportState;
        _currentPlayMode = currentPlayMode;
        _currentCrossfadeMode = currentCrossfadeMode;
        _numberOfTracks = numberOfTracks;
        _currentTrack = currentTrack;
        _currentSection = currentSection;
        _currentTrackUri = currentTrackUri;
        _currentTrackDuration = currentTrackDuration;
        _currentTrackMetaData = currentTrackMetaData;
    }


    public InstanceID getInstanceId() {
        return _instanceId;
    }

    public TransportState getTransportState() {
        return _transportState;
    }

    public CurrentPlayMode getCurrentPlayMode() {
        return _currentPlayMode;
    }

    public CurrentCrossfadeMode getCurrentCrossfadeMode() {
        return _currentCrossfadeMode;
    }

    public NumberOfTracks getNumberOfTracks() {
        return _numberOfTracks;
    }

    public CurrentTrack getCurrentTrack() {
        return _currentTrack;
    }

    public CurrentSection getCurrentSection() {
        return _currentSection;
    }

    public CurrentTrackURI getCurrentTrackUri() {
        return _currentTrackUri;
    }

    public CurrentTrackDuration getCurrentTrackDuration() {
        return _currentTrackDuration;
    }

    public CurrentTrackMetaData getCurrentTrackMetaData() {
        return _currentTrackMetaData;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("currentCrossfadeMode", _currentCrossfadeMode)
                .add("currentPlayMode", _currentPlayMode)
                .add("currentSection", _currentSection)
                .add("currentTrack", _currentTrack)
                .add("currentTrackDuration", _currentTrackDuration)
                .add("currentTrackMetaData", _currentTrackMetaData)
                .add("currentTrackUri", _currentTrackUri)
                .add("instanceId", _instanceId)
                .add("numberOfTracks", _numberOfTracks)
                .add("transportState", _transportState)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                _currentCrossfadeMode, _currentPlayMode, _currentSection,
                _currentTrack, _currentTrackDuration, _currentTrackMetaData,
                _currentTrackUri, _instanceId, _numberOfTracks, _transportState);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof LastChange) {
            LastChange obj = (LastChange)other;
            return Objects.equal(_currentCrossfadeMode, obj._currentCrossfadeMode) &&
                    Objects.equal(_currentPlayMode, obj._currentPlayMode) &&
                    Objects.equal(_currentSection, obj._currentSection) &&
                    Objects.equal(_currentTrack, obj._currentTrack) &&
                    Objects.equal(_currentTrackDuration, obj._currentTrackDuration) &&
                    Objects.equal(_currentTrackMetaData, obj._currentTrackMetaData) &&
                    Objects.equal(_currentTrackUri, obj._currentTrackUri) &&
                    Objects.equal(_instanceId, obj._instanceId) &&
                    Objects.equal(_numberOfTracks, obj._numberOfTracks) &&
                    Objects.equal(_transportState, obj._transportState) ;
        }
        return false;
    }

    public static LastChange getInstance(
            InstanceID instanceId, TransportState transportState,
            CurrentPlayMode currentPlayMode,
            CurrentCrossfadeMode currentCrossfadeMode,
            NumberOfTracks numberOfTracks, CurrentTrack currentTrack,
            CurrentSection currentSection, CurrentTrackURI currentTrackUri,
            CurrentTrackDuration currentTrackDuration,
            CurrentTrackMetaData currentTrackMetaData
            ) {
        return new LastChange(
                instanceId, transportState, currentPlayMode,
                currentCrossfadeMode, numberOfTracks, currentTrack,
                currentSection, currentTrackUri, currentTrackDuration, currentTrackMetaData);
    }
}
