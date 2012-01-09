// AUTOGENERATED: 595996453cda81f51aaeff5886b676a0
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class NumberOfTracks implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<NumberOfTracks, Long> GET_VALUE = new Function<NumberOfTracks, Long>() {
        @Override
        public Long apply(NumberOfTracks input) {
            return input == null ? null : input.getValue();
        }
    };

    public static final long MIN = 0;
    public static final long MAX = 65535;

    private final Long _value;

    private NumberOfTracks(Long value) {
        _value = Preconditions.checkNotNull(value);
        Preconditions.checkArgument(value.longValue() >= MIN && value.longValue() <= MAX);
    } 

    public Long getValue() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof NumberOfTracks) {
            NumberOfTracks obj = (NumberOfTracks)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static NumberOfTracks getInstance(Long value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new NumberOfTracks(value);
    }
}
