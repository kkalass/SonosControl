package de.kalass.sonoscontrol.clingimpl;

import java.util.concurrent.ExecutionException;

import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import com.google.common.util.concurrent.SettableFuture;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosControl.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.core.ServiceNotAvailableException;
import de.kalass.sonoscontrol.clingimpl.core.SonosControlClingImpl;

public abstract class AbstractSonosServiceTest<T> {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AbstractSonosServiceTest.class);
    private T _service;

    @BeforeClass
    protected void prepareDevice() throws InterruptedException, ExecutionException{
        final SonosControl c = new SonosControlClingImpl();
        final SettableFuture<SonosDevice> deviceFuture = SettableFuture.create();
        c.executeOnAllZones(new SonosDeviceCallback() {

            @Override
            public void success(SonosDevice device) {
                // Will only change value for the first found device - we will always use the first sonos this way
                deviceFuture.set(device);
            }
        });
        final SonosDevice device = deviceFuture.get();
        _service = extractService(device);
        if (_service == null) {
            throw new ServiceNotAvailableException(getServiceName(), device.getZoneName());
        }
        LOG.info("\n\n----------- WILL TEST SERVICE: " + _service + "\n\n");
    }

    protected abstract T extractService(SonosDevice device);

    protected abstract String getServiceName();

    protected T getService() {
        return _service;
    }

}

