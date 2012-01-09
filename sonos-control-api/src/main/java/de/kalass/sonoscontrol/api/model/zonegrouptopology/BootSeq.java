/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import java.io.Serializable;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class BootSeq implements Serializable {
    private static final long serialVersionUID = 1L;


    private final Long _value;

    private BootSeq(Long value) {
        _value = Preconditions.checkNotNull(value);
    }

    public Long getValue() {
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
        if (other instanceof BootSeq) {
            BootSeq obj = (BootSeq)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static BootSeq getInstance(Long value) {
        return value == null ? null : new BootSeq(value);
    }
}
