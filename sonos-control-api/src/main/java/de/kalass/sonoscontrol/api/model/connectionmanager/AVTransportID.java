package de.kalass.sonoscontrol.api.model.connectionmanager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AVTransportID {
    private final Long _value;

    private AVTransportID(final Long value) {
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
        if (other instanceof AVTransportID) {
            return Objects.equal(_value, ((AVTransportID)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AVTransportID valueOf(Long value) {
        return value == null ? null : new AVTransportID(value);
    }
}