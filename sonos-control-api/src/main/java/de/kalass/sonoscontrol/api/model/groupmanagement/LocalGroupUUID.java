package de.kalass.sonoscontrol.api.model.groupmanagement;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class LocalGroupUUID {
    private final String _value;

    private LocalGroupUUID(final String value) {
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
        if (other instanceof LocalGroupUUID) {
            return Objects.equal(_value, ((LocalGroupUUID)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static LocalGroupUUID valueOf(String value) {
        return value == null ? null : new LocalGroupUUID(value);
    }
}
