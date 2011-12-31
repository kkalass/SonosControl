package de.kalass.sonoscontrol.cli.commands;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.api.model.ZoneName;

public class ZoneSpec {
	private final ZoneName _zoneName;
	
	public ZoneSpec(ZoneName zoneName) {
		_zoneName = Preconditions.checkNotNull(zoneName);
	}
	
	public ZoneName getZoneName() {
		return _zoneName;
	}
}
