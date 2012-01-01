package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ObjectID {
    private final String _value;

    private ObjectID(final String value) {
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
        if (other instanceof ObjectID) {
            return Objects.equal(_value, ((ObjectID)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static ObjectID valueOf(String value) {
        return value == null ? null : new ObjectID(value);
    }
}
