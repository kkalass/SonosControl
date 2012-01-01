package de.kalass.sonoscontrol.api.model.audioin;

import com.google.common.base.Objects;

public class LineInLevel {
    private final LeftLineInLevel _currentLeftLineInLevel;
    private final RightLineInLevel _currentRightLineInLevel;

    public LineInLevel(
        LeftLineInLevel currentLeftLineInLevel,
        RightLineInLevel currentRightLineInLevel
    ) {
        _currentLeftLineInLevel = currentLeftLineInLevel;
        _currentRightLineInLevel = currentRightLineInLevel;
    }


    public LeftLineInLevel getCurrentLeftLineInLevel() {
        return _currentLeftLineInLevel;
    }

    public RightLineInLevel getCurrentRightLineInLevel() {
        return _currentRightLineInLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _currentLeftLineInLevel,
             _currentRightLineInLevel
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof LineInLevel) {
            LineInLevel obj = (LineInLevel)other;
            return 
             Objects.equal(_currentLeftLineInLevel, obj._currentLeftLineInLevel) &&
             Objects.equal(_currentRightLineInLevel, obj._currentRightLineInLevel);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("currentLeftLineInLevel",_currentLeftLineInLevel)
             .add("currentRightLineInLevel",_currentRightLineInLevel)
             .toString();
    }

}
