package de.kalass.sonoscontrol.api.model.systemproperties;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AccountPassword {
    private final String _value;

    private AccountPassword(final String value) {
        _value = Preconditions.checkNotNull(value);
    }

    public String asString() {
        return _value;
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AccountPassword) {
            return Objects.equal(_value, ((AccountPassword)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AccountPassword valueOf(String value) {
        return value == null ? null : new AccountPassword(value);
    }
}
