package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;

public class AddURIToQueueResult {
    private final TrackNumber _firstTrackNumberEnqueued;
    private final NumTracks _numTracksAdded;
    private final NumTracks _newQueueLength;

    public AddURIToQueueResult(
        TrackNumber firstTrackNumberEnqueued,
        NumTracks numTracksAdded,
        NumTracks newQueueLength
    ) {
        _firstTrackNumberEnqueued = firstTrackNumberEnqueued;
        _numTracksAdded = numTracksAdded;
        _newQueueLength = newQueueLength;
    }


    public TrackNumber getFirstTrackNumberEnqueued() {
        return _firstTrackNumberEnqueued;
    }

    public NumTracks getNumTracksAdded() {
        return _numTracksAdded;
    }

    public NumTracks getNewQueueLength() {
        return _newQueueLength;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _firstTrackNumberEnqueued,
             _numTracksAdded,
             _newQueueLength
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AddURIToQueueResult) {
            AddURIToQueueResult obj = (AddURIToQueueResult)other;
            return 
             Objects.equal(_firstTrackNumberEnqueued, obj._firstTrackNumberEnqueued) &&
             Objects.equal(_numTracksAdded, obj._numTracksAdded) &&
             Objects.equal(_newQueueLength, obj._newQueueLength);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("firstTrackNumberEnqueued",_firstTrackNumberEnqueued)
             .add("numTracksAdded",_numTracksAdded)
             .add("newQueueLength",_newQueueLength)
             .toString();
    }

}
