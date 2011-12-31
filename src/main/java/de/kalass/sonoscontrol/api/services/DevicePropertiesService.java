package de.kalass.sonoscontrol.api.services;

import javax.annotation.Nonnull;

import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.ZoneAttributes;

public interface DevicePropertiesService {
	<C extends  Callback1<ZoneAttributes>> C retrieveZoneAttributes(@Nonnull C successHandler);
}
