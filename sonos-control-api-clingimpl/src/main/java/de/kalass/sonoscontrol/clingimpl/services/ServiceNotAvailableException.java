package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

public class ServiceNotAvailableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceNotAvailableException(String servicename, ZoneName zone) {
        super("Service " + servicename + " was expected to be available on zone " + zone + ", but it was not");
    }
}
