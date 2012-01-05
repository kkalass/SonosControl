package de.kalass.sonoscontrol.api.model.deviceproperties;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class ZoneAttributes implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ZoneName _currentZoneName;
    private final Icon _currentIcon;

    public ZoneAttributes(
        final ZoneName currentZoneName,
        final Icon currentIcon
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

    public String toString() {
        return Objects.toStringHelper(this)
        .add("currentZoneName", _currentZoneName)
        .add("currentIcon", _currentIcon)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _currentZoneName,
            _currentIcon
        );
    }

    public boolean equals(Object other) {
        if (other instanceof ZoneAttributes) {
            ZoneAttributes obj = (ZoneAttributes)other;
            return 
                    Objects.equal(_currentZoneName, obj._currentZoneName) &&
                    Objects.equal(_currentIcon, obj._currentIcon) 
            ;
        }
        return false;
    }

}
