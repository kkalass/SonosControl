package de.kalass.sonoscontrol.api.model.connectionmanager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class RcsID {
    private final Long _value;

    private RcsID(final Long value) {
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
        if (other instanceof RcsID) {
            return Objects.equal(_value, ((RcsID)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static RcsID valueOf(Long value) {
        return value == null ? null : new RcsID(value);
    }
}
