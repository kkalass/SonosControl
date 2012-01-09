// AUTOGENERATED: 6c80db65dd175ee5ae7efb77149b5aa1
// AUTOGENERATED: 09.01.2012 13:05:47
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.renderingcontrol;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class EQValue implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private EQValue(Long value) {
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
        if (other instanceof EQValue) {
            EQValue obj = (EQValue)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static EQValue getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new EQValue(value);
    }
}
