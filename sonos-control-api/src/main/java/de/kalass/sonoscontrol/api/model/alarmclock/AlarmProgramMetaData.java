// AUTOGENERATED: c19366303d5513e3de0a41d4c8ca1e02
// AUTOGENERATED: 09.01.2012 12:49:21
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.alarmclock;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmProgramMetaData implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private AlarmProgramMetaData(String value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public String getValue() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof AlarmProgramMetaData) {
            AlarmProgramMetaData obj = (AlarmProgramMetaData)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static AlarmProgramMetaData getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new AlarmProgramMetaData(value);
    }
}
