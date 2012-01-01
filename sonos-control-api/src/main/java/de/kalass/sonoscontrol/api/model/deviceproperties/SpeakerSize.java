package de.kalass.sonoscontrol.api.model.deviceproperties;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class SpeakerSize {

    public static final long MIN = 0;
    public static final long MAX = 3;
    public static final long STEP = 1;

    private final Long _value;

    private SpeakerSize(final Long value) {
        _value = Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value.longValue() >= MIN && value.longValue() <= MAX);
        Preconditions.checkArgument(((value.longValue() -  MIN) % STEP) == 0);
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
        if (other instanceof SpeakerSize) {
            return Objects.equal(_value, ((SpeakerSize)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static SpeakerSize valueOf(Long value) {
        return value == null ? null : new SpeakerSize(value);
    }
}
