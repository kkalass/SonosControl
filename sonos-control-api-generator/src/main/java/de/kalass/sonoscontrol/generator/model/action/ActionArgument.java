package de.kalass.sonoscontrol.generator.model.action;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

import de.kalass.sonoscontrol.generator.model.StateVariable;

public final class ActionArgument {
    public static final Predicate<ActionArgument> IS_VALUE_HARDCODED = new Predicate<ActionArgument>() {
        @Override
        public boolean apply(ActionArgument input) {
            return input.isValueHardcoded();
        }
    };
    public static final Function<ActionArgument, StateVariable> GET_STATE_VARIABLE = new Function<ActionArgument, StateVariable>() {
        @Override
        public StateVariable apply(ActionArgument input) {
            return input.getRelatedStateVariable();
        }
    };
    public static final Function<ActionArgument, String> GET_PARAMETER_NAME = new Function<ActionArgument, String>() {
        @Override
        public String apply(ActionArgument input) {
            return input.getParameterName();
        }
    };
    private final String _name;
    private final StateVariable _relatedStateVariable;

    public ActionArgument(String name, StateVariable relatedStateVariable) {
        _name = Preconditions.checkNotNull(name);
        _relatedStateVariable = Preconditions.checkNotNull(relatedStateVariable);
    }

    public String getUpnpName() {
        return _name;
    }

    public final String getParameterName() {
        final String name = _name;
        return name.substring(0,1).toLowerCase() + name.substring(1);
    }

    public final String getGetterName() {
        return "get" + _name;
    }

    public StateVariable getRelatedStateVariable() {
        return _relatedStateVariable;
    }

    public boolean isValueHardcoded() {
        // TODO: find out if there is any other possible value besides "0" for InstanceID, which would
        //       make sense to be exposed in the service interface
        //
        //      Also: types like TransportPlaySpeed that have only one valid value by definition are not exposed in the API either
        //
        final String javaTypeName = getRelatedStateVariable().getType().getJavaClassName().getName();
        return "InstanceID".equals(javaTypeName) || getRelatedStateVariable().getType().isSingleInstanceType();
    }
}