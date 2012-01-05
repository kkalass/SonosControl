/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class SleepTimerGeneration implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private SleepTimerGeneration(Long value) {
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
        if (other instanceof SleepTimerGeneration) {
            SleepTimerGeneration obj = (SleepTimerGeneration)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static SleepTimerGeneration getInstance(Long value) {
        return value == null ? null : new SleepTimerGeneration(value);
    }
}
