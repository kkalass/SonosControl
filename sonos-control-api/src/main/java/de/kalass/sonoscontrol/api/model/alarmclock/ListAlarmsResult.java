package de.kalass.sonoscontrol.api.model.alarmclock;

import com.google.common.base.Objects;

public class ListAlarmsResult {
    private final AlarmList _currentAlarmList;
    private final AlarmListVersion _currentAlarmListVersion;

    public ListAlarmsResult(
        AlarmList currentAlarmList,
        AlarmListVersion currentAlarmListVersion
    ) {
        _currentAlarmList = currentAlarmList;
        _currentAlarmListVersion = currentAlarmListVersion;
    }


    public AlarmList getCurrentAlarmList() {
        return _currentAlarmList;
    }

    public AlarmListVersion getCurrentAlarmListVersion() {
        return _currentAlarmListVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _currentAlarmList,
             _currentAlarmListVersion
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ListAlarmsResult) {
            ListAlarmsResult obj = (ListAlarmsResult)other;
            return 
             Objects.equal(_currentAlarmList, obj._currentAlarmList) &&
             Objects.equal(_currentAlarmListVersion, obj._currentAlarmListVersion);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("currentAlarmList",_currentAlarmList)
             .add("currentAlarmListVersion",_currentAlarmListVersion)
             .toString();
    }

}
