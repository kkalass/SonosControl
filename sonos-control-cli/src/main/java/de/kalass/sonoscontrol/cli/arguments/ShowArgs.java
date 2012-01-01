package de.kalass.sonoscontrol.cli.arguments;

public class ShowArgs extends ZoneCommandArgs {
	public static final String CMD = "show";
	
	public ShowArgs(ZoneSpec zoneSpec) {
		super(zoneSpec);
	}

	@Override
	public <T> T invite(ArgumentsVisitor<T> visitor) {
		return visitor.visitShow(this);
	}
}
