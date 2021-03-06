package de.kalass.sonoscontrol.api.model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class MemberID {
    private final String _value;

    private MemberID(final String value) {
        _value = Preconditions.checkNotNull(value);
    }

    public String getValue() {
        return _value;
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof MemberID) {
            return Objects.equal(_value, ((MemberID)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static MemberID getInstance(String value) {
        return value == null ? null : new MemberID(value);
    }
}
