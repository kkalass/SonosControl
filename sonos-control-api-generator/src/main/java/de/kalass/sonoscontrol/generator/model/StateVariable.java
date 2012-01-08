package de.kalass.sonoscontrol.generator.model;

import com.google.common.base.Function;

import de.kalass.sonoscontrol.generator.model.types.Type;
import de.kalass.sonoscontrol.generator.upnp.UpnpStateVariable;

public final class StateVariable extends Parameter {
    public static final Function<StateVariable, Type> GET_TYPE = new Function<StateVariable, Type>() {
        @Override
        public Type apply(StateVariable input) {
            return input.getType();
        }
    };

    private final Type _type;
    private final boolean _sendEvents;
    private final String _upnpStateVariableName;

    public StateVariable(UpnpStateVariable stateVariable, Type type) {
        super(stateVariable.getName(), type.getJavaClassName());
        _type = type;
        _sendEvents = stateVariable.isSendEvents();
        _upnpStateVariableName = stateVariable.getName();
    }


    public Type getType() {
        return _type;
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