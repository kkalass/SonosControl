// AUTOGENERATED: e329509d1fb7b9f3dc602ae6bda8cb18
// AUTOGENERATED: 09.01.2012 12:49:21
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.audioin;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class RightLineInLevel implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private RightLineInLevel(Long value) {
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
        if (other instanceof RightLineInLevel) {
            RightLineInLevel obj = (RightLineInLevel)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static RightLineInLevel getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new RightLineInLevel(value);
    }
}
