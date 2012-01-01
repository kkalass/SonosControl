package de.kalass.sonoscontrol.cli.commands;

public interface ZoneSpecVisitor<T> {
	T visitSingleZone(SingleZoneSpec spec);
	T visitGroup(GroupZoneSpec spec);
}
