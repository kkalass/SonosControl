package de.kalass.sonoscontrol.cli.commands;

public abstract class ZoneCommandArgs extends Arguments {
	private final ZoneSpec _zoneSpec;
	
	public ZoneCommandArgs(ZoneSpec zoneSpec) {
		_zoneSpec = zoneSpec;
	}
	
	public ZoneSpec getZoneSpec() {
		return _zoneSpec;
	}
}
