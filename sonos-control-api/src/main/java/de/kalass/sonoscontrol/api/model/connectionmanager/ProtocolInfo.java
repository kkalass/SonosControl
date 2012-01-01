package de.kalass.sonoscontrol.api.model.connectionmanager;

import com.google.common.base.Objects;

public class ProtocolInfo {
    private final SourceProtocolInfo _source;
    private final SinkProtocolInfo _sink;

    public ProtocolInfo(
        SourceProtocolInfo source,
        SinkProtocolInfo sink
    ) {
        _source = source;
        _sink = sink;
    }


    public SourceProtocolInfo getSource() {
        return _source;
    }

    public SinkProtocolInfo getSink() {
        return _sink;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _source,
             _sink
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ProtocolInfo) {
            ProtocolInfo obj = (ProtocolInfo)other;
            return 
             Objects.equal(_source, obj._source) &&
             Objects.equal(_sink, obj._sink);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("source",_source)
             .add("sink",_sink)
             .toString();
    }

}
