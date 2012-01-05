/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.renderingcontrol;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class EQValue implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private EQValue(Long value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public Long asLong() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof EQValue) {
            EQValue obj = (EQValue)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static EQValue getInstance(Long value) {
        return value == null ? null : new EQValue(value);
    }
}
