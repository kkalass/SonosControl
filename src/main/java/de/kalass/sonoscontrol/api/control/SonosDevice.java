package de.kalass.sonoscontrol.api.control;

import javax.annotation.Nonnull;

import de.kalass.sonoscontrol.api.core.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.RenderingControlService;

public interface SonosDevice {
	
	@Nonnull
	public ZoneName getZoneName();
	
	@Nonnull
	public DevicePropertiesService getDevicePropertiesService();
	
	@Nonnull
	public RenderingControlService getRenderingControlService();
}
