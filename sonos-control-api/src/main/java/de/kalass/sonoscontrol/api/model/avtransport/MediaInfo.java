package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class MediaInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	private final NumberOfTracks _nrTracks;
	private final CurrentMediaDuration _mediaDuration;
	private final AVTransportURI _currentURI;
	private final AVTransportURIMetaData _currentURIMetaData;
	private final NextAVTransportURI _nextURI;
	private final NextAVTransportURIMetaData _nextURIMetaData;
	private final PlaybackStorageMedium _playMedium;
	private final RecordStorageMedium _recordMedium;
	private final RecordMediumWriteStatus _writeStatus;

    public MediaInfo(
		final NumberOfTracks nrTracks,
		final CurrentMediaDuration mediaDuration,
		final AVTransportURI currentURI,
		final AVTransportURIMetaData currentURIMetaData,
		final NextAVTransportURI nextURI,
		final NextAVTransportURIMetaData nextURIMetaData,
		final PlaybackStorageMedium playMedium,
		final RecordStorageMedium recordMedium,
		final RecordMediumWriteStatus writeStatus
    ) {
		_nrTracks = nrTracks;
		_mediaDuration = mediaDuration;
		_currentURI = currentURI;
		_currentURIMetaData = currentURIMetaData;
		_nextURI = nextURI;
		_nextURIMetaData = nextURIMetaData;
		_playMedium = playMedium;
		_recordMedium = recordMedium;
		_writeStatus = writeStatus;
    } 

	public NumberOfTracks getNrTracks() {
	    return _nrTracks;
	}
	public CurrentMediaDuration getMediaDuration() {
	    return _mediaDuration;
	}
	public AVTransportURI getCurrentURI() {
	    return _currentURI;
	}
	public AVTransportURIMetaData getCurrentURIMetaData() {
	    return _currentURIMetaData;
	}
	public NextAVTransportURI getNextURI() {
	    return _nextURI;
	}
	public NextAVTransportURIMetaData getNextURIMetaData() {
	    return _nextURIMetaData;
	}
	public PlaybackStorageMedium getPlayMedium() {
	    return _playMedium;
	}
	public RecordStorageMedium getRecordMedium() {
	    return _recordMedium;
	}
	public RecordMediumWriteStatus getWriteStatus() {
	    return _writeStatus;
	}

    public String toString() {
        return Objects.toStringHelper(this)
		.add("nrTracks", _nrTracks)
		.add("mediaDuration", _mediaDuration)
		.add("currentURI", _currentURI)
		.add("currentURIMetaData", _currentURIMetaData)
		.add("nextURI", _nextURI)
		.add("nextURIMetaData", _nextURIMetaData)
		.add("playMedium", _playMedium)
		.add("recordMedium", _recordMedium)
		.add("writeStatus", _writeStatus)
        .toString();
    }
    
    public int hashCode() {
        return Objects.hashCode(
			_nrTracks,
			_mediaDuration,
			_currentURI,
			_currentURIMetaData,
			_nextURI,
			_nextURIMetaData,
			_playMedium,
			_recordMedium,
			_writeStatus
        );
    }

    public boolean equals(Object other) {
        if (other instanceof MediaInfo) {
            MediaInfo obj = (MediaInfo)other;
            return 
					Objects.equal(_nrTracks, obj._nrTracks) &&
					Objects.equal(_mediaDuration, obj._mediaDuration) &&
					Objects.equal(_currentURI, obj._currentURI) &&
					Objects.equal(_currentURIMetaData, obj._currentURIMetaData) &&
					Objects.equal(_nextURI, obj._nextURI) &&
					Objects.equal(_nextURIMetaData, obj._nextURIMetaData) &&
					Objects.equal(_playMedium, obj._playMedium) &&
					Objects.equal(_recordMedium, obj._recordMedium) &&
					Objects.equal(_writeStatus, obj._writeStatus) 
            ;
        }
        return false;
    }

}
