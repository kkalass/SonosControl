package de.kalass.sonoscontrol.api.model.connectionmanager;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class CurrentConnectionInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private final RcsID _rcsID;
    private final AVTransportID _aVTransportID;
    private final ProtocolInfo _protocolInfo;
    private final ConnectionManager _peerConnectionManager;
    private final ConnectionID _peerConnectionID;
    private final Direction _direction;
    private final ConnectionStatus _status;

    public CurrentConnectionInfo(
        final RcsID rcsID,
        final AVTransportID aVTransportID,
        final ProtocolInfo protocolInfo,
        final ConnectionManager peerConnectionManager,
        final ConnectionID peerConnectionID,
        final Direction direction,
        final ConnectionStatus status
    ) {
        _rcsID = rcsID;
        _aVTransportID = aVTransportID;
        _protocolInfo = protocolInfo;
        _peerConnectionManager = peerConnectionManager;
        _peerConnectionID = peerConnectionID;
        _direction = direction;
        _status = status;
    } 

    public RcsID getRcsID() {
        return _rcsID;
    }
    public AVTransportID getAVTransportID() {
        return _aVTransportID;
    }
    public ProtocolInfo getProtocolInfo() {
        return _protocolInfo;
    }
    public ConnectionManager getPeerConnectionManager() {
        return _peerConnectionManager;
    }
    public ConnectionID getPeerConnectionID() {
        return _peerConnectionID;
    }
    public Direction getDirection() {
        return _direction;
    }
    public ConnectionStatus getStatus() {
        return _status;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("rcsID", _rcsID)
        .add("aVTransportID", _aVTransportID)
        .add("protocolInfo", _protocolInfo)
        .add("peerConnectionManager", _peerConnectionManager)
        .add("peerConnectionID", _peerConnectionID)
        .add("direction", _direction)
        .add("status", _status)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _rcsID,
            _aVTransportID,
            _protocolInfo,
            _peerConnectionManager,
            _peerConnectionID,
            _direction,
            _status
        );
    }

    public boolean equals(Object other) {
        if (other instanceof CurrentConnectionInfo) {
            CurrentConnectionInfo obj = (CurrentConnectionInfo)other;
            return 
                    Objects.equal(_rcsID, obj._rcsID) &&
                    Objects.equal(_aVTransportID, obj._aVTransportID) &&
                    Objects.equal(_protocolInfo, obj._protocolInfo) &&
                    Objects.equal(_peerConnectionManager, obj._peerConnectionManager) &&
                    Objects.equal(_peerConnectionID, obj._peerConnectionID) &&
                    Objects.equal(_direction, obj._direction) &&
                    Objects.equal(_status, obj._status) 
            ;
        }
        return false;
    }

}
