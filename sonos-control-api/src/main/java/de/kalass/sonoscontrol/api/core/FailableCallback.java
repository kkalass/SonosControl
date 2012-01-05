package de.kalass.sonoscontrol.api.core;

/**
 * If your {@link Callback} implementation extends this interface,
 * you will also receive calls on failures.
 * 
 * @author klas
 *
 */
public interface FailableCallback extends Callback {
    public void fail(String defaultMsg);
}
