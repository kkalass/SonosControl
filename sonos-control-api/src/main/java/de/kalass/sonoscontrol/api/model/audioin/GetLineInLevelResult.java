/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetLineInLevelResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final LeftLineInLevel _currentLeftLineInLevel;
    private final RightLineInLevel _currentRightLineInLevel;

    private GetLineInLevelResult(
        final LeftLineInLevel currentLeftLineInLevel,
        final RightLineInLevel currentRightLineInLevel
    ) {
        _currentLeftLineInLevel = currentLeftLineInLevel;
        _currentRightLineInLevel = currentRightLineInLevel;
    } 

    public static GetLineInLevelResult getInstance(
        final LeftLineInLevel currentLeftLineInLevel,
        final RightLineInLevel currentRightLineInLevel
    ) {
        return new GetLineInLevelResult(currentLeftLineInLevel, currentRightLineInLevel);
    } 
    public LeftLineInLevel getCurrentLeftLineInLevel() {
        return _currentLeftLineInLevel;
    }
    public RightLineInLevel getCurrentRightLineInLevel() {
        return _currentRightLineInLevel;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("currentLeftLineInLevel", _currentLeftLineInLevel)
        .add("currentRightLineInLevel", _currentRightLineInLevel)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _currentLeftLineInLevel,
            _currentRightLineInLevel
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetLineInLevelResult) {
            GetLineInLevelResult obj = (GetLineInLevelResult)other;
            return 
                    Objects.equal(_currentLeftLineInLevel, obj._currentLeftLineInLevel) &&
                    Objects.equal(_currentRightLineInLevel, obj._currentRightLineInLevel) 
            ;
        }
        return false;
    }

}
