/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.audioin;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class LeftLineInLevel implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private LeftLineInLevel(Long value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public Long getValue() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof LeftLineInLevel) {
            LeftLineInLevel obj = (LeftLineInLevel)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static LeftLineInLevel getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new LeftLineInLevel(value);
    }
}
