package de.kalass.sonoscontrol.clingimpl.core;

import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

public class ServiceNotAvailableException extends RuntimeException {

    public ServiceNotAvailableException(String servicename, ZoneName zone) {
        super("Service " + servicename + " was expected to be available on zone, but it was not");
    }
}
