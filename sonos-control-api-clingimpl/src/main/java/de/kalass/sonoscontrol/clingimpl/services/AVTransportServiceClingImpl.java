package de.kalass.sonoscontrol.clingimpl.services;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.avtransport.LastAVTransportChange;

public final class AVTransportServiceClingImpl extends
AbstractAVTransportServiceClingImpl {
    public AVTransportServiceClingImpl(UpnpService upnpService,
            Device device, ErrorStrategy errorStrategy) {
        super(upnpService, device, errorStrategy);
    }

    @Override
    protected LastAVTransportChange convertLastChange(String rawValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}