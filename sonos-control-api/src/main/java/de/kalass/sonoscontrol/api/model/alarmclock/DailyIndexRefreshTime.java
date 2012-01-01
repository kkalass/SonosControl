package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class DailyIndexRefreshTime {
    private final String _value;

    private DailyIndexRefreshTime(final String value) {
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
        if (other instanceof DailyIndexRefreshTime) {
            return Objects.equal(_value, ((DailyIndexRefreshTime)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static DailyIndexRefreshTime valueOf(String value) {
        return value == null ? null : new DailyIndexRefreshTime(value);
    }
}
