package de.kalass.sonoscontrol.api.model.systemproperties;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class VariableName {
    private final String _value;

    private VariableName(final String value) {
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
        if (other instanceof VariableName) {
            return Objects.equal(_value, ((VariableName)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static VariableName valueOf(String value) {
        return value == null ? null : new VariableName(value);
    }
}
