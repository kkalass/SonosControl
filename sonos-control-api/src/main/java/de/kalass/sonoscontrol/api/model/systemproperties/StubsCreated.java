package de.kalass.sonoscontrol.api.model.systemproperties;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class StubsCreated implements Serializable {
    private static final long serialVersionUID = 1L;


	private final String _value;

    private StubsCreated(String value) {
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
        if (other instanceof StubsCreated) {
            StubsCreated obj = (StubsCreated)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static StubsCreated getInstance(String value) {
        return value == null ? null : new StubsCreated(value);
    }
}
