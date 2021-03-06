// AUTOGENERATED: 61ea90c29d0eb72cd3caba2f0736909c
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.alarmclock;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class AlarmID implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<AlarmID, Long> GET_VALUE = new Function<AlarmID, Long>() {
        @Override
        public Long apply(AlarmID input) {
            return input == null ? null : input.getValue();
        }
    };


    private final Long _value;

    private AlarmID(Long value) {
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
        if (other instanceof AlarmID) {
            AlarmID obj = (AlarmID)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static AlarmID getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new AlarmID(value);
    }
}
