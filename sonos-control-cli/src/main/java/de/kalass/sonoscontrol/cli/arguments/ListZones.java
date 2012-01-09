package de.kalass.sonoscontrol.cli.arguments;

public class ListZones extends ZoneCommandArgs {
    public static final String CMD = "list";

    public ListZones(ZoneSpec zoneSpec) {
        super(zoneSpec);
    }

    @Override
    public <T> T invite(ArgumentsVisitor<T> visitor) {
        return visitor.visitListZones(this);
    }
}
