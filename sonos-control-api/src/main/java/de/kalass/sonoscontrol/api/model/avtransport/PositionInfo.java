package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;

public class PositionInfo {
    private final CurrentTrack _track;
    private final CurrentTrackDuration _trackDuration;
    private final CurrentTrackMetaData _trackMetaData;
    private final CurrentTrackURI _trackURI;
    private final RelativeTimePosition _relTime;
    private final AbsoluteTimePosition _absTime;
    private final RelativeCounterPosition _relCount;
    private final AbsoluteCounterPosition _absCount;

    public PositionInfo(
        CurrentTrack track,
        CurrentTrackDuration trackDuration,
        CurrentTrackMetaData trackMetaData,
        CurrentTrackURI trackURI,
        RelativeTimePosition relTime,
        AbsoluteTimePosition absTime,
        RelativeCounterPosition relCount,
        AbsoluteCounterPosition absCount
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

    @Override
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

    @Override
    public boolean equals(Object other) {
        if (other instanceof PositionInfo) {
            PositionInfo obj = (PositionInfo)other;
            return 
             Objects.equal(_track, obj._track) &&
             Objects.equal(_trackDuration, obj._trackDuration) &&
             Objects.equal(_trackMetaData, obj._trackMetaData) &&
             Objects.equal(_trackURI, obj._trackURI) &&
             Objects.equal(_relTime, obj._relTime) &&
             Objects.equal(_absTime, obj._absTime) &&
             Objects.equal(_relCount, obj._relCount) &&
             Objects.equal(_absCount, obj._absCount);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("track",_track)
             .add("trackDuration",_trackDuration)
             .add("trackMetaData",_trackMetaData)
             .add("trackURI",_trackURI)
             .add("relTime",_relTime)
             .add("absTime",_absTime)
             .add("relCount",_relCount)
             .add("absCount",_absCount)
             .toString();
    }

}