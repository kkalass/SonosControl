package de.kalass.sonoscontrol.api.model.systemproperties;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class StubsCreated {
    private final String _value;

    private StubsCreated(final String value) {
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
        if (other instanceof StubsCreated) {
            return Objects.equal(_value, ((StubsCreated)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static StubsCreated valueOf(String value) {
        return value == null ? null : new StubsCreated(value);
    }
}
