package de.kalass.sonoscontrol.api.model.connectionmanager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ProtocolInfo {
    private final String _value;

    private ProtocolInfo(final String value) {
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
        if (other instanceof ProtocolInfo) {
            return Objects.equal(_value, ((ProtocolInfo)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static ProtocolInfo valueOf(String value) {
        return value == null ? null : new ProtocolInfo(value);
    }
}
