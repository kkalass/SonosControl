package de.kalass.sonoscontrol.api.generator;

import com.google.common.base.Function;
import com.google.common.base.Objects;

public class UpnpDatatype {
    public static final Function<UpnpDatatype, String> AS_STRING = new Function<UpnpDatatype, String> () {
        @Override
        public String apply(UpnpDatatype input) {
            return input.asString();
        }
    };

    public static final Function<UpnpDatatype, Class<?>> GET_JAVA_CLASS = new Function<UpnpDatatype, Class<?>>() {
        @Override
        public Class<?> apply(UpnpDatatype input) {
            return input.getJavaClass();
        }
    };

    private final String _value;

    private UpnpDatatype(String value) {
        _value = value;
    }

    public static UpnpDatatype valueOf(String value) {
        return new UpnpDatatype(value);
    }

    public String asString() {
        return _value;
    }

    public Class<?> getJavaClass() {
        final String datatype = _value;
        if ("boolean".equals(datatype)) {
            return Boolean.class;
        }
        if ("string".equals(datatype)) {
            return String.class;
        }
        if ("i4".equals(datatype)) {
            return Long.class;
        }
        if ("ui4".equals(datatype)) {
            return Long.class;
        }
        if ("ui2".equals(datatype)) {
            return Long.class;
        }
        if ("i2".equals(datatype)) {
            return Long.class;
        }
        throw new IllegalArgumentException("unsupported type: " + datatype);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UpnpDatatype) {
            return _value.equals(((UpnpDatatype) obj)._value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }
}
