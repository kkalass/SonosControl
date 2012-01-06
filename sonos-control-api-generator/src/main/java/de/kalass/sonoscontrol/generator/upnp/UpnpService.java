package de.kalass.sonoscontrol.generator.upnp;

import java.util.List;




public final class UpnpService {

    private final List<UpnpStateVariable> _stateVariables;
    private final List<UpnpAction> _actions;
    private final String _name;

    public UpnpService(String name, List<UpnpStateVariable> stateVariables, List<UpnpAction> actions) {
        _name = name;
        _stateVariables = stateVariables;
        _actions = actions;
    }
    public String getName() {
        return _name;
    }
    public List<UpnpAction> getActions() {
        return _actions;
    }
    public List<UpnpStateVariable> getStateVariables() {
        return _stateVariables;
    }
}