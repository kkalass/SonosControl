/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetTimeZoneResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final TimeZoneIndex _index;
    private final TimeZoneAutoAdjustDst _autoAdjustDst;

    private GetTimeZoneResult(
        final TimeZoneIndex index,
        final TimeZoneAutoAdjustDst autoAdjustDst
    ) {
        _index = index;
        _autoAdjustDst = autoAdjustDst;
    } 

    public static GetTimeZoneResult getInstance(
        final TimeZoneIndex index,
        final TimeZoneAutoAdjustDst autoAdjustDst
    ) {
        return new GetTimeZoneResult(index, autoAdjustDst);
    } 
    public TimeZoneIndex getIndex() {
        return _index;
    }
    public TimeZoneAutoAdjustDst getAutoAdjustDst() {
        return _autoAdjustDst;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("index", _index)
        .add("autoAdjustDst", _autoAdjustDst)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _index,
            _autoAdjustDst
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetTimeZoneResult) {
            GetTimeZoneResult obj = (GetTimeZoneResult)other;
            return 
                    Objects.equal(_index, obj._index) &&
                    Objects.equal(_autoAdjustDst, obj._autoAdjustDst) 
            ;
        }
        return false;
    }

}
