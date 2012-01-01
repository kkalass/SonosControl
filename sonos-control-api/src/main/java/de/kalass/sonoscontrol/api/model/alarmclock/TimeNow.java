package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;

public class TimeNow {
    private final ISO8601Time _currentUTCTime;
    private final ISO8601Time _currentLocalTime;
    private final TimeZone _currentTimeZone;
    private final TimeGeneration _currentTimeGeneration;

    public TimeNow(
        ISO8601Time currentUTCTime,
        ISO8601Time currentLocalTime,
        TimeZone currentTimeZone,
        TimeGeneration currentTimeGeneration
    ) {
        _currentUTCTime = currentUTCTime;
        _currentLocalTime = currentLocalTime;
        _currentTimeZone = currentTimeZone;
        _currentTimeGeneration = currentTimeGeneration;
    }


    public ISO8601Time getCurrentUTCTime() {
        return _currentUTCTime;
    }

    public ISO8601Time getCurrentLocalTime() {
        return _currentLocalTime;
    }

    public TimeZone getCurrentTimeZone() {
        return _currentTimeZone;
    }

    public TimeGeneration getCurrentTimeGeneration() {
        return _currentTimeGeneration;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _currentUTCTime,
             _currentLocalTime,
             _currentTimeZone,
             _currentTimeGeneration
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TimeNow) {
            TimeNow obj = (TimeNow)other;
            return 
             Objects.equal(_currentUTCTime, obj._currentUTCTime) &&
             Objects.equal(_currentLocalTime, obj._currentLocalTime) &&
             Objects.equal(_currentTimeZone, obj._currentTimeZone) &&
             Objects.equal(_currentTimeGeneration, obj._currentTimeGeneration);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("currentUTCTime",_currentUTCTime)
             .add("currentLocalTime",_currentLocalTime)
             .add("currentTimeZone",_currentTimeZone)
             .add("currentTimeGeneration",_currentTimeGeneration)
             .toString();
    }

}
