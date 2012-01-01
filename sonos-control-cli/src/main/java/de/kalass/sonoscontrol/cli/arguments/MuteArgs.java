package de.kalass.sonoscontrol.cli.arguments;

public class MuteArgs extends ZoneCommandArgs {
	public static final String CMD = "mute";
	private final boolean _mute;
	
	public MuteArgs(ZoneSpec zoneSpec, boolean mute) {
		super(zoneSpec);
		_mute = mute;
	}
	
	public boolean isMute() {
		return _mute;
	}
	
	@Override
	public <T> T invite(ArgumentsVisitor<T> visitor) {
		return visitor.visitMute(this);
	}
}
