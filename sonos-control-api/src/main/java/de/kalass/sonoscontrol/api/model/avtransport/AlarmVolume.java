package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AlarmVolume {
    private final Integer _value;

    private AlarmVolume(final Integer value) {
        _value = Preconditions.checkNotNull(value);
    }

    public Integer asInteger() {
        return _value;
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AlarmVolume) {
            return Objects.equal(_value, ((AlarmVolume)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AlarmVolume valueOf(Integer value) {
        return value == null ? null : new AlarmVolume(value);
    }
}
