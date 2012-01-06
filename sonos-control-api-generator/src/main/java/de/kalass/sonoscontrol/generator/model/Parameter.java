package de.kalass.sonoscontrol.generator.model;

import com.google.common.base.Function;

import de.kalass.sonoscontrol.generator.model.types.Type;

public class Parameter {
    public static final Function<Parameter, Type> GET_TYPE = new Function<Parameter, Type>() {
        @Override
        public Type apply(Parameter input) {
            return input.getType();
        }
    };
    private final String _name;
    private final Type _type;

    public Parameter(String name, Type type) {
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

    public Type getType() {
        return _type;
    }
}
