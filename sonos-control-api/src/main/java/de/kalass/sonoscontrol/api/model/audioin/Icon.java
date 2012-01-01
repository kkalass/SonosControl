package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class Icon {
    private final String _value;

    private Icon(final String value) {
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
        if (other instanceof Icon) {
            return Objects.equal(_value, ((Icon)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static Icon valueOf(String value) {
        return value == null ? null : new Icon(value);
    }
}
