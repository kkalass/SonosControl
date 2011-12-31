package de.kalass.sonoscontrol.cli.commands;

import de.kalass.sonoscontrol.api.model.ZoneName;

/**
 * A Command that can be specified on the command line.
 * @author klas
 */
public abstract class Arguments {

	public abstract <T> T invite(ArgumentsVisitor<T> visitor);
	
	private static final ZoneSpec getZoneSpec(String[] args) {
		if (args.length < 2) {
			return null;
		}
		return new ZoneSpec(ZoneName.getInstance(args[1]));
	}
	
	public static final Arguments parse(String[] args) {
		if (args.length == 0) {
			return new HelpArgs();
		}
		final String cmd = args[0];
		final ZoneSpec zoneSpec = getZoneSpec(args);
		if (zoneSpec == null || HelpArgs.CMD.equals(cmd)) {
			return new HelpArgs();
		}
		if (ShowArgs.CMD.equals(cmd)) {
			return new ShowArgs(zoneSpec);
		}
		if (StartArgs.CMD.equals(cmd)) {
			final String trackUri = args.length < 3 ? null : args[2];
			return new StartArgs(zoneSpec, trackUri);
		}
		if (StopArgs.CMD.equals(cmd)) {
			return new StopArgs(zoneSpec);
		}
		if (MuteArgs.CMD.equals(cmd)) {
			if (args.length < 3) {
				return new HelpArgs();
			}
			final String onOff = args[2];
			return new MuteArgs(zoneSpec, "on".equalsIgnoreCase(onOff));
		}
		return new HelpArgs();
	}
}
