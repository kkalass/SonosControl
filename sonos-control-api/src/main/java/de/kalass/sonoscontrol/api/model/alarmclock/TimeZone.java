package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class TimeZone {
    private final String _value;

    private TimeZone(final String value) {
        _value = Preconditions.checkNotNull(value);
    }

    public String asString() {
        return _value;
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TimeZone) {
            return Objects.equal(_value, ((TimeZone)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static TimeZone valueOf(String value) {
        return value == null ? null : new TimeZone(value);
    }
}
