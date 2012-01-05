/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmRunSequence implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private AlarmRunSequence(String value) {
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
        if (other instanceof AlarmRunSequence) {
            AlarmRunSequence obj = (AlarmRunSequence)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static AlarmRunSequence getInstance(String value) {
        return value == null ? null : new AlarmRunSequence(value);
    }
}
