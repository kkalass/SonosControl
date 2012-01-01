package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class PossibleRecordQualityModes {
    private final String _value;

    private PossibleRecordQualityModes(final String value) {
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
        if (other instanceof PossibleRecordQualityModes) {
            return Objects.equal(_value, ((PossibleRecordQualityModes)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static PossibleRecordQualityModes valueOf(String value) {
        return value == null ? null : new PossibleRecordQualityModes(value);
    }
}
