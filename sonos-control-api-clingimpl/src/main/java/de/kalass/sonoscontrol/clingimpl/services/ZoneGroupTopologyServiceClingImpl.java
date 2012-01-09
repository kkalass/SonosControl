package de.kalass.sonoscontrol.clingimpl.services;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.Device;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.AvailableSoftwareUpdate;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ThirdPartyMediaServers;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateItem;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroupState;

public final class ZoneGroupTopologyServiceClingImpl extends
AbstractZoneGroupTopologyServiceClingImpl {
    public ZoneGroupTopologyServiceClingImpl(UpnpService upnpService,
            Device device, ErrorStrategy errorStrategy) {
        super(upnpService, device, errorStrategy);
    }

    @Override
    protected ZoneGroupState convertZoneGroupState(String rawValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    protected UpdateItem convertUpdateItem(String rawValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    protected ThirdPartyMediaServers convertThirdPartyMediaServers(
            String rawValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    protected AvailableSoftwareUpdate convertAvailableSoftwareUpdate(
            String rawValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}