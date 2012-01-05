package de.kalass.sonoscontrol.cli.arguments;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

public class SingleZoneSpec extends ZoneSpec {
    private final ZoneName _zoneName;

    private SingleZoneSpec(ZoneName zoneName) {
        _zoneName = Preconditions.checkNotNull(zoneName);
    }

    public static ZoneSpec ofZone(ZoneName zoneName) {
        return new SingleZoneSpec(zoneName);
    }

    public ZoneName getZoneName() {
        return _zoneName;
    }

    @Override
    public <T> T invite(ZoneSpecVisitor<T> visitor) {
        return visitor.visitSingleZone(this);
    }
}
