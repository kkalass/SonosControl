/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class Format implements Serializable {
    private static final long serialVersionUID = 1L;

    private final TimeFormat _currentTimeFormat;
    private final DateFormat _currentDateFormat;

    public Format(
        final TimeFormat currentTimeFormat,
        final DateFormat currentDateFormat
    ) {
        _currentTimeFormat = currentTimeFormat;
        _currentDateFormat = currentDateFormat;
    } 

    public TimeFormat getCurrentTimeFormat() {
        return _currentTimeFormat;
    }
    public DateFormat getCurrentDateFormat() {
        return _currentDateFormat;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("currentTimeFormat", _currentTimeFormat)
        .add("currentDateFormat", _currentDateFormat)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _currentTimeFormat,
            _currentDateFormat
        );
    }

    public boolean equals(Object other) {
        if (other instanceof Format) {
            Format obj = (Format)other;
            return 
                    Objects.equal(_currentTimeFormat, obj._currentTimeFormat) &&
                    Objects.equal(_currentDateFormat, obj._currentDateFormat) 
            ;
        }
        return false;
    }

}
