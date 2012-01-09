package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import java.io.Serializable;
import java.net.URI;

import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.deviceproperties.Icon;
import de.kalass.sonoscontrol.api.model.deviceproperties.SoftwareVersion;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

public final class ZoneGroupMember implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
     <ZoneGroupMember UUID="RINCON_000E58354D7A01400"
            Location="http://192.168.0.161:1400/xml/device_description.xml"
            ZoneName="Wohnzimmer" Icon="x-rincon-roomicon:living"
            SoftwareVersion="16.5-48010a" MinCompatibleVersion="15.0-00000"
            BootSeq="238" />
     */

    private final MemberID _zonePlayerId;
    private final URI _location;
    private final ZoneName _zoneName;
    private final Icon _icon;
    private final SoftwareVersion _softwareVersion;
    private final SoftwareVersion _minCompatibleVersion;
    private final BootSeq _bootSeq;

    private ZoneGroupMember(
            MemberID zonePlayerId,
            URI location,
            ZoneName zoneName, Icon icon, SoftwareVersion softwareVersion,
            SoftwareVersion minCompatibleVersion, BootSeq bootSeq) {
        super();
        _zonePlayerId = zonePlayerId;
        _location = location;
        _zoneName = zoneName;
        _icon = icon;
        _softwareVersion = softwareVersion;
        _minCompatibleVersion = minCompatibleVersion;
        _bootSeq = bootSeq;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public MemberID getZonePlayerId() {
        return _zonePlayerId;
    }

    public URI getLocation() {
        return _location;
    }

    public ZoneName getZoneName() {
        return _zoneName;
    }

    public Icon getIcon() {
        return _icon;
    }

    public SoftwareVersion getSoftwareVersion() {
        return _softwareVersion;
    }

    public SoftwareVersion getMinCompatibleVersion() {
        return _minCompatibleVersion;
    }

    public BootSeq getBootSeq() {
        return _bootSeq;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("bootSeq", _bootSeq)
                .add("icon", _icon)
                .add("location", _location)
                .add("minCompatibleVersion", _minCompatibleVersion)
                .add("softwareVersion", _softwareVersion)
                .add("zoneName", _zoneName)
                .add("zonePlayerId", _zonePlayerId)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                _bootSeq,  _icon, _location,
                _minCompatibleVersion, _softwareVersion, _zoneName, _zonePlayerId);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ZoneGroupMember) {
            final ZoneGroupMember obj = (ZoneGroupMember)other;
            return Objects.equal(_bootSeq, obj._bootSeq) &&
                    Objects.equal(_icon, obj._icon) &&
                    Objects.equal(_location, obj._location) &&
                    Objects.equal(_minCompatibleVersion, obj._minCompatibleVersion) &&
                    Objects.equal(_softwareVersion, obj._softwareVersion) &&
                    Objects.equal(_zoneName, obj._zoneName) &&
                    Objects.equal(_zonePlayerId, obj._zonePlayerId);
        }
        return false;
    }

    public static ZoneGroupMember getInstance(
            MemberID zonePlayerId,
            URI location,
            ZoneName zoneName, Icon icon, SoftwareVersion softwareVersion,
            SoftwareVersion minCompatibleVersion, BootSeq bootSeq
            ) {
        return new ZoneGroupMember(
                zonePlayerId, location, zoneName, icon, softwareVersion,
                minCompatibleVersion, bootSeq);
    }
}
