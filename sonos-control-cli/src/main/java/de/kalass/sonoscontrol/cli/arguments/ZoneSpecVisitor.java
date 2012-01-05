package de.kalass.sonoscontrol.cli.arguments;

public interface ZoneSpecVisitor<T> {
    T visitSingleZone(SingleZoneSpec spec);
    T visitGroup(GroupZoneSpec spec);
}
