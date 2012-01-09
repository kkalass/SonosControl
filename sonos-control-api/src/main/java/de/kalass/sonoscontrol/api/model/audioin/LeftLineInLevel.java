// AUTOGENERATED: 3955538dafa34a21b300c3f28c8c4c2c
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.audioin;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class LeftLineInLevel implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<LeftLineInLevel, Long> GET_VALUE = new Function<LeftLineInLevel, Long>() {
        @Override
        public Long apply(LeftLineInLevel input) {
            return input == null ? null : input.getValue();
        }
    };


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
