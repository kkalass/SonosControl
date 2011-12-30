package de.kalass.sonoscontrol.api.core;

public interface Callback2<T, V> extends Callback {
	public void success(T value, V value2);
}
