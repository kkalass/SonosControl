package de.kalass.sonoscontrol.api.model.musicservices;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ServiceTypeList {
    private final String _value;

    private ServiceTypeList(final String value) {
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
        if (other instanceof ServiceTypeList) {
            return Objects.equal(_value, ((ServiceTypeList)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static ServiceTypeList valueOf(String value) {
        return value == null ? null : new ServiceTypeList(value);
    }
}
