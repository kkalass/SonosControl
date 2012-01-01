package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;

public class AudioInputAttributes {
    private final AudioInputName _currentName;
    private final Icon _currentIcon;

    public AudioInputAttributes(
        AudioInputName currentName,
        Icon currentIcon
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

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _currentName,
             _currentIcon
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AudioInputAttributes) {
            AudioInputAttributes obj = (AudioInputAttributes)other;
            return 
             Objects.equal(_currentName, obj._currentName) &&
             Objects.equal(_currentIcon, obj._currentIcon);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("currentName",_currentName)
             .add("currentIcon",_currentIcon)
             .toString();
    }

}
