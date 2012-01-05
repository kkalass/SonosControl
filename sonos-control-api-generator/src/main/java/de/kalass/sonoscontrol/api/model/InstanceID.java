/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model;

import java.io.Serializable;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class InstanceID implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final InstanceID DEFAULT_VALUE = InstanceID.getInstance(Long.valueOf(0));

    private final Long _value;

    private InstanceID(Long value) {
        _value = Preconditions.checkNotNull(value);
    }

    public Long getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_value);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof InstanceID) {
            InstanceID obj = (InstanceID)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static InstanceID getInstance(Long value) {
        return value == null ? null : new InstanceID(value);
    }
}
