package de.kalass.sonoscontrol.generator.upnp;

public final class UpnpActionArgument {
    private final String _name;
    private final UpnpStateVariable _relatedStateVariable;
    public UpnpActionArgument(String name, UpnpStateVariable relatedStateVariable) {
        _name = name;
        _relatedStateVariable = relatedStateVariable;
    }
    public String getName() {
        return _name;
    }
    public UpnpStateVariable getRelatedStateVariable() {
        return _relatedStateVariable;
    }
}