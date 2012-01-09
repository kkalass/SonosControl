// AUTOGENERATED: c7a4e6dc01b62dc7ca4770ea8530c342
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.connectionmanager;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class SourceProtocolInfo implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private SourceProtocolInfo(String value) {
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
        if (other instanceof SourceProtocolInfo) {
            SourceProtocolInfo obj = (SourceProtocolInfo)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static SourceProtocolInfo getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new SourceProtocolInfo(value);
    }
}
