package de.kalass.sonoscontrol.clingimpl;

import org.teleal.cling.UpnpService;
import org.teleal.cling.controlpoint.SubscriptionCallback;
import org.teleal.cling.model.gena.CancelReason;
import org.teleal.cling.model.gena.GENASubscription;
import org.teleal.cling.model.message.UpnpResponse;
import org.teleal.cling.model.meta.Device;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.CachedOnly;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.DiagnosticID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UnresponsiveDeviceActionType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateFlags;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateItem;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateURL;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.Version;
import de.kalass.sonoscontrol.api.services.ZoneGroupTopologyService;

public class ZoneGroupTopologyServiceImpl extends AbstractServiceImpl implements ZoneGroupTopologyService {
    public ZoneGroupTopologyServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("ZoneGroupTopology", upnpService, device, errorStrategy);

        // TODO KK: the events contain some data I need, but still quite unstructured.
        //          I need to structure ZoneGroupState and integrate querying of it into my API.
        upnpService.getControlPoint().execute(new SubscriptionCallback(Preconditions.checkNotNull(getService())) {

            @Override
            protected void failed(GENASubscription subscription,
                    UpnpResponse responseStatus, Exception exception, String defaultMsg) {
                System.out.println("failed" + defaultMsg);
            }

            @Override
            protected void eventsMissed(GENASubscription subscription,
                    int numberOfMissedEvents) {
                System.out.println("eventsMissed " + numberOfMissedEvents);
            }

            @Override
            protected void eventReceived(GENASubscription subscription) {
                System.out.println("eventReceived " + subscription.getCurrentValues());
            }

            @Override
            protected void established(GENASubscription subscription) {
                System.out.println("established " + subscription.getCurrentValues());
            }

            @Override
            protected void ended(GENASubscription subscription, CancelReason reason,
                    UpnpResponse responseStatus) {
                System.out.println("ended " + subscription + subscription.getCurrentValues() + " reason: " + reason);
            }
        });
    }
    @Override
    public <C extends Callback1<UpdateItem>> C checkForUpdate(
            UpdateType updateType, CachedOnly cachedOnly, Version version,
            C callback) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <C extends Callback0> C beginSoftwareUpdate(UpdateURL updateURL,
            UpdateFlags flags, C callback) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <C extends Callback0> C reportUnresponsiveDevice(
            MemberID deviceUUID, UnresponsiveDeviceActionType desiredAction,
            C callback) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <C extends Callback0> C reportAlarmStartedRunning(C callback) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <C extends Callback1<DiagnosticID>> C submitDiagnostics(C callback) {
        // TODO Auto-generated method stub
        return null;
    }

}
