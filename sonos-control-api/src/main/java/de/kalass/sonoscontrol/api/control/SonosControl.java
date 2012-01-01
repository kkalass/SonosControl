package de.kalass.sonoscontrol.api.control;

import javax.annotation.Nonnull;

import de.kalass.sonoscontrol.api.core.Callback;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

public interface SonosControl {
	
	/**
	 * Sets the general strategy to use, when an asynchronous call failed due to an error.
	 */
	public void setErrorStrategy(@Nonnull ErrorStrategy errorStrategy);
	public void setTimeout(int millis);
	
	public void shutdown();
	
	public interface SonosDeviceCallback extends Callback {
		void success(@Nonnull SonosDevice device);
	}
		
	void executeOnZone(@Nonnull ZoneName zoneName, @Nonnull SonosDeviceCallback callback);
}
