package de.kalass.sonoscontrol.api.model.systemproperties;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class VariableStringValue {
    private final String _value;

    private VariableStringValue(final String value) {
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
        if (other instanceof VariableStringValue) {
            return Objects.equal(_value, ((VariableStringValue)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static VariableStringValue valueOf(String value) {
        return value == null ? null : new VariableStringValue(value);
    }
}
