/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class TransportInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private final TransportState _currentTransportState;
    private final TransportStatus _currentTransportStatus;
    private final TransportPlaySpeed _currentSpeed;

    public TransportInfo(
        final TransportState currentTransportState,
        final TransportStatus currentTransportStatus,
        final TransportPlaySpeed currentSpeed
    ) {
        _currentTransportState = currentTransportState;
        _currentTransportStatus = currentTransportStatus;
        _currentSpeed = currentSpeed;
    } 

    public TransportState getCurrentTransportState() {
        return _currentTransportState;
    }
    public TransportStatus getCurrentTransportStatus() {
        return _currentTransportStatus;
    }
    public TransportPlaySpeed getCurrentSpeed() {
        return _currentSpeed;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("currentTransportState", _currentTransportState)
        .add("currentTransportStatus", _currentTransportStatus)
        .add("currentSpeed", _currentSpeed)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _currentTransportState,
            _currentTransportStatus,
            _currentSpeed
        );
    }

    public boolean equals(Object other) {
        if (other instanceof TransportInfo) {
            TransportInfo obj = (TransportInfo)other;
            return 
                    Objects.equal(_currentTransportState, obj._currentTransportState) &&
                    Objects.equal(_currentTransportStatus, obj._currentTransportStatus) &&
                    Objects.equal(_currentSpeed, obj._currentSpeed) 
            ;
        }
        return false;
    }

}
