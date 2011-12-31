package de.kalass.sonoscontrol.cli.commands;

public interface ArgumentsVisitor<T> {
	T visitHelp(HelpArgs help);
	T visitShow(ShowArgs show);
	T visitStart(StartArgs start);
	T visitStop(StopArgs stop);
	T visitMute(MuteArgs mute);
}
