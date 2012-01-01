package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class CurrentTrackMetaData {
    private final String _value;

    private CurrentTrackMetaData(final String value) {
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
        if (other instanceof CurrentTrackMetaData) {
            return Objects.equal(_value, ((CurrentTrackMetaData)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static CurrentTrackMetaData valueOf(String value) {
        return value == null ? null : new CurrentTrackMetaData(value);
    }
}
