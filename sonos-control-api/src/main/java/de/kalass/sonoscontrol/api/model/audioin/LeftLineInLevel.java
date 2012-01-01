package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class LeftLineInLevel {
    private final Long _value;

    private LeftLineInLevel(final Long value) {
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
        if (other instanceof LeftLineInLevel) {
            return Objects.equal(_value, ((LeftLineInLevel)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static LeftLineInLevel valueOf(Long value) {
        return value == null ? null : new LeftLineInLevel(value);
    }
}
