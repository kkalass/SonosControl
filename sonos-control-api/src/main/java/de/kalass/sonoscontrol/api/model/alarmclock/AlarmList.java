package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmList {
    private final String _value;

    private AlarmList(final String value) {
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
        if (other instanceof AlarmList) {
            return Objects.equal(_value, ((AlarmList)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AlarmList valueOf(String value) {
        return value == null ? null : new AlarmList(value);
    }
}
