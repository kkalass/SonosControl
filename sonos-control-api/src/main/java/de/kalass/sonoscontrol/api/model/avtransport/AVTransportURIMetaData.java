package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AVTransportURIMetaData {
    private final String _value;

    private AVTransportURIMetaData(final String value) {
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
        if (other instanceof AVTransportURIMetaData) {
            return Objects.equal(_value, ((AVTransportURIMetaData)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AVTransportURIMetaData valueOf(String value) {
        return value == null ? null : new AVTransportURIMetaData(value);
    }
}
