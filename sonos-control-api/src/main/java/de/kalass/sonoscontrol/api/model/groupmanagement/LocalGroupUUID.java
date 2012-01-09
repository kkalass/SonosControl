// AUTOGENERATED: a996e1369422beb775ff4053235d3d99
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.groupmanagement;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class LocalGroupUUID implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private LocalGroupUUID(String value) {
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
        if (other instanceof LocalGroupUUID) {
            LocalGroupUUID obj = (LocalGroupUUID)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static LocalGroupUUID getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new LocalGroupUUID(value);
    }
}
