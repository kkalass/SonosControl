package de.kalass.sonoscontrol.api.core;

import com.google.common.util.concurrent.AbstractFuture;

public final class AsyncValue<T> extends AbstractFuture<T> implements Callback1<T>, FailableCallback {

	@Override
	public void fail(String defaultMsg) {
		setException(new RuntimeException(defaultMsg));
	}
	
	@Override
	public void success(T value) {
		set(value);
	}
}
