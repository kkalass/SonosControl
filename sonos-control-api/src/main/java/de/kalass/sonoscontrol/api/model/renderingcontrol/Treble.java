package de.kalass.sonoscontrol.api.model.renderingcontrol;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class Treble {

    public static final long MIN = -10;
    public static final long MAX = 10;
    public static final long STEP = 1;

    private final Long _value;

    private Treble(final Long value) {
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
        if (other instanceof Treble) {
            return Objects.equal(_value, ((Treble)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static Treble valueOf(Long value) {
        return value == null ? null : new Treble(value);
    }
}
