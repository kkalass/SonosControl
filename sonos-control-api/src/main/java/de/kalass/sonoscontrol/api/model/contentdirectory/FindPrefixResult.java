// AUTOGENERATED: 43678a478083eb35af4d7f19c4d45956
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.contentdirectory;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class FindPrefixResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Index _startingIndex;
    private final UpdateID _updateID;

    private FindPrefixResult(
        final Index startingIndex,
        final UpdateID updateID
    ) {
        _startingIndex = startingIndex;
        _updateID = updateID;
    } 

    public static FindPrefixResult getInstance(
        final Index startingIndex,
        final UpdateID updateID
    ) {
        return new FindPrefixResult(startingIndex, updateID);
    } 
    public Index getStartingIndex() {
        return _startingIndex;
    }
    public UpdateID getUpdateID() {
        return _updateID;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("startingIndex", _startingIndex)
        .add("updateID", _updateID)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _startingIndex,
            _updateID
        );
    }

    public boolean equals(Object other) {
        if (other instanceof FindPrefixResult) {
            FindPrefixResult obj = (FindPrefixResult)other;
            return 
                    Objects.equal(_startingIndex, obj._startingIndex) &&
                    Objects.equal(_updateID, obj._updateID) 
            ;
        }
        return false;
    }

}
