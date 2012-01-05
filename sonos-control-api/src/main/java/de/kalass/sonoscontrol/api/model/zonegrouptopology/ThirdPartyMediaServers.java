package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ThirdPartyMediaServers implements Serializable {
    private static final long serialVersionUID = 1L;


    private final String _value;

    private ThirdPartyMediaServers(String value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public String asString() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof ThirdPartyMediaServers) {
            ThirdPartyMediaServers obj = (ThirdPartyMediaServers)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static ThirdPartyMediaServers getInstance(String value) {
        return value == null ? null : new ThirdPartyMediaServers(value);
    }
}
