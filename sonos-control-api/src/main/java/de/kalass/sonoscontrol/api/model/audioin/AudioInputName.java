package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AudioInputName {
    private final String _value;

    private AudioInputName(final String value) {
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
        if (other instanceof AudioInputName) {
            return Objects.equal(_value, ((AudioInputName)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static AudioInputName valueOf(String value) {
        return value == null ? null : new AudioInputName(value);
    }
}
