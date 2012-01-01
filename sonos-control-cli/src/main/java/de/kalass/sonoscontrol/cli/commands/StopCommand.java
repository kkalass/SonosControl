package de.kalass.sonoscontrol.cli.commands;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.services.AVTransportService;
import de.kalass.sonoscontrol.cli.arguments.StopArgs;

public final class StopCommand extends SonosDeviceCommand {

	public StopCommand(StopArgs args) {
		super(args);
	}

	@Override
	public void call(final SonosDevice device, final CliCommandResultCallback callback) {
		AVTransportService avTransportService = device.getAVTransportService();
		avTransportService.stop(new CallbackWrapper(callback, "Stopped playing "));
	}
}