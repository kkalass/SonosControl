package de.kalass.sonoscontrol.api.model.musicservices;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ServiceDescriptorList implements Serializable {
    private static final long serialVersionUID = 1L;


	private final String _value;

    private ServiceDescriptorList(String value) {
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
        if (other instanceof ServiceDescriptorList) {
            ServiceDescriptorList obj = (ServiceDescriptorList)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static ServiceDescriptorList getInstance(String value) {
        return value == null ? null : new ServiceDescriptorList(value);
    }
}
