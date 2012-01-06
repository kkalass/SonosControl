package de.kalass.sonoscontrol.generator.model;

import com.google.common.base.Function;

import de.kalass.sonoscontrol.generator.model.types.BooleanType;
import de.kalass.sonoscontrol.generator.model.types.EnumType;
import de.kalass.sonoscontrol.generator.model.types.SingleValueType;
import de.kalass.sonoscontrol.generator.model.types.Type;
import de.kalass.sonoscontrol.generator.upnp.UpnpDatatype;
import de.kalass.sonoscontrol.generator.upnp.UpnpStateVariable;

public final class StateVariable extends Parameter {
    public static final Function<StateVariable, Type> GET_TYPE = new Function<StateVariable, Type>() {
        @Override
        public Type apply(StateVariable input) {
            return input.getType();
        }
    };

    private final boolean _sendEvents;
    private final String _upnpStateVariableName;

    public StateVariable(UpnpStateVariable stateVariable, ServiceNameFactory serviceNameFactory) {
        super(createJavaTypeName(stateVariable.getName()), createType(stateVariable, serviceNameFactory));
        _sendEvents = stateVariable.isSendEvents();
        _upnpStateVariableName = stateVariable.getName();
    }

    private static Type createType(UpnpStateVariable stateVariable,
            ServiceNameFactory serviceNameFactory) {
        final JavaClassName javaClassName = serviceNameFactory.getModelClassName(createJavaTypeName(stateVariable.getName()));
        final UpnpDatatype upnpDataType = stateVariable.getDataType();
        if (javaClassName.getFQN().startsWith("java.")) {
            // definitely not a custom type
            return new Type(javaClassName);
        } else if ("boolean".equals(upnpDataType.getValue())) {
            return new BooleanType(upnpDataType, javaClassName);
        } else if (!stateVariable.getAllowedValueList().isEmpty()) {
            return new EnumType(upnpDataType, javaClassName, stateVariable.getAllowedValueList());
        } else {
            return new SingleValueType(upnpDataType, javaClassName, stateVariable.getAllowedValueRange());
        }
    }

    private static String createJavaTypeName(String name) {
        return name.startsWith("A_ARG_TYPE_") ? name.substring("A_ARG_TYPE_".length()) : name ;
    }

    public boolean isSendEvents() {
        return _sendEvents;
    }

    public String getStateVariableName() {
        return getName();
    }

    public String getUpnpStateVariableName() {
        return _upnpStateVariableName;
    }
}