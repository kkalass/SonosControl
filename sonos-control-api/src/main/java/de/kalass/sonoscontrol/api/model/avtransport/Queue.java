package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class Queue implements Serializable {
    private static final long serialVersionUID = 1L;


	private final String _value;

    private Queue(String value) {
		_value = Preconditions.checkNotNull(value);
    } 

    public String asString() {
        return _value;
    }  
    
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }
    
    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof Queue) {
            Queue obj = (Queue)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static Queue getInstance(String value) {
        return value == null ? null : new Queue(value);
    }
}
