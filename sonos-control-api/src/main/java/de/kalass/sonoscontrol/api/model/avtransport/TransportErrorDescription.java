/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class TransportErrorDescription implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private TransportErrorDescription(String value) {
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
        if (other instanceof TransportErrorDescription) {
            TransportErrorDescription obj = (TransportErrorDescription)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static TransportErrorDescription getInstance(String value) {
        return value == null ? null : new TransportErrorDescription(value);
    }
}
