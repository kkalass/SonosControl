package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ThirdPartyMediaServers {
    private final String _value;

    private ThirdPartyMediaServers(final String value) {
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
        if (other instanceof ThirdPartyMediaServers) {
            return Objects.equal(_value, ((ThirdPartyMediaServers)other)._value);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public static ThirdPartyMediaServers valueOf(String value) {
        return value == null ? null : new ThirdPartyMediaServers(value);
    }
}
