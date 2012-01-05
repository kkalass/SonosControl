package de.kalass.sonoscontrol.generator;

import com.google.common.base.Function;
import com.google.common.base.Objects;

public class UpnpActionName {
    private final String _name;
    public static final Function<UpnpActionName, String> AS_STRING = new Function<UpnpActionName, String>() {

        @Override
        public String apply(UpnpActionName input) {
            return input.asString();
        }
    };

    private UpnpActionName(String name) {
        _name = name.trim();
    }

    public static final UpnpActionName valueOf(String name) {
        return new UpnpActionName(name);
    }

    public String asString() {
        return _name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UpnpActionName) {
            final UpnpActionName pn = (UpnpActionName)obj;
            return _name.equals(pn._name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return _name.hashCode();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("name", _name).toString();
    }

}
