package de.kalass.sonoscontrol.cli.commands;

public interface CliCommandResultCallback {
	void success(String output);
	void fail(Throwable t);
}