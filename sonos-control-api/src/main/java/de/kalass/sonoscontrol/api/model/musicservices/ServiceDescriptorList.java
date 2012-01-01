package de.kalass.sonoscontrol.api.model.musicservices;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ServiceDescriptorList {
    private final String _value;

    private ServiceDescriptorList(final String value) {
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
        if (other instanceof ServiceDescriptorList) {
            return Objects.equal(_value, ((ServiceDescriptorList)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static ServiceDescriptorList valueOf(String value) {
        return value == null ? null : new ServiceDescriptorList(value);
    }
}
