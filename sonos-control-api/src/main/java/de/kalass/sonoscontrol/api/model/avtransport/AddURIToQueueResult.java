/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class AddURIToQueueResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final TrackNumber _firstTrackNumberEnqueued;
    private final NumTracks _numTracksAdded;
    private final NumTracks _newQueueLength;

    public AddURIToQueueResult(
        final TrackNumber firstTrackNumberEnqueued,
        final NumTracks numTracksAdded,
        final NumTracks newQueueLength
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

    public String toString() {
        return Objects.toStringHelper(this)
        .add("firstTrackNumberEnqueued", _firstTrackNumberEnqueued)
        .add("numTracksAdded", _numTracksAdded)
        .add("newQueueLength", _newQueueLength)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _firstTrackNumberEnqueued,
            _numTracksAdded,
            _newQueueLength
        );
    }

    public boolean equals(Object other) {
        if (other instanceof AddURIToQueueResult) {
            AddURIToQueueResult obj = (AddURIToQueueResult)other;
            return 
                    Objects.equal(_firstTrackNumberEnqueued, obj._firstTrackNumberEnqueued) &&
                    Objects.equal(_numTracksAdded, obj._numTracksAdded) &&
                    Objects.equal(_newQueueLength, obj._newQueueLength) 
            ;
        }
        return false;
    }

}
