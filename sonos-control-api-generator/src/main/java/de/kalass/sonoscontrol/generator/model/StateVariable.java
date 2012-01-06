package de.kalass.sonoscontrol.generator.model;

import javax.annotation.Nonnull;

import com.google.common.base.Function;

import de.kalass.sonoscontrol.generator.model.types.BooleanType;
import de.kalass.sonoscontrol.generator.model.types.EnumType;
import de.kalass.sonoscontrol.generator.model.types.SingleValueType;
import de.kalass.sonoscontrol.generator.model.types.Type;
import de.kalass.sonoscontrol.generator.upnp.UpnpDatatype;
import de.kalass.sonoscontrol.generator.upnp.UpnpStateVariable;

public final class StateVariable {
    public static final Function<StateVariable, Type> GET_TYPE = new Function<StateVariable, Type>() {
        @Override
        public Type apply(StateVariable input) {
            return input.getType();
        }
    };


    @Nonnull
    private final Type _type;
    private final boolean _sendEvents;
    private final String _stateVariableName;
    private final String _upnpStateVariableName;

    public StateVariable(UpnpStateVariable stateVariable, ServiceNameFactory serviceNameFactory) {
        _sendEvents = stateVariable.isSendEvents();
        _stateVariableName = createJavaTypeName(stateVariable.getName());
        _upnpStateVariableName = stateVariable.getName();

        final JavaClassName javaClassName = serviceNameFactory.getModelClassName(createJavaTypeName(stateVariable.getName()));
        final UpnpDatatype upnpDataType = stateVariable.getDataType();
        if (javaClassName.getFQN().startsWith("java.")) {
            // definitely not a custom type
            _type = new Type(javaClassName);
        } else if ("boolean".equals(upnpDataType.getValue())) {
            _type = new BooleanType(upnpDataType, javaClassName);
        } else if (!stateVariable.getAllowedValueList().isEmpty()) {
            _type = new EnumType(upnpDataType, javaClassName, stateVariable.getAllowedValueList());
        } else {
            _type = new SingleValueType(upnpDataType, javaClassName, stateVariable.getAllowedValueRange());
        }
    }

    public Type getType() {
        return _type;
    }

    private String createJavaTypeName(String name) {
        return name.startsWith("A_ARG_TYPE_") ? name.substring("A_ARG_TYPE_".length()) : name ;
    }

    public boolean isSendEvents() {
        return _sendEvents;
    }

    public String getStateVariableName() {
        return _stateVariableName;
    }

    public String getUpnpStateVariableName() {
        return _upnpStateVariableName;
    }
}