package de.kalass.sonoscontrol.api.model.deviceproperties;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ZoneName {
    private final String _value;

    private ZoneName(final String value) {
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
        if (other instanceof ZoneName) {
            return Objects.equal(_value, ((ZoneName)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static ZoneName valueOf(String value) {
        return value == null ? null : new ZoneName(value);
    }
}
