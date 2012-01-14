package de.kalass.sonoscontrol.clingimpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import com.google.common.util.concurrent.SettableFuture;

import de.kalass.sonoscontrol.api.control.ExecutionMode;
import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.control.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.clingimpl.core.SonosControlClingImpl;
import de.kalass.sonoscontrol.clingimpl.services.ServiceNotAvailableException;

public abstract class AbstractSonosServiceTest<T> {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AbstractSonosServiceTest.class);
    private T _service;
    private ZoneName _zoneName;

    @BeforeClass()
    protected void prepareDevice() throws InterruptedException, ExecutionException{
        final SonosControl c = new SonosControlClingImpl();
        final SettableFuture<SonosDevice> deviceFuture = SettableFuture.create();
        c.executeOnAnyZone(new SonosDeviceCallback() {

            @Override
            public ExecutionMode execute(SonosDevice device) {
                if (extractService(device) != null) {
                    // Will only change value for the first found device - we will always use the first sonos this way
                    deviceFuture.set(device);
                    return ExecutionMode.FINISH;
                } else {
                    LOG.info("Did not find service" + getServiceName() + " in device " + device.getZoneName() + ", will look in other device");
                }
                return ExecutionMode.EACH_DEVICE_DETECTION;
            }
        });
        SonosDevice device = null;
        try {
            device = deviceFuture.get(5, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            LOG.info("Gave up looking for service " + getServiceName());
        }
        _zoneName = device.getZoneName();
        _service = extractService(device);

        LOG.info("\n\n----------- WILL TEST SERVICE: " + getServiceName() + " on zone " + _zoneName + "\n\n");
    }

    protected abstract T extractService(SonosDevice device);

    protected abstract String getServiceName();

    protected T getService() {
        if (_service == null) {
            throw new ServiceNotAvailableException(getServiceName(), _zoneName);
        }
        return _service;
    }

}

