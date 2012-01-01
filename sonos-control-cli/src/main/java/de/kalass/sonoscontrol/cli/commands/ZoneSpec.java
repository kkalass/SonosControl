package de.kalass.sonoscontrol.cli.commands;


public abstract class ZoneSpec {
	
	public abstract <T> T invite(ZoneSpecVisitor<T> visitor);
	
}
