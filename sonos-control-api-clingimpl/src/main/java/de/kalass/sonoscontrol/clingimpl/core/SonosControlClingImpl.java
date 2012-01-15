package de.kalass.sonoscontrol.clingimpl.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.Nonnull;

import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.RemoteDevice;
import org.fourthline.cling.registry.DefaultRegistryListener;
import org.fourthline.cling.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import de.kalass.sonoscontrol.api.control.ExecutionMode;
import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.control.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.core.AsyncValue;
import de.kalass.sonoscontrol.api.core.Callback;
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
    private final ExecuteOnZoneListener _listener = new ExecuteOnZoneListener();

    private final boolean _ownUpnpService;

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

    private final class SingleZoneCallback implements SonosDeviceCallback {
        private final SonosDeviceCallback _callback;
        private final ZoneName _zoneName;

        public SingleZoneCallback(SonosDeviceCallback callback,
                ZoneName zoneName) {
            super();
            _callback = Preconditions.checkNotNull(callback);
            _zoneName = Preconditions.checkNotNull(zoneName);
        }

        @Override
        public ExecutionMode execute(SonosDevice device) {
            if (_zoneName.equals(device.getZoneName())) {
                return _callback.execute(device);
            }
            return ExecutionMode.EACH_DEVICE_DETECTION;
        }
    }

    private final class ExecuteOnZoneListener extends
    DefaultRegistryListener {
        @Nonnull
        private final Queue<SonosDeviceCallback> _commands;

        private ExecuteOnZoneListener() {
            _commands = new ConcurrentLinkedQueue<SonosDeviceCallback>();
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
        public void deviceRemoved(Registry registry, @SuppressWarnings("rawtypes") Device device) {
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

        public void execute(SonosDeviceCallback cmd) {
            @SuppressWarnings("rawtypes")
            final Collection<Device> devices = ImmutableList.copyOf(_upnpService.getRegistry().getDevices());

            for (@SuppressWarnings("rawtypes") Device device : devices) {
                if (executeIfSonos(device, cmd) == ExecutionMode.FINISH) {
                    return;
                }
            }
            // needs to continue execution on further device detections
            _commands.add(cmd);
        }

        @SuppressWarnings("rawtypes")
        @Override
        public synchronized void deviceAdded(Registry registry, final Device device) {
            System.out.println("Found device:" + device.getDisplayString());
            LOG.info("Found device: " + device.getDisplayString() + " " + device.getIdentity().getUdn().getIdentifierString());

            executeIfSonos(device, new SonosDeviceCallback() {
                @Override
                public ExecutionMode execute(SonosDevice device) {
                    final Collection<SonosDeviceCallback> reexecutionList = new ArrayList<SonosDeviceCallback>();
                    SonosDeviceCallback cmd;
                    while ((cmd = _commands.poll()) != null) {
                        if (cmd.execute(device) == ExecutionMode.EACH_DEVICE_DETECTION) {
                            // reschedule
                            reexecutionList.add(cmd);
                        }
                    }
                    if (!reexecutionList.isEmpty()) {
                        for (SonosDeviceCallback cb : reexecutionList) {
                            _commands.add(cb);
                        }
                    }
                    return ExecutionMode.FINISH;
                }
            });
        }

        private ExecutionMode executeIfSonos(@SuppressWarnings("rawtypes") final Device device, final SonosDeviceCallback cb) {
            if (!isSonos(device)) {
                return ExecutionMode.EACH_DEVICE_DETECTION;
            }
            final DevicePropertiesService propsService = new DevicePropertiesServiceClingImpl(_upnpService, device, _errorStrategy);
            final GetZoneAttributesResult attributes = propsService.retrieveZoneAttributes(new AsyncValue<GetZoneAttributesResult>()).get();
            final ZoneName currentZoneName = attributes.getCurrentZoneName();
            final SonosDevice sonosDevice = new SonosDeviceImpl(
                    MemberID.getInstance(device.getIdentity().getUdn().getIdentifierString()),
                    currentZoneName, propsService, _upnpService, device, _errorStrategy);
            return cb.execute(sonosDevice);
        }

        private boolean isSonos(@SuppressWarnings("rawtypes") final Device device) {
            return device.getDetails().getManufacturerDetails().getManufacturer().contains("Sonos");
        }
    }

    public SonosControlClingImpl() {
        this(new UpnpServiceImpl(), true);
    }

    public SonosControlClingImpl(UpnpService upnpService) {
        this(upnpService, false);
    }
    private SonosControlClingImpl(UpnpService upnpService, boolean ownUpnpService) {
        this._upnpService = upnpService;
        _ownUpnpService = ownUpnpService;
        this._upnpService.getRegistry().addListener(_listener);

        // Send a search message to all devices and services, they should respond soon
        this._upnpService.getControlPoint().search(/*new STAllHeader(), 120*/);
        LOG.info("currently found devices:" + this._upnpService.getRegistry().getDevices());
    }

    @Override
    public void setErrorStrategy(ErrorStrategy errorStrategy) {
        this._errorStrategy = new BaseErrorStrategy(errorStrategy);
    }


    @Override
    public void shutdown() {
        _upnpService.getRegistry().removeListener(_listener);
        if (_ownUpnpService) {
            _upnpService.shutdown();
        }
    }

    @Override
    public void executeOnZone(final ZoneName zoneName, final SonosDeviceCallback callback) {
        _listener.execute(new SingleZoneCallback(callback, zoneName));
    }

    @Override
    public void executeOnAnyZone(SonosDeviceCallback callback) {
        _listener.execute(callback);
    }
}
