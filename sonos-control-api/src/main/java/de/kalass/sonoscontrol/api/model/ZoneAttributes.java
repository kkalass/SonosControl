package de.kalass.sonoscontrol.api.model;

import com.google.common.base.Objects;


public class ZoneAttributes {
	private final ZoneName _zoneName;
	private final ZoneIcon _zoneIcon;
	public ZoneAttributes(ZoneName zoneName, ZoneIcon zoneIcon) {
		_zoneIcon = zoneIcon;
		_zoneName = zoneName;
	}
	public ZoneIcon getZoneIcon() {
		return _zoneIcon;
	}
	
	public ZoneName getZoneName() {
		return _zoneName;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("name", _zoneName).add("icon", _zoneIcon).toString();
	}
}