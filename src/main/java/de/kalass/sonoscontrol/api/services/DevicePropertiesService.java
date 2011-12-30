package de.kalass.sonoscontrol.api.services;

import javax.annotation.Nonnull;

import de.kalass.sonoscontrol.api.core.Callback;
import de.kalass.sonoscontrol.api.core.ZoneIcon;
import de.kalass.sonoscontrol.api.core.ZoneName;

public interface DevicePropertiesService {
	
	public interface RetrieveZoneAttributes extends Callback {
		void success(@Nonnull ZoneName currentZoneName, @Nonnull ZoneIcon currentIcon);
	}
	
	void retrieveZoneAttributes(@Nonnull RetrieveZoneAttributes successHandler);
}
