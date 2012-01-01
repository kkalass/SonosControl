package de.kalass.sonoscontrol.api.model.renderingcontrol;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class Bass {
    private final Integer _value;

    private Bass(final Integer value) {
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
        if (other instanceof Bass) {
            return Objects.equal(_value, ((Bass)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static Bass valueOf(Integer value) {
        return value == null ? null : new Bass(value);
    }
}
