package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class NextAVTransportURI {
    private final String _value;

    private NextAVTransportURI(final String value) {
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
        if (other instanceof NextAVTransportURI) {
            return Objects.equal(_value, ((NextAVTransportURI)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static NextAVTransportURI valueOf(String value) {
        return value == null ? null : new NextAVTransportURI(value);
    }
}
