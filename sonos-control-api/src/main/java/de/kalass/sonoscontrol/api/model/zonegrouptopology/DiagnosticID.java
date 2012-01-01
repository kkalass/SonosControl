package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class DiagnosticID {
    private final Long _value;

    private DiagnosticID(final Long value) {
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
        if (other instanceof DiagnosticID) {
            return Objects.equal(_value, ((DiagnosticID)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static DiagnosticID valueOf(Long value) {
        return value == null ? null : new DiagnosticID(value);
    }
}
