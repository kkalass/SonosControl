package de.kalass.sonoscontrol.cli.commands;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.cli.arguments.ZoneCommandArgs;
import de.kalass.sonoscontrol.cli.arguments.ZoneSpec;

public abstract class SonosDeviceCommand {
    private final ZoneSpec _zoneSpec;

    public SonosDeviceCommand(ZoneCommandArgs args) {
        this(args.getZoneSpec());
    }

    public SonosDeviceCommand(ZoneSpec zoneSpec) {
        _zoneSpec = zoneSpec;
    }

    public final ZoneSpec getZoneSpec() {
        return _zoneSpec;
    }

    public abstract void call(SonosDevice device, CliCommandResultCallback callback) throws Exception;
}