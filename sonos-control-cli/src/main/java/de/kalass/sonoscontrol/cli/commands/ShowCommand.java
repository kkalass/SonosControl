package de.kalass.sonoscontrol.cli.commands;

import java.util.concurrent.ExecutionException;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.AsyncValue;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneAttributes;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Channel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Mute;
import de.kalass.sonoscontrol.api.model.renderingcontrol.MuteChannel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Volume;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.RenderingControlService;
import de.kalass.sonoscontrol.cli.arguments.ShowArgs;

public final class ShowCommand extends SonosDeviceCommand {
	public ShowCommand(ShowArgs args) {
		super(args);
	}

	@Override
	public void call(SonosDevice device, CliCommandResultCallback callback) throws InterruptedException, ExecutionException  {
		final DevicePropertiesService propsService = device.getDevicePropertiesService();
		final RenderingControlService renderingControlService = device.getRenderingControlService();
		
		final AsyncValue<ZoneAttributes> attributes = propsService.getZoneAttributes(new AsyncValue<ZoneAttributes>());

		final AsyncValue<Volume> volume = renderingControlService.getVolume(Channel.MASTER, new AsyncValue<Volume>());
		final AsyncValue<Mute> mute = renderingControlService.getMute(MuteChannel.MASTER, new AsyncValue<Mute>());

		String msg = "VOLUME: " + volume.get().asLong() + "\n"  
				+ "MUTE: " + mute.get().asBoolean() + "\n"  
				+ "ATTRIBUTES: " + attributes.get() +  "\n";

		callback.success(msg);
	}
}