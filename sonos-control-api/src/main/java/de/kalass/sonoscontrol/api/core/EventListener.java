package de.kalass.sonoscontrol.api.core;

public interface EventListener<T> {

    void valueChanged(T oldValue, T newValue);
}
