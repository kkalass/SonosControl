package de.kalass.sonoscontrol.api.model.systemproperties;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AccountType {
    private final Long _value;

    private AccountType(final Long value) {
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
        if (other instanceof AccountType) {
            return Objects.equal(_value, ((AccountType)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AccountType valueOf(Long value) {
        return value == null ? null : new AccountType(value);
    }
}