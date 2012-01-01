package de.kalass.sonoscontrol.api.model.deviceproperties;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class SettingsReplicationState {
    private final String _value;

    private SettingsReplicationState(final String value) {
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
        if (other instanceof SettingsReplicationState) {
            return Objects.equal(_value, ((SettingsReplicationState)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static SettingsReplicationState valueOf(String value) {
        return value == null ? null : new SettingsReplicationState(value);
    }
}
