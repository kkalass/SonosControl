package de.kalass.sonoscontrol.api.model.alarmclock;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmID implements Serializable {
    private static final long serialVersionUID = 1L;


	private final Long _value;

    private AlarmID(Long value) {
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
        if (other instanceof AlarmID) {
            AlarmID obj = (AlarmID)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static AlarmID getInstance(Long value) {
        return value == null ? null : new AlarmID(value);
    }
}
