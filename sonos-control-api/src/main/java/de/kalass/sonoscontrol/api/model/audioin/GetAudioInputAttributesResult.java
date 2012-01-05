/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetAudioInputAttributesResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final AudioInputName _currentName;
    private final Icon _currentIcon;

    private GetAudioInputAttributesResult(
        final AudioInputName currentName,
        final Icon currentIcon
    ) {
        _currentName = currentName;
        _currentIcon = currentIcon;
    } 

    public static GetAudioInputAttributesResult getInstance(
        final AudioInputName currentName,
        final Icon currentIcon
    ) {
        return new GetAudioInputAttributesResult(currentName, currentIcon);
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
        if (other instanceof GetAudioInputAttributesResult) {
            GetAudioInputAttributesResult obj = (GetAudioInputAttributesResult)other;
            return 
                    Objects.equal(_currentName, obj._currentName) &&
                    Objects.equal(_currentIcon, obj._currentIcon) 
            ;
        }
        return false;
    }

}
