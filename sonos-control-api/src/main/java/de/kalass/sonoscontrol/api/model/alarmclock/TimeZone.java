package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;

public class TimeZone {
    private final TimeZoneIndex _index;
    private final TimeZoneAutoAdjustDst _autoAdjustDst;

    public TimeZone(
        TimeZoneIndex index,
        TimeZoneAutoAdjustDst autoAdjustDst
    ) {
        _index = index;
        _autoAdjustDst = autoAdjustDst;
    }


    public TimeZoneIndex getIndex() {
        return _index;
    }

    public TimeZoneAutoAdjustDst getAutoAdjustDst() {
        return _autoAdjustDst;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _index,
             _autoAdjustDst
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TimeZone) {
            TimeZone obj = (TimeZone)other;
            return 
             Objects.equal(_index, obj._index) &&
             Objects.equal(_autoAdjustDst, obj._autoAdjustDst);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("index",_index)
             .add("autoAdjustDst",_autoAdjustDst)
             .toString();
    }

}
