package de.kalass.sonoscontrol.api.model.renderingcontrol;

import java.io.Serializable;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class PresetNameList implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private PresetNameList(String value) {
        _value = Preconditions.checkNotNull(value);
    }

    public String getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_value);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof PresetNameList) {
            PresetNameList obj = (PresetNameList)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static PresetNameList getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }

        return value == null ? null : new PresetNameList(value);
    }
}
