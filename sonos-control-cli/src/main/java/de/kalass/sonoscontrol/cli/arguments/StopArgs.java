package de.kalass.sonoscontrol.cli.arguments;

public class StopArgs extends ZoneCommandArgs {
    public static final String CMD = "stop";

    public StopArgs(ZoneSpec zoneSpec) {
        super(zoneSpec);
    }

    @Override
    public <T> T invite(ArgumentsVisitor<T> visitor) {
        return visitor.visitStop(this);
    }
}
