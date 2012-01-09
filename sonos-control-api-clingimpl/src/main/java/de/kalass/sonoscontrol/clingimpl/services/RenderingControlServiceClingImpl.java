package de.kalass.sonoscontrol.clingimpl.services;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.renderingcontrol.LastRenderingControlChange;

public final class RenderingControlServiceClingImpl extends
AbstractRenderingControlServiceClingImpl {
    public RenderingControlServiceClingImpl(UpnpService upnpService,
            Device device, ErrorStrategy errorStrategy) {
        super(upnpService, device, errorStrategy);
    }

    @Override
    protected LastRenderingControlChange convertLastChange(
            String rawValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}