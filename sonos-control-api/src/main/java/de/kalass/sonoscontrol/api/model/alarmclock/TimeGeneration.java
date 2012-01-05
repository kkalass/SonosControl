package de.kalass.sonoscontrol.api.model.alarmclock;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class TimeGeneration implements Serializable {
    private static final long serialVersionUID = 1L;


	private final Long _value;

    private TimeGeneration(Long value) {
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
        if (other instanceof TimeGeneration) {
            TimeGeneration obj = (TimeGeneration)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static TimeGeneration getInstance(Long value) {
        return value == null ? null : new TimeGeneration(value);
    }
}
