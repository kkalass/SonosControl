// AUTOGENERATED: d114352f15d3d2002492370eac761966
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public final class SavedQueueTitle implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Function<SavedQueueTitle, String> GET_VALUE = new Function<SavedQueueTitle, String>() {
        @Override
        public String apply(SavedQueueTitle input) {
            return input == null ? null : input.getValue();
        }
    };


    private final String _value;

    private SavedQueueTitle(String value) {
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
        if (other instanceof SavedQueueTitle) {
            SavedQueueTitle obj = (SavedQueueTitle)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static SavedQueueTitle getInstance(String value) {
        if (value != null && "NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        
        return value == null ? null : new SavedQueueTitle(value);
    }
}
