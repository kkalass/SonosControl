/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.renderingcontrol;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class RightVolume implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final long MIN = 0;
    public static final long MAX = 100;
    public static final long STEP = 1;

    private final Long _value;

    private RightVolume(Long value) {
        _value = Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value.longValue() >= MIN && value.longValue() <= MAX);
        Preconditions.checkArgument(((value.longValue() -  MIN) % STEP) == 0);
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
        if (other instanceof RightVolume) {
            RightVolume obj = (RightVolume)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static RightVolume getInstance(Long value) {
        return value == null ? null : new RightVolume(value);
    }
}
