// AUTOGENERATED: c54cc03fe477224334261b5f7b2ab9a8
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.connectionmanager;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class RcsID implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<RcsID, Long> GET_VALUE = new Function<RcsID, Long>() {
        @Override
        public Long apply(RcsID input) {
            return input == null ? null : input.getValue();
        }
    };


    private final Long _value;

    private RcsID(Long value) {
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
        if (other instanceof RcsID) {
            RcsID obj = (RcsID)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static RcsID getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new RcsID(value);
    }
}
