package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class TimeStamp {
    private final String _value;

    private TimeStamp(final String value) {
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
        if (other instanceof TimeStamp) {
            return Objects.equal(_value, ((TimeStamp)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static TimeStamp valueOf(String value) {
        return value == null ? null : new TimeStamp(value);
    }
}
