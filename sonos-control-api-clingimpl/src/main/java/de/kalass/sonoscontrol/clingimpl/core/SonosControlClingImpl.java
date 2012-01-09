package de.kalass.sonoscontrol.clingimpl.core;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.model.message.header.STAllHeader;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.meta.RemoteDevice;
import org.teleal.cling.registry.DefaultRegistryListener;
import org.teleal.cling.registry.Registry;
import org.teleal.cling.registry.RegistryListener;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.core.Callback;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.core.FailableCallback;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.deviceproperties.GetZoneAttributesResult;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.clingimpl.services.DevicePropertiesServiceClingImpl;

/**
 * Implementation of the SonosControl service, using CLING http://teleal.org/projects/cling
 * @author klas
 */
public class SonosControlClingImpl implements SonosControl {
    private static final Logger LOG = LoggerFactory.getLogger(SonosControlClingImpl.class);

    private final UpnpService _upnpService;

    private ErrorStrategy _errorStrategy = new BaseErrorStrategy(null);

    private int _millis;

    private static final class BaseErrorStrategy implements ErrorStrategy {
        private final ErrorStrategy _delegate;
        public BaseErrorStrategy(@javax.annotation.Nullable ErrorStrategy delegate) {
            _delegate = delegate;
        }
        @Override
        public void onFailure(Callback callback, String message) {
            if (callback instanceof FailableCallback) {
                final FailableCallback cb = (FailableCallback)callback;
                cb.fail(message);
            }
            if (_delegate != null) {
                _delegate.onFailure(callback, message);
            }
        }
    }
    private final class ExecuteOnZoneListener extends
    DefaultRegistryListener {
        @Nonnull
        private final SonosDeviceCallback callback;
        @CheckForNull
        private final ZoneName zoneName;

        private ExecuteOnZoneListener(
                @Nonnull SonosDeviceCallback callback,
                @Nullable ZoneName zoneName) {
            this.callback = callback;
            this.zoneName = zoneName;
        }

        @Override
        public void beforeShutdown(Registry registry) {
            LOG.info("Device discovery shutdown started");
        }

        @Override
        public void afterShutdown() {
            LOG.info("Device discovery shutdown finished");
        }

        @Override
        public void deviceRemoved(Registry registry, Device device) {
            LOG.info("Device removed: " + device.getDisplayString());
        }

        @Override
        public void remoteDeviceDiscoveryStarted(Registry registry,
                RemoteDevice device) {
            LOG.info("Remote device discovery started: " + device.getDisplayString());
        }

        @Override
        public void remoteDeviceDiscoveryFailed(Registry registry,
                RemoteDevice device, Exception ex) {
            LOG.info("Remote device discovery failed: " + device.getDisplayString(), ex);
        }

        @Override
        public void remoteDeviceUpdated(Registry registry, RemoteDevice device) {
            LOG.info("Remote device updated: " + device.getDisplayString());
        }

        @SuppressWarnings("rawtypes")
        @Override
        public void deviceAdded(Registry registry, final Device device) {
            System.out.println("Found device:" + device.getDisplayString());
            LOG.info("Found device: " + device.getDisplayString() + " " + device.getIdentity().getUdn().getIdentifierString());
            if (!device.getDetails().getManufacturerDetails().getManufacturer().contains("Sonos")) {
                return;
            }

            final DevicePropertiesService propsService = new DevicePropertiesServiceClingImpl(_upnpService, device, _errorStrategy);
            propsService.retrieveZoneAttributes(new Callback1<GetZoneAttributesResult>() {
                @Override
                public void success(GetZoneAttributesResult attributes) {
                    if (zoneName == null || zoneName.equals(attributes.getCurrentZoneName())) {

                        callback.success(new SonosDeviceImpl(
                                MemberID.getInstance(device.getIdentity().getUdn().getIdentifierString()),
                                attributes.getCurrentZoneName(), propsService, _upnpService, device, _errorStrategy));

                        // avoid firing multiple times
                        _upnpService.getRegistry().removeListener(ExecuteOnZoneListener.this);
                        LOG.debug("removed "+ ExecuteOnZoneListener.this);

                    }
                }
            });
        }
    }

    public SonosControlClingImpl() {
        this(new UpnpServiceImpl());
    }

    public SonosControlClingImpl(UpnpService upnpService) {
        this._upnpService = upnpService;
    }

    @Override
    public void setErrorStrategy(ErrorStrategy errorStrategy) {
        this._errorStrategy = new BaseErrorStrategy(errorStrategy);
    }

    @Override
    public void setTimeout(int millis) {
        this._millis = millis;
    }

    @Override
    public void shutdown() {
        _upnpService.shutdown();
    }

    protected void execute(RegistryListener listener, int timeout) {
        // FIXME (KK): how to implement timeout?
        LOG.debug("Added " + listener);
        this._upnpService.getRegistry().addListener(listener);

        // Send a search message to all devices and services, they should respond soon
        this._upnpService.getControlPoint().search(new STAllHeader());
        LOG.info("currently found devices:" + this._upnpService.getRegistry().getDevices());

        // FIXME(KK): Improve device Discovery, sometimes I do not get any sonos devices,
        //            even though they are on the network, and scanning the network with a
        //            simple wget-bash script will find them correctly
        //
        //            Maybe I need to add scanning of the network as an option.
    }

    @Override
    public void executeOnZone(final ZoneName zoneName, final SonosDeviceCallback callback) {
        execute(new ExecuteOnZoneListener(callback, zoneName), _millis);
    }

    @Override
    public void executeOnAllZones(SonosDeviceCallback callback) {
        execute(new ExecuteOnZoneListener(callback, null), _millis);
    }
}
