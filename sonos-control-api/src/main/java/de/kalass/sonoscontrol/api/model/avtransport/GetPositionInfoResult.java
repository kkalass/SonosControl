// AUTOGENERATED: cf79543582cdbb00eef6a23744b18d22
// AUTOGENERATED: 09.01.2012 12:49:21
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetPositionInfoResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final CurrentTrack _track;
    private final CurrentTrackDuration _trackDuration;
    private final CurrentTrackMetaData _trackMetaData;
    private final CurrentTrackURI _trackURI;
    private final RelativeTimePosition _relTime;
    private final AbsoluteTimePosition _absTime;
    private final RelativeCounterPosition _relCount;
    private final AbsoluteCounterPosition _absCount;

    private GetPositionInfoResult(
        final CurrentTrack track,
        final CurrentTrackDuration trackDuration,
        final CurrentTrackMetaData trackMetaData,
        final CurrentTrackURI trackURI,
        final RelativeTimePosition relTime,
        final AbsoluteTimePosition absTime,
        final RelativeCounterPosition relCount,
        final AbsoluteCounterPosition absCount
    ) {
        _track = track;
        _trackDuration = trackDuration;
        _trackMetaData = trackMetaData;
        _trackURI = trackURI;
        _relTime = relTime;
        _absTime = absTime;
        _relCount = relCount;
        _absCount = absCount;
    } 

    public static GetPositionInfoResult getInstance(
        final CurrentTrack track,
        final CurrentTrackDuration trackDuration,
        final CurrentTrackMetaData trackMetaData,
        final CurrentTrackURI trackURI,
        final RelativeTimePosition relTime,
        final AbsoluteTimePosition absTime,
        final RelativeCounterPosition relCount,
        final AbsoluteCounterPosition absCount
    ) {
        return new GetPositionInfoResult(track, trackDuration, trackMetaData, trackURI, relTime, absTime, relCount, absCount);
    } 
    public CurrentTrack getTrack() {
        return _track;
    }
    public CurrentTrackDuration getTrackDuration() {
        return _trackDuration;
    }
    public CurrentTrackMetaData getTrackMetaData() {
        return _trackMetaData;
    }
    public CurrentTrackURI getTrackURI() {
        return _trackURI;
    }
    public RelativeTimePosition getRelTime() {
        return _relTime;
    }
    public AbsoluteTimePosition getAbsTime() {
        return _absTime;
    }
    public RelativeCounterPosition getRelCount() {
        return _relCount;
    }
    public AbsoluteCounterPosition getAbsCount() {
        return _absCount;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("track", _track)
        .add("trackDuration", _trackDuration)
        .add("trackMetaData", _trackMetaData)
        .add("trackURI", _trackURI)
        .add("relTime", _relTime)
        .add("absTime", _absTime)
        .add("relCount", _relCount)
        .add("absCount", _absCount)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _track,
            _trackDuration,
            _trackMetaData,
            _trackURI,
            _relTime,
            _absTime,
            _relCount,
            _absCount
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetPositionInfoResult) {
            GetPositionInfoResult obj = (GetPositionInfoResult)other;
            return 
                    Objects.equal(_track, obj._track) &&
                    Objects.equal(_trackDuration, obj._trackDuration) &&
                    Objects.equal(_trackMetaData, obj._trackMetaData) &&
                    Objects.equal(_trackURI, obj._trackURI) &&
                    Objects.equal(_relTime, obj._relTime) &&
                    Objects.equal(_absTime, obj._absTime) &&
                    Objects.equal(_relCount, obj._relCount) &&
                    Objects.equal(_absCount, obj._absCount) 
            ;
        }
        return false;
    }

}
