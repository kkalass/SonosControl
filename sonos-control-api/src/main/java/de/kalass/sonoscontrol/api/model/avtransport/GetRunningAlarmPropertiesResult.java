/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class GetRunningAlarmPropertiesResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final AlarmIDRunning _alarmID;
    private final GroupID _groupID;
    private final AlarmLoggedStartTime _loggedStartTime;

    private GetRunningAlarmPropertiesResult(
        final AlarmIDRunning alarmID,
        final GroupID groupID,
        final AlarmLoggedStartTime loggedStartTime
    ) {
        _alarmID = alarmID;
        _groupID = groupID;
        _loggedStartTime = loggedStartTime;
    } 

    public static GetRunningAlarmPropertiesResult getInstance(
        final AlarmIDRunning alarmID,
        final GroupID groupID,
        final AlarmLoggedStartTime loggedStartTime
    ) {
        return new GetRunningAlarmPropertiesResult(alarmID, groupID, loggedStartTime);
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

    public String toString() {
        return Objects.toStringHelper(this)
        .add("alarmID", _alarmID)
        .add("groupID", _groupID)
        .add("loggedStartTime", _loggedStartTime)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _alarmID,
            _groupID,
            _loggedStartTime
        );
    }

    public boolean equals(Object other) {
        if (other instanceof GetRunningAlarmPropertiesResult) {
            GetRunningAlarmPropertiesResult obj = (GetRunningAlarmPropertiesResult)other;
            return 
                    Objects.equal(_alarmID, obj._alarmID) &&
                    Objects.equal(_groupID, obj._groupID) &&
                    Objects.equal(_loggedStartTime, obj._loggedStartTime) 
            ;
        }
        return false;
    }

}