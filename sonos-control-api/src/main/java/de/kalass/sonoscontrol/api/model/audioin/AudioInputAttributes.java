/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class AudioInputAttributes implements Serializable {
    private static final long serialVersionUID = 1L;

    private final AudioInputName _currentName;
    private final Icon _currentIcon;

    public AudioInputAttributes(
        final AudioInputName currentName,
        final Icon currentIcon
    ) {
        _currentName = currentName;
        _currentIcon = currentIcon;
    } 

    public AudioInputName getCurrentName() {
        return _currentName;
    }
    public Icon getCurrentIcon() {
        return _currentIcon;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("currentName", _currentName)
        .add("currentIcon", _currentIcon)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _currentName,
            _currentIcon
        );
    }

    public boolean equals(Object other) {
        if (other instanceof AudioInputAttributes) {
            AudioInputAttributes obj = (AudioInputAttributes)other;
            return 
                    Objects.equal(_currentName, obj._currentName) &&
                    Objects.equal(_currentIcon, obj._currentIcon) 
            ;
        }
        return false;
    }

}
