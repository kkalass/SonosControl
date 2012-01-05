package de.kalass.sonoscontrol.api.model.alarmclock;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ISO8601Time implements Serializable {
    private static final long serialVersionUID = 1L;


	private final String _value;

    private ISO8601Time(String value) {
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
        if (other instanceof ISO8601Time) {
            ISO8601Time obj = (ISO8601Time)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static ISO8601Time getInstance(String value) {
        return value == null ? null : new ISO8601Time(value);
    }
}
