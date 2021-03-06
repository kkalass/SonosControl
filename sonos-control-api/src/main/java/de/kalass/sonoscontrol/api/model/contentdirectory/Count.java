// AUTOGENERATED: 979ac0bab621324c3f64b09308586809
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.contentdirectory;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class Count implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<Count, Long> GET_VALUE = new Function<Count, Long>() {
        @Override
        public Long apply(Count input) {
            return input == null ? null : input.getValue();
        }
    };


    private final Long _value;

    private Count(Long value) {
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
        if (other instanceof Count) {
            Count obj = (Count)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static Count getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new Count(value);
    }
}
