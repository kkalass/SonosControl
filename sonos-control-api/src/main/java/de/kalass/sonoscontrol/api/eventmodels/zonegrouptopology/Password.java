/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology;

import java.io.Serializable;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class Password implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String _value;

    private Password(String value) {
        _value = Preconditions.checkNotNull(value);
    }

    public String getValue() {
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
        if (other instanceof Password) {
            Password obj = (Password)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static Password getInstance(String value) {
        return value == null ? null : new Password(value);
    }
}
