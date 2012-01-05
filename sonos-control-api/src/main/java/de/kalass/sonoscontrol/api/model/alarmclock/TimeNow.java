package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class TimeNow implements Serializable {
    private static final long serialVersionUID = 1L;

	private final ISO8601Time _currentUTCTime;
	private final ISO8601Time _currentLocalTime;
	private final TimeZone _currentTimeZone;
	private final TimeGeneration _currentTimeGeneration;

    public TimeNow(
		final ISO8601Time currentUTCTime,
		final ISO8601Time currentLocalTime,
		final TimeZone currentTimeZone,
		final TimeGeneration currentTimeGeneration
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

    public String toString() {
        return Objects.toStringHelper(this)
		.add("currentUTCTime", _currentUTCTime)
		.add("currentLocalTime", _currentLocalTime)
		.add("currentTimeZone", _currentTimeZone)
		.add("currentTimeGeneration", _currentTimeGeneration)
        .toString();
    }
    
    public int hashCode() {
        return Objects.hashCode(
			_currentUTCTime,
			_currentLocalTime,
			_currentTimeZone,
			_currentTimeGeneration
        );
    }

    public boolean equals(Object other) {
        if (other instanceof TimeNow) {
            TimeNow obj = (TimeNow)other;
            return 
					Objects.equal(_currentUTCTime, obj._currentUTCTime) &&
					Objects.equal(_currentLocalTime, obj._currentLocalTime) &&
					Objects.equal(_currentTimeZone, obj._currentTimeZone) &&
					Objects.equal(_currentTimeGeneration, obj._currentTimeGeneration) 
            ;
        }
        return false;
    }

}
