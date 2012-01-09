// AUTOGENERATED: 9d7d63f5dfe9c286c1b29372e310373b
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.deviceproperties;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ExtraInfo implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private ExtraInfo(String value) {
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
        if (other instanceof ExtraInfo) {
            ExtraInfo obj = (ExtraInfo)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static ExtraInfo getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new ExtraInfo(value);
    }
}
