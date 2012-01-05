/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.deviceproperties;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class SettingID implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final long MIN = 0;
    public static final long MAX = 65535;

    private final Long _value;

    private SettingID(Long value) {
        _value = Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value.longValue() >= MIN && value.longValue() <= MAX);
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
        if (other instanceof SettingID) {
            SettingID obj = (SettingID)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static SettingID getInstance(Long value) {
        return value == null ? null : new SettingID(value);
    }
}
