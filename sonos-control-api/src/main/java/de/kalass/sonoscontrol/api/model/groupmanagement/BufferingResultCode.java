package de.kalass.sonoscontrol.api.model.groupmanagement;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class BufferingResultCode implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private BufferingResultCode(Long value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public Long asLong() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof BufferingResultCode) {
            BufferingResultCode obj = (BufferingResultCode)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static BufferingResultCode getInstance(Long value) {
        return value == null ? null : new BufferingResultCode(value);
    }
}
