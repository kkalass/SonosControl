/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class TimeZoneAndRule implements Serializable {
    private static final long serialVersionUID = 1L;

    private final TimeZoneIndex _index;
    private final TimeZoneAutoAdjustDst _autoAdjustDst;
    private final TimeZone _currentTimeZone;

    public TimeZoneAndRule(
        final TimeZoneIndex index,
        final TimeZoneAutoAdjustDst autoAdjustDst,
        final TimeZone currentTimeZone
    ) {
        _index = index;
        _autoAdjustDst = autoAdjustDst;
        _currentTimeZone = currentTimeZone;
    } 

    public TimeZoneIndex getIndex() {
        return _index;
    }
    public TimeZoneAutoAdjustDst getAutoAdjustDst() {
        return _autoAdjustDst;
    }
    public TimeZone getCurrentTimeZone() {
        return _currentTimeZone;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("index", _index)
        .add("autoAdjustDst", _autoAdjustDst)
        .add("currentTimeZone", _currentTimeZone)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _index,
            _autoAdjustDst,
            _currentTimeZone
        );
    }

    public boolean equals(Object other) {
        if (other instanceof TimeZoneAndRule) {
            TimeZoneAndRule obj = (TimeZoneAndRule)other;
            return 
                    Objects.equal(_index, obj._index) &&
                    Objects.equal(_autoAdjustDst, obj._autoAdjustDst) &&
                    Objects.equal(_currentTimeZone, obj._currentTimeZone) 
            ;
        }
        return false;
    }

}
