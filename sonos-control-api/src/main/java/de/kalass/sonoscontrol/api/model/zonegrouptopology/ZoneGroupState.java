package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import java.io.Serializable;
import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

import de.kalass.sonoscontrol.api.model.MemberID;

public final class ZoneGroupState implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
 <ZoneGroups>
    <ZoneGroup Coordinator="RINCON_000E58354D7A01400" ID="RINCON_000E58354D7A01400:45">
        <ZoneGroupMember UUID="RINCON_000E58354D7A01400"
            Location="http://192.168.0.161:1400/xml/device_description.xml"
            ZoneName="Wohnzimmer" Icon="x-rincon-roomicon:living"
            SoftwareVersion="16.5-48010a" MinCompatibleVersion="15.0-00000"
            BootSeq="238" />
    </ZoneGroup>
    <ZoneGroup Coordinator="RINCON_000E5827600401400" ID="RINCON_000E5827600401400:52">
        <ZoneGroupMember UUID="RINCON_000E5827600401400"
            Location="http://192.168.0.100:1400/xml/device_description.xml"
            ZoneName="Esszimmer" Icon="x-rincon-roomicon:dining"
            SoftwareVersion="16.5-48010a" MinCompatibleVersion="15.0-00000"
            BootSeq="200" />
    </ZoneGroup>
</ZoneGroups>
     */
    private final List<ZoneGroup> _zoneGroups;

    private ZoneGroupState(List<ZoneGroup> zoneGroups) {
        _zoneGroups = Preconditions.checkNotNull(zoneGroups);
    }

    public List<ZoneGroup> getValue() {
        return _zoneGroups;
    }

    public ZoneGroup getOwnedGroup(MemberID deviceId) {
        final List<ZoneGroup> zoneGroups = getValue();
        final Predicate<ZoneGroup> isGroupCoordinator = Predicates.compose(
                Predicates.equalTo(deviceId),
                ZoneGroup.GET_COORDINATOR
                );
        return Iterables.find(zoneGroups, isGroupCoordinator);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _zoneGroups).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_zoneGroups);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ZoneGroupState) {
            final ZoneGroupState obj = (ZoneGroupState)other;
            return Objects.equal(_zoneGroups, obj._zoneGroups);
        }
        return false;
    }

    public static ZoneGroupState getInstance(List<ZoneGroup> zoneGroups) {
        return zoneGroups == null ? null : new ZoneGroupState(zoneGroups);
    }
}
