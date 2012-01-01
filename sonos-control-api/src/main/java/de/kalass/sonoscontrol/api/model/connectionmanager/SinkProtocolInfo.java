package de.kalass.sonoscontrol.api.model.connectionmanager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class SinkProtocolInfo {
    private final String _value;

    private SinkProtocolInfo(final String value) {
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
        if (other instanceof SinkProtocolInfo) {
            return Objects.equal(_value, ((SinkProtocolInfo)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static SinkProtocolInfo valueOf(String value) {
        return value == null ? null : new SinkProtocolInfo(value);
    }
}
