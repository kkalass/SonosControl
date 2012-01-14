package de.kalass.sonoscontrol.api.control;

import javax.annotation.Nonnull;

import de.kalass.sonoscontrol.api.core.Callback;

/**
 * A Callback that will be invoked for a SonosDevice.
 * 
 * @author klas
 */
public interface SonosDeviceCallback extends Callback {
    @Nonnull
    ExecutionMode execute(@Nonnull SonosDevice device);
}