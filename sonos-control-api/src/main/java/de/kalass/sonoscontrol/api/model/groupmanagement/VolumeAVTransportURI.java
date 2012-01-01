package de.kalass.sonoscontrol.api.model.groupmanagement;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class VolumeAVTransportURI {
    private final String _value;

    private VolumeAVTransportURI(final String value) {
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
        if (other instanceof VolumeAVTransportURI) {
            return Objects.equal(_value, ((VolumeAVTransportURI)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static VolumeAVTransportURI valueOf(String value) {
        return value == null ? null : new VolumeAVTransportURI(value);
    }
}
