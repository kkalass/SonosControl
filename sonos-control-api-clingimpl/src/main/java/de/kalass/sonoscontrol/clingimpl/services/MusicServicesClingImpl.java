

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.musicservices.ListAvailableServicesResult;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceListVersion;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceTypeList;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceDescriptorList;

@SuppressWarnings("rawtypes")
public final class MusicServicesClingImpl extends AbstractServiceImpl {

    public MusicServicesClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("MusicServices", upnpService, device, errorStrategy);
    }


    public ServiceListVersion getServiceListVersion() {
        throw new UnsupportedOperationException();
    }


    public <C extends Callback1<ListAvailableServicesResult>> C listAvailableServices(final C successHandler) {
        return execute(successHandler, new Call<C>("ListAvailableServices") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                handler.success();
            }
        });
    }

    public <C extends Callback0> C updateAvailableServices(final C successHandler) {
        return execute(successHandler, new Call<C>("UpdateAvailableServices") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                handler.success();
            }
        });
    }

}
