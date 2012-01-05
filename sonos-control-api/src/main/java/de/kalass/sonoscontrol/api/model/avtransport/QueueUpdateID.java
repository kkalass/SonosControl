/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class QueueUpdateID implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private QueueUpdateID(Long value) {
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
        if (other instanceof QueueUpdateID) {
            QueueUpdateID obj = (QueueUpdateID)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static QueueUpdateID getInstance(Long value) {
        return value == null ? null : new QueueUpdateID(value);
    }
}
