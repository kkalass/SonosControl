// AUTOGENERATED: bee7dbca60db568c5678ccef24d04038
// AUTOGENERATED: 09.01.2012 12:49:21
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class AddURIToQueueResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final TrackNumber _firstTrackNumberEnqueued;
    private final NumTracks _numTracksAdded;
    private final NumTracks _newQueueLength;

    private AddURIToQueueResult(
        final TrackNumber firstTrackNumberEnqueued,
        final NumTracks numTracksAdded,
        final NumTracks newQueueLength
    ) {
        _firstTrackNumberEnqueued = firstTrackNumberEnqueued;
        _numTracksAdded = numTracksAdded;
        _newQueueLength = newQueueLength;
    } 

    public static AddURIToQueueResult getInstance(
        final TrackNumber firstTrackNumberEnqueued,
        final NumTracks numTracksAdded,
        final NumTracks newQueueLength
    ) {
        return new AddURIToQueueResult(firstTrackNumberEnqueued, numTracksAdded, newQueueLength);
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
