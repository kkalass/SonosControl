package de.kalass.sonoscontrol.api.model.connectionmanager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ConnectionManager {
    private final String _value;

    private ConnectionManager(final String value) {
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
        if (other instanceof ConnectionManager) {
            return Objects.equal(_value, ((ConnectionManager)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static ConnectionManager valueOf(String value) {
        return value == null ? null : new ConnectionManager(value);
    }
}
