package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmProgramMetaData {
    private final String _value;

    private AlarmProgramMetaData(final String value) {
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
        if (other instanceof AlarmProgramMetaData) {
            return Objects.equal(_value, ((AlarmProgramMetaData)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AlarmProgramMetaData valueOf(String value) {
        return value == null ? null : new AlarmProgramMetaData(value);
    }
}
