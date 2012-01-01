package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class SleepTimerGeneration {
    private final Long _value;

    private SleepTimerGeneration(final Long value) {
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
        if (other instanceof SleepTimerGeneration) {
            return Objects.equal(_value, ((SleepTimerGeneration)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static SleepTimerGeneration valueOf(Long value) {
        return value == null ? null : new SleepTimerGeneration(value);
    }
}
