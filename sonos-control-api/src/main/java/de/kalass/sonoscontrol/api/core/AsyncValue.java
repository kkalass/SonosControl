package de.kalass.sonoscontrol.api.core;

import java.util.concurrent.ExecutionException;

import com.google.common.util.concurrent.AbstractFuture;

public final class AsyncValue<T> extends AbstractFuture<T> implements Callback1<T>, FailableCallback {

    @Override
    public T get() {
        try {
            return super.get();
        } catch (InterruptedException e) {
            return null;
        } catch (ExecutionException e) {
            throw new IllegalStateException(e.getCause());
        }
    }
    @Override
    public void fail(String defaultMsg) {
        setException(new RuntimeException(defaultMsg));
    }

    @Override
    public void success(T value) {
        set(value);
    }
}
