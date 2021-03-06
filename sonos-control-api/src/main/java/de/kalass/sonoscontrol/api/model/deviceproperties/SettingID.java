// AUTOGENERATED: a5289d72e2714bbad03949f5690fc247
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.deviceproperties;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class SettingID implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<SettingID, Long> GET_VALUE = new Function<SettingID, Long>() {
        @Override
        public Long apply(SettingID input) {
            return input == null ? null : input.getValue();
        }
    };

    public static final long MIN = 0;
    public static final long MAX = 65535;

    private final Long _value;

    private SettingID(Long value) {
        _value = Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value.longValue() >= MIN && value.longValue() <= MAX);
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
        if (other instanceof SettingID) {
            SettingID obj = (SettingID)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static SettingID getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new SettingID(value);
    }
}
