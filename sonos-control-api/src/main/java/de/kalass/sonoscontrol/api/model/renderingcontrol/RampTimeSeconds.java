// AUTOGENERATED: bf7869ccd02b93c99229fe7573534126
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.renderingcontrol;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class RampTimeSeconds implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<RampTimeSeconds, Long> GET_VALUE = new Function<RampTimeSeconds, Long>() {
        @Override
        public Long apply(RampTimeSeconds input) {
            return input == null ? null : input.getValue();
        }
    };


    private final Long _value;

    private RampTimeSeconds(Long value) {
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
        if (other instanceof RampTimeSeconds) {
            RampTimeSeconds obj = (RampTimeSeconds)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static RampTimeSeconds getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new RampTimeSeconds(value);
    }
}
