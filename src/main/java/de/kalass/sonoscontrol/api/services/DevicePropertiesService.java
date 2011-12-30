package de.kalass.sonoscontrol.api.services;

import javax.annotation.Nonnull;

import de.kalass.sonoscontrol.api.core.Callback2;
import de.kalass.sonoscontrol.api.core.ZoneIcon;
import de.kalass.sonoscontrol.api.core.ZoneName;

public interface DevicePropertiesService {

	void retrieveZoneAttributes(@Nonnull Callback2<ZoneName, ZoneIcon> successHandler);
}
