package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class CurrentAVTransportURI {
    private final String _value;

    private CurrentAVTransportURI(final String value) {
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
        if (other instanceof CurrentAVTransportURI) {
            return Objects.equal(_value, ((CurrentAVTransportURI)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static CurrentAVTransportURI valueOf(String value) {
        return value == null ? null : new CurrentAVTransportURI(value);
    }
}
