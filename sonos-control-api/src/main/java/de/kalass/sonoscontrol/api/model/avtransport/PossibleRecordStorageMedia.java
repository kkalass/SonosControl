// AUTOGENERATED: e07fdd718ce151bd15b6576d0f3f3a5a
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class PossibleRecordStorageMedia implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<PossibleRecordStorageMedia, String> GET_VALUE = new Function<PossibleRecordStorageMedia, String>() {
        @Override
        public String apply(PossibleRecordStorageMedia input) {
            return input == null ? null : input.getValue();
        }
    };


    private final String _value;

    private PossibleRecordStorageMedia(String value) {
        _value = Preconditions.checkNotNull(value);
    } 

    public String getValue() {
        return _value;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof PossibleRecordStorageMedia) {
            PossibleRecordStorageMedia obj = (PossibleRecordStorageMedia)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static PossibleRecordStorageMedia getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new PossibleRecordStorageMedia(value);
    }
}
