package de.kalass.sonoscontrol.api.model.renderingcontrol;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class VolumeDBRange implements Serializable {
    private static final long serialVersionUID = 1L;

    private final VolumeDB _minValue;
    private final VolumeDB _maxValue;

    public VolumeDBRange(
        final VolumeDB minValue,
        final VolumeDB maxValue
    ) {
        _minValue = minValue;
        _maxValue = maxValue;
    } 

    public VolumeDB getMinValue() {
        return _minValue;
    }
    public VolumeDB getMaxValue() {
        return _maxValue;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("minValue", _minValue)
        .add("maxValue", _maxValue)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _minValue,
            _maxValue
        );
    }

    public boolean equals(Object other) {
        if (other instanceof VolumeDBRange) {
            VolumeDBRange obj = (VolumeDBRange)other;
            return 
                    Objects.equal(_minValue, obj._minValue) &&
                    Objects.equal(_maxValue, obj._maxValue) 
            ;
        }
        return false;
    }

}
