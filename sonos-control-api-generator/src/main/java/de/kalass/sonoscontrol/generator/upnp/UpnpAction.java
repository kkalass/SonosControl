package de.kalass.sonoscontrol.generator.upnp;

import java.util.List;

public final class UpnpAction {
    private final UpnpActionName _name;
    private final List<UpnpActionArgument> _inputParameters;
    private final List<UpnpActionArgument> _outputParameters;

    public UpnpAction(UpnpActionName name, List<UpnpActionArgument> inputParameters, List<UpnpActionArgument> outputParameters) {
        _name = name;
        _inputParameters = inputParameters;
        _outputParameters = outputParameters;
    }

    public UpnpActionName getName() {
        return _name;
    }

    public List<UpnpActionArgument> getInputParameters() {
        return _inputParameters;
    }

    public List<UpnpActionArgument> getOutputParameters() {
        return _outputParameters;
    }

}