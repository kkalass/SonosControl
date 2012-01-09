// AUTOGENERATED: 563cfb0893104f174c612cb283ca4ea9
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;
import javax.annotation.CheckForNull;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.alarmclock.GetFormatResult;
import de.kalass.sonoscontrol.api.model.alarmclock.GetTimeZoneResult;
import de.kalass.sonoscontrol.api.model.alarmclock.GetTimeZoneAndRuleResult;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZone;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeServer;
import de.kalass.sonoscontrol.api.model.alarmclock.ISO8601Time;
import de.kalass.sonoscontrol.api.model.alarmclock.GetTimeNowResult;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmID;
import de.kalass.sonoscontrol.api.model.alarmclock.ListAlarmsResult;
import de.kalass.sonoscontrol.api.model.alarmclock.DailyIndexRefreshTime;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmRoomUUID;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZoneInformation;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmIncludeLinkedZones;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeGeneration;
import de.kalass.sonoscontrol.api.model.alarmclock.Recurrence;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmListVersion;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmEnabled;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmProgramMetaData;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeStamp;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmVolume;
import de.kalass.sonoscontrol.api.model.alarmclock.DateFormat;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmList;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmProgramURI;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZoneAutoAdjustDst;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmPlayMode;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZoneIndex;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeFormat;

public interface AlarmClockService {


    @CheckForNull
    TimeGeneration getLastValueForTimeGeneration();

    void addTimeGenerationListener(EventListener<TimeGeneration> listener);

    void removeTimeGenerationListener(EventListener<TimeGeneration> listener);

    @CheckForNull
    AlarmListVersion getLastValueForAlarmListVersion();

    void addAlarmListVersionListener(EventListener<AlarmListVersion> listener);

    void removeAlarmListVersionListener(EventListener<AlarmListVersion> listener);

    @CheckForNull
    DateFormat getLastValueForDateFormat();

    void addDateFormatListener(EventListener<DateFormat> listener);

    void removeDateFormatListener(EventListener<DateFormat> listener);

    @CheckForNull
    TimeServer getLastValueForTimeServer();

    void addTimeServerListener(EventListener<TimeServer> listener);

    void removeTimeServerListener(EventListener<TimeServer> listener);

    @CheckForNull
    TimeZone getLastValueForTimeZone();

    void addTimeZoneListener(EventListener<TimeZone> listener);

    void removeTimeZoneListener(EventListener<TimeZone> listener);

    @CheckForNull
    TimeFormat getLastValueForTimeFormat();

    void addTimeFormatListener(EventListener<TimeFormat> listener);

    void removeTimeFormatListener(EventListener<TimeFormat> listener);

    @CheckForNull
    DailyIndexRefreshTime getLastValueForDailyIndexRefreshTime();

    void addDailyIndexRefreshTimeListener(EventListener<DailyIndexRefreshTime> listener);

    void removeDailyIndexRefreshTimeListener(EventListener<DailyIndexRefreshTime> listener);


    <C extends Callback0> C setFormat(TimeFormat desiredTimeFormat, DateFormat desiredDateFormat, C callback);

    <C extends Callback1<GetFormatResult>> C retrieveFormat(C callback);

    <C extends Callback0> C setTimeZone(TimeZoneIndex index, TimeZoneAutoAdjustDst autoAdjustDst, C callback);

    <C extends Callback1<GetTimeZoneResult>> C retrieveTimeZone(C callback);

    <C extends Callback1<GetTimeZoneAndRuleResult>> C retrieveTimeZoneAndRule(C callback);

    <C extends Callback1<TimeZone>> C retrieveTimeZoneRule(TimeZoneIndex index, C callback);

    <C extends Callback0> C setTimeServer(TimeServer desiredTimeServer, C callback);

    <C extends Callback1<TimeServer>> C retrieveTimeServer(C callback);

    <C extends Callback0> C setTimeNow(ISO8601Time desiredTime, TimeZoneInformation timeZoneForDesiredTime, C callback);

    <C extends Callback1<ISO8601Time>> C retrieveHouseholdTimeAtStamp(TimeStamp timeStamp, C callback);

    <C extends Callback1<GetTimeNowResult>> C retrieveTimeNow(C callback);

    <C extends Callback1<AlarmID>> C createAlarm(ISO8601Time startLocalTime, ISO8601Time duration, Recurrence recurrence, AlarmEnabled enabled, AlarmRoomUUID roomUUID, AlarmProgramURI programURI, AlarmProgramMetaData programMetaData, AlarmPlayMode playMode, AlarmVolume volume, AlarmIncludeLinkedZones includeLinkedZones, C callback);

    <C extends Callback0> C updateAlarm(AlarmID iD, ISO8601Time startLocalTime, ISO8601Time duration, Recurrence recurrence, AlarmEnabled enabled, AlarmRoomUUID roomUUID, AlarmProgramURI programURI, AlarmProgramMetaData programMetaData, AlarmPlayMode playMode, AlarmVolume volume, AlarmIncludeLinkedZones includeLinkedZones, C callback);

    <C extends Callback0> C destroyAlarm(AlarmID iD, C callback);

    <C extends Callback1<ListAlarmsResult>> C listAlarms(C callback);

    <C extends Callback0> C setDailyIndexRefreshTime(DailyIndexRefreshTime desiredDailyIndexRefreshTime, C callback);

    <C extends Callback1<DailyIndexRefreshTime>> C retrieveDailyIndexRefreshTime(C callback);

}
