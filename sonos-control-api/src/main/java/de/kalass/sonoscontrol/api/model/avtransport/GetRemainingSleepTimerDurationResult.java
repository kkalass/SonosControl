// AUTOGENERATED: deb62c934f047ff3d05e94feacf4b1b4
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetRemainingSleepTimerDurationResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ISO8601Time _remainingSleepTimerDuration;
    private final SleepTimerGeneration _currentSleepTimerGeneration;

    private GetRemainingSleepTimerDurationResult(
        final ISO8601Time remainingSleepTimerDuration,
        final SleepTimerGeneration currentSleepTimerGeneration
    ) {
        _remainingSleepTimerDuration = remainingSleepTimerDuration;
        _currentSleepTimerGeneration = currentSleepTimerGeneration;
    } 

    public static GetRemainingSleepTimerDurationResult getInstance(
        final ISO8601Time remainingSleepTimerDuration,
        final SleepTimerGeneration currentSleepTimerGeneration
    ) {
        return new GetRemainingSleepTimerDurationResult(remainingSleepTimerDuration, currentSleepTimerGeneration);
    } 
    public ISO8601Time getRemainingSleepTimerDuration() {
        return _remainingSleepTimerDuration;
    }
    public SleepTimerGeneration getCurrentSleepTimerGeneration() {
        return _currentSleepTimerGeneration;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("remainingSleepTimerDuration", _remainingSleepTimerDuration)
        .add("currentSleepTimerGeneration", _currentSleepTimerGeneration)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _remainingSleepTimerDuration,
            _currentSleepTimerGeneration
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetRemainingSleepTimerDurationResult) {
            GetRemainingSleepTimerDurationResult obj = (GetRemainingSleepTimerDurationResult)other;
            return 
                    Objects.equal(_remainingSleepTimerDuration, obj._remainingSleepTimerDuration) &&
                    Objects.equal(_currentSleepTimerGeneration, obj._currentSleepTimerGeneration) 
            ;
        }
        return false;
    }

}
