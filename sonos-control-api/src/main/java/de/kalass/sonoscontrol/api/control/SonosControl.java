package de.kalass.sonoscontrol.api.control;

import javax.annotation.Nonnull;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

public interface SonosControl {

    /**
     * Sets the general strategy to use, when an asynchronous call failed due to an error.
     */
    public void setErrorStrategy(@Nonnull ErrorStrategy errorStrategy);

    /**
     * Shutdown the SonosControl instance.
     */
    public void shutdown();

    /**
     * Executes the given {@link SonosDeviceCallback} as soon as the Zone with the given
     * {@link ZoneName} becomes available, or immediately if that zone is available currently.
     * 
     * <p>If the Callback returns {@link ExecutionMode#FINISH}, the callback will be
     * deregistered after execution. Else, it will be rescheduled for execution, should the
     * zone become unavailable and then available again at a later time.</p>
     * 
     * @param zoneName the name of the zone to execute on.
     * @param callback the command to execute
     */
    void executeOnZone(@Nonnull ZoneName zoneName, @Nonnull SonosDeviceCallback callback);

    /**
     * Executes the given {@link SonosDeviceCallback} as soon as any Zone becomes available,
     * or immediately if a zone is available currently.
     * 
     * <p>If the Callback returns {@link ExecutionMode#FINISH}, the callback will be
     * deregistered after execution. Else, it will be rescheduled for execution.
     * It will then be executed on the next found device - regardless of wether it is
     * a new device, or the same device that is re-discovered.</p>
     * 
     * <p>If you want to execute some action on a known Zone, you should rather use {@link #executeOnZone(ZoneName, SonosDeviceCallback)}</p>
     * 
     * @param callback the command to execute
     */
    void executeOnAnyZone(@Nonnull SonosDeviceCallback callback);
}
