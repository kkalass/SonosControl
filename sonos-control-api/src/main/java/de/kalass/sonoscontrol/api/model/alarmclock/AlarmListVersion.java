/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.alarmclock;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmListVersion implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private AlarmListVersion(String value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public String asString() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof AlarmListVersion) {
            AlarmListVersion obj = (AlarmListVersion)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static AlarmListVersion getInstance(String value) {
        return value == null ? null : new AlarmListVersion(value);
    }
}
