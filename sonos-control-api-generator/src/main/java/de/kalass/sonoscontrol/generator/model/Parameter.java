package de.kalass.sonoscontrol.generator.model;

import com.google.common.base.Function;

public class Parameter {
    public static final Function<Parameter, JavaClassName> GET_JAVA_CLASS_NAME = new Function<Parameter, JavaClassName>() {
        @Override
        public JavaClassName apply(Parameter input) {
            return input.getJavaClassName();
        }
    };
    private final String _name;
    private final JavaClassName _type;

    public Parameter(String name, JavaClassName type) {
        _name = name;
        _type = type;
    }

    public final String getParameterName() {
        final String name = _name;
        return name.substring(0,1).toLowerCase() + name.substring(1);
    }

    public final String getGetterName() {
        return "get" + _name.substring(0,1).toUpperCase() + _name.substring(1);
    }

    public String getName() {
        return _name;
    }

    public JavaClassName getJavaClassName() {
        return _type;
    }
}
