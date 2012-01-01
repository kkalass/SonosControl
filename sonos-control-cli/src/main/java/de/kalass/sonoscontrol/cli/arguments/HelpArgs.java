package de.kalass.sonoscontrol.cli.arguments;

public class HelpArgs extends Arguments {
	public static final String CMD = "help";
	
	@Override
	public <T> T invite(ArgumentsVisitor<T> visitor) {
		return visitor.visitHelp(this);
	}
}
