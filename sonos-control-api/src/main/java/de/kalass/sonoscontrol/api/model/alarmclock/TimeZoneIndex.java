package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class TimeZoneIndex {
    private final Long _value;

    private TimeZoneIndex(final Long value) {
        _value = Preconditions.checkNotNull(value);
    }

    public Long asLong() {
        return _value;
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TimeZoneIndex) {
            return Objects.equal(_value, ((TimeZoneIndex)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static TimeZoneIndex valueOf(Long value) {
        return value == null ? null : new TimeZoneIndex(value);
    }
}
