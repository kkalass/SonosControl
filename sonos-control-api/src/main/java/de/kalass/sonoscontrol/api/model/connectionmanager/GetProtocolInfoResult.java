/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.connectionmanager;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetProtocolInfoResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final SourceProtocolInfo _source;
    private final SinkProtocolInfo _sink;

    private GetProtocolInfoResult(
        final SourceProtocolInfo source,
        final SinkProtocolInfo sink
    ) {
        _source = source;
        _sink = sink;
    } 

    public static GetProtocolInfoResult getInstance(
        final SourceProtocolInfo source,
        final SinkProtocolInfo sink
    ) {
        return new GetProtocolInfoResult(source, sink);
    } 
    public SourceProtocolInfo getSource() {
        return _source;
    }
    public SinkProtocolInfo getSink() {
        return _sink;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("source", _source)
        .add("sink", _sink)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _source,
            _sink
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetProtocolInfoResult) {
            GetProtocolInfoResult obj = (GetProtocolInfoResult)other;
            return 
                    Objects.equal(_source, obj._source) &&
                    Objects.equal(_sink, obj._sink) 
            ;
        }
        return false;
    }

}
