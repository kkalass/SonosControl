package de.kalass.sonoscontrol.cli.commands;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Mute;
import de.kalass.sonoscontrol.api.model.renderingcontrol.MuteChannel;
import de.kalass.sonoscontrol.api.services.RenderingControlService;
import de.kalass.sonoscontrol.cli.arguments.MuteArgs;

public final class MuteCommand extends SonosDeviceCommand {
	private final MuteArgs _muteCmd;

	public MuteCommand(MuteArgs muteArgs) {
		super(muteArgs);
		_muteCmd = muteArgs;
	}

	@Override
	public void call(final SonosDevice device, final CliCommandResultCallback callback) {
		final RenderingControlService renderingControlService = device.getRenderingControlService();
		renderingControlService.setMute(MuteChannel.MASTER, Mute.valueOf(_muteCmd.isMute()), new CallbackWrapper(callback, "Mute " + _muteCmd.isMute()));
	}
}