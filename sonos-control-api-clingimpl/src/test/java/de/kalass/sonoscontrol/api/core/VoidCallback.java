package de.kalass.sonoscontrol.api.core;

import java.util.concurrent.CountDownLatch;

public class VoidCallback implements Callback0 {
    private final CountDownLatch _latch = new CountDownLatch(1);

    @Override
    public void success() {
        _latch.countDown();
    }

    public void waitForSuccess() {
        try {
            _latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
