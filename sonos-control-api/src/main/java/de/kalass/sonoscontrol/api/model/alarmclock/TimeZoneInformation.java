/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.alarmclock;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class TimeZoneInformation implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private TimeZoneInformation(String value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public String getValue() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof TimeZoneInformation) {
            TimeZoneInformation obj = (TimeZoneInformation)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static TimeZoneInformation getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new TimeZoneInformation(value);
    }
}
