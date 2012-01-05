package de.kalass.sonoscontrol.api.model.deviceproperties;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class ZoneInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private final SerialNumber _serialNumber;
    private final SoftwareVersion _softwareVersion;
    private final DisplaySoftwareVersion _displaySoftwareVersion;
    private final HardwareVersion _hardwareVersion;
    private final IPAddress _iPAddress;
    private final MACAddress _mACAddress;
    private final CopyrightInfo _copyrightInfo;
    private final ExtraInfo _extraInfo;

    public ZoneInfo(
        final SerialNumber serialNumber,
        final SoftwareVersion softwareVersion,
        final DisplaySoftwareVersion displaySoftwareVersion,
        final HardwareVersion hardwareVersion,
        final IPAddress iPAddress,
        final MACAddress mACAddress,
        final CopyrightInfo copyrightInfo,
        final ExtraInfo extraInfo
    ) {
        _serialNumber = serialNumber;
        _softwareVersion = softwareVersion;
        _displaySoftwareVersion = displaySoftwareVersion;
        _hardwareVersion = hardwareVersion;
        _iPAddress = iPAddress;
        _mACAddress = mACAddress;
        _copyrightInfo = copyrightInfo;
        _extraInfo = extraInfo;
    } 

    public SerialNumber getSerialNumber() {
        return _serialNumber;
    }
    public SoftwareVersion getSoftwareVersion() {
        return _softwareVersion;
    }
    public DisplaySoftwareVersion getDisplaySoftwareVersion() {
        return _displaySoftwareVersion;
    }
    public HardwareVersion getHardwareVersion() {
        return _hardwareVersion;
    }
    public IPAddress getIPAddress() {
        return _iPAddress;
    }
    public MACAddress getMACAddress() {
        return _mACAddress;
    }
    public CopyrightInfo getCopyrightInfo() {
        return _copyrightInfo;
    }
    public ExtraInfo getExtraInfo() {
        return _extraInfo;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("serialNumber", _serialNumber)
        .add("softwareVersion", _softwareVersion)
        .add("displaySoftwareVersion", _displaySoftwareVersion)
        .add("hardwareVersion", _hardwareVersion)
        .add("iPAddress", _iPAddress)
        .add("mACAddress", _mACAddress)
        .add("copyrightInfo", _copyrightInfo)
        .add("extraInfo", _extraInfo)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _serialNumber,
            _softwareVersion,
            _displaySoftwareVersion,
            _hardwareVersion,
            _iPAddress,
            _mACAddress,
            _copyrightInfo,
            _extraInfo
        );
    }

    public boolean equals(Object other) {
        if (other instanceof ZoneInfo) {
            ZoneInfo obj = (ZoneInfo)other;
            return 
                    Objects.equal(_serialNumber, obj._serialNumber) &&
                    Objects.equal(_softwareVersion, obj._softwareVersion) &&
                    Objects.equal(_displaySoftwareVersion, obj._displaySoftwareVersion) &&
                    Objects.equal(_hardwareVersion, obj._hardwareVersion) &&
                    Objects.equal(_iPAddress, obj._iPAddress) &&
                    Objects.equal(_mACAddress, obj._mACAddress) &&
                    Objects.equal(_copyrightInfo, obj._copyrightInfo) &&
                    Objects.equal(_extraInfo, obj._extraInfo) 
            ;
        }
        return false;
    }

}
