package de.kalass.sonoscontrol.cli.commands;

public class StartArgs extends ZoneCommandArgs {
	public static final String CMD = "start";
	
	public StartArgs(ZoneSpec zoneSpec) {
		super(zoneSpec);
	}

	@Override
	public <T> T invite(ArgumentsVisitor<T> visitor) {
		return visitor.visitStart(this);
	}
}
