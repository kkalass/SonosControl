package de.kalass.sonoscontrol.api.model.groupmanagement;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class BufferingResultCode {
    private final Long _value;

    private BufferingResultCode(final Long value) {
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
        if (other instanceof BufferingResultCode) {
            return Objects.equal(_value, ((BufferingResultCode)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static BufferingResultCode valueOf(Long value) {
        return value == null ? null : new BufferingResultCode(value);
    }
}
