// AUTOGENERATED: 644508dc6d3e59a2ebed46d6d448e8da
// AUTOGENERATED: 09.01.2012 12:49:21
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.deviceproperties;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class SoftwareVersion implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private SoftwareVersion(String value) {
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
        if (other instanceof SoftwareVersion) {
            SoftwareVersion obj = (SoftwareVersion)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static SoftwareVersion getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new SoftwareVersion(value);
    }
}
