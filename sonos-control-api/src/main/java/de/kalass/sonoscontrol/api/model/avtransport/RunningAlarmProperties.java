package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;

public class RunningAlarmProperties {
    private final AlarmIDRunning _alarmID;
    private final GroupID _groupID;
    private final AlarmLoggedStartTime _loggedStartTime;

    public RunningAlarmProperties(
        AlarmIDRunning alarmID,
        GroupID groupID,
        AlarmLoggedStartTime loggedStartTime
    ) {
        _alarmID = alarmID;
        _groupID = groupID;
        _loggedStartTime = loggedStartTime;
    }


    public AlarmIDRunning getAlarmID() {
        return _alarmID;
    }

    public GroupID getGroupID() {
        return _groupID;
    }

    public AlarmLoggedStartTime getLoggedStartTime() {
        return _loggedStartTime;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _alarmID,
             _groupID,
             _loggedStartTime
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof RunningAlarmProperties) {
            RunningAlarmProperties obj = (RunningAlarmProperties)other;
            return 
             Objects.equal(_alarmID, obj._alarmID) &&
             Objects.equal(_groupID, obj._groupID) &&
             Objects.equal(_loggedStartTime, obj._loggedStartTime);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("alarmID",_alarmID)
             .add("groupID",_groupID)
             .add("loggedStartTime",_loggedStartTime)
             .toString();
    }

}
