package de.kalass.sonoscontrol.api.model.renderingcontrol;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class VolumeAdjustment {
    private final Long _value;

    private VolumeAdjustment(final Long value) {
        _value = Preconditions.checkNotNull(value);
    }

    public Long asLong() {
        return _value;
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof VolumeAdjustment) {
            return Objects.equal(_value, ((VolumeAdjustment)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static VolumeAdjustment valueOf(Long value) {
        return value == null ? null : new VolumeAdjustment(value);
    }
}
