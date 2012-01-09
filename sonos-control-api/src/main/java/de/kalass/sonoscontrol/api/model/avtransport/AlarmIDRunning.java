// AUTOGENERATED: c0baee2ac09d30122c191ab4fb9749a0
// AUTOGENERATED: 09.01.2012 13:05:47
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmIDRunning implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private AlarmIDRunning(Long value) {
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
        if (other instanceof AlarmIDRunning) {
            AlarmIDRunning obj = (AlarmIDRunning)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static AlarmIDRunning getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new AlarmIDRunning(value);
    }
}
