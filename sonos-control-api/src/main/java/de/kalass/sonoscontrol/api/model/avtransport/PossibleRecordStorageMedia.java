package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class PossibleRecordStorageMedia {
    private final String _value;

    private PossibleRecordStorageMedia(final String value) {
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
        if (other instanceof PossibleRecordStorageMedia) {
            return Objects.equal(_value, ((PossibleRecordStorageMedia)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static PossibleRecordStorageMedia valueOf(String value) {
        return value == null ? null : new PossibleRecordStorageMedia(value);
    }
}
