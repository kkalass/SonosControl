package de.kalass.sonoscontrol.api.model.deviceproperties;

import com.google.common.base.Objects;

public class ZoneAttributes {
    private final ZoneName _currentZoneName;
    private final Icon _currentIcon;

    public ZoneAttributes(
        ZoneName currentZoneName,
        Icon currentIcon
    ) {
        _currentZoneName = currentZoneName;
        _currentIcon = currentIcon;
    }


    public ZoneName getCurrentZoneName() {
        return _currentZoneName;
    }

    public Icon getCurrentIcon() {
        return _currentIcon;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _currentZoneName,
             _currentIcon
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ZoneAttributes) {
            ZoneAttributes obj = (ZoneAttributes)other;
            return 
             Objects.equal(_currentZoneName, obj._currentZoneName) &&
             Objects.equal(_currentIcon, obj._currentIcon);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("currentZoneName",_currentZoneName)
             .add("currentIcon",_currentIcon)
             .toString();
    }

}
