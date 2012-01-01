package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmRunSequence {
    private final String _value;

    private AlarmRunSequence(final String value) {
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
        if (other instanceof AlarmRunSequence) {
            return Objects.equal(_value, ((AlarmRunSequence)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AlarmRunSequence valueOf(String value) {
        return value == null ? null : new AlarmRunSequence(value);
    }
}