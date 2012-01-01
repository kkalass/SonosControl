package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AbsoluteCounterPosition {
    private final Long _value;

    private AbsoluteCounterPosition(final Long value) {
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
        if (other instanceof AbsoluteCounterPosition) {
            return Objects.equal(_value, ((AbsoluteCounterPosition)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AbsoluteCounterPosition valueOf(Long value) {
        return value == null ? null : new AbsoluteCounterPosition(value);
    }
}
