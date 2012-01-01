package de.kalass.sonoscontrol.cli.arguments;


public abstract class ZoneSpec {
	
	public abstract <T> T invite(ZoneSpecVisitor<T> visitor);
	
}
