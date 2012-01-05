package de.kalass.sonoscontrol.cli.commands;

import java.util.concurrent.ExecutionException;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.AsyncValue;
import de.kalass.sonoscontrol.api.model.deviceproperties.GetZoneAttributesResult;
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

        final AsyncValue<GetZoneAttributesResult> attributes = propsService.retrieveZoneAttributes(new AsyncValue<GetZoneAttributesResult>());

        final AsyncValue<Volume> volume = renderingControlService.retrieveVolume(Channel.MASTER, new AsyncValue<Volume>());
        final AsyncValue<Mute> mute = renderingControlService.retrieveMute(MuteChannel.MASTER, new AsyncValue<Mute>());

        String msg = "VOLUME: " + volume.get().getValue() + "\n"
                + "MUTE: " + mute.get().getValue() + "\n"
                + "ATTRIBUTES: " + attributes.get() +  "\n";

        callback.success(msg);
    }
}