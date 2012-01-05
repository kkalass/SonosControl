package de.kalass.sonoscontrol.api.model.systemproperties;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class VariableStringValue implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private VariableStringValue(String value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public String asString() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof VariableStringValue) {
            VariableStringValue obj = (VariableStringValue)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static VariableStringValue getInstance(String value) {
        return value == null ? null : new VariableStringValue(value);
    }
}
