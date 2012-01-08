package de.kalass.sonoscontrol.clingimpl;

import java.util.concurrent.ExecutionException;

import org.testng.annotations.BeforeClass;

import com.google.common.util.concurrent.SettableFuture;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosControl.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.clingimpl.core.SonosControlClingImpl;

public abstract class AbstractSonosServiceTest<T> {

    private T _service;

    @BeforeClass
    protected void prepareDevice() throws InterruptedException, ExecutionException{
        final SonosControl c = new SonosControlClingImpl();
        final SettableFuture<SonosDevice> deviceFuture = SettableFuture.create();
        c.executeOnZone(ZoneName.getInstance("Esszimmer"), new SonosDeviceCallback() {

            @Override
            public void success(SonosDevice device) {
                deviceFuture.set(device);
            }
        });
        final SonosDevice device = deviceFuture.get();
        _service = extractService(device);
    }

    protected abstract T extractService(SonosDevice device);

    protected T getService() {
        return _service;
    }

}

