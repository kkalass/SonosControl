package de.kalass.sonoscontrol.api.core;

public interface Callback3<T, V, W> extends Callback {
	public void success(T value, V value2, W value3);
}
