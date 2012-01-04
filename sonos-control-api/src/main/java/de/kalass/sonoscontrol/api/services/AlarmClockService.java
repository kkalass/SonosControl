package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmEnabled;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmID;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmIncludeLinkedZones;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmPlayMode;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmProgramMetaData;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmProgramURI;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmRoomUUID;
import de.kalass.sonoscontrol.api.model.alarmclock.AlarmVolume;
import de.kalass.sonoscontrol.api.model.alarmclock.DailyIndexRefreshTime;
import de.kalass.sonoscontrol.api.model.alarmclock.DateFormat;
import de.kalass.sonoscontrol.api.model.alarmclock.Format;
import de.kalass.sonoscontrol.api.model.alarmclock.ISO8601Time;
import de.kalass.sonoscontrol.api.model.alarmclock.ListAlarmsResult;
import de.kalass.sonoscontrol.api.model.alarmclock.Recurrence;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeFormat;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeNow;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeServer;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeStamp;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZone;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZoneAndRule;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZoneAutoAdjustDst;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZoneIndex;
import de.kalass.sonoscontrol.api.model.alarmclock.TimeZoneInformation;

public interface AlarmClockService {

    public <C extends Callback0> C setFormat(TimeFormat desiredTimeFormat, DateFormat desiredDateFormat, C callback);

    public <C extends Callback1<Format>> C retrieveFormat(C callback);

    public <C extends Callback0> C setTimeZone(TimeZoneIndex index, TimeZoneAutoAdjustDst autoAdjustDst, C callback);

    public <C extends Callback1<TimeZone>> C retrieveTimeZone(C callback);

    public <C extends Callback1<TimeZoneAndRule>> C retrieveTimeZoneAndRule(C callback);

    public <C extends Callback1<TimeZone>> C retrieveTimeZoneRule(TimeZoneIndex index, C callback);

    public <C extends Callback0> C setTimeServer(TimeServer desiredTimeServer, C callback);

    public <C extends Callback1<TimeServer>> C retrieveTimeServer(C callback);

    public <C extends Callback0> C setTimeNow(ISO8601Time desiredTime, TimeZoneInformation timeZoneForDesiredTime, C callback);

    public <C extends Callback1<ISO8601Time>> C retrieveHouseholdTimeAtStamp(TimeStamp timeStamp, C callback);

    public <C extends Callback1<TimeNow>> C retrieveTimeNow(C callback);

    public <C extends Callback1<AlarmID>> C createAlarm(ISO8601Time startLocalTime, ISO8601Time duration, Recurrence recurrence, AlarmEnabled enabled, AlarmRoomUUID roomUUID, AlarmProgramURI programURI, AlarmProgramMetaData programMetaData, AlarmPlayMode playMode, AlarmVolume volume, AlarmIncludeLinkedZones includeLinkedZones, C callback);

    public <C extends Callback0> C updateAlarm(AlarmID iD, ISO8601Time startLocalTime, ISO8601Time duration, Recurrence recurrence, AlarmEnabled enabled, AlarmRoomUUID roomUUID, AlarmProgramURI programURI, AlarmProgramMetaData programMetaData, AlarmPlayMode playMode, AlarmVolume volume, AlarmIncludeLinkedZones includeLinkedZones, C callback);

    public <C extends Callback0> C destroyAlarm(AlarmID iD, C callback);

    public <C extends Callback1<ListAlarmsResult>> C listAlarms(C callback);

    public <C extends Callback0> C setDailyIndexRefreshTime(DailyIndexRefreshTime desiredDailyIndexRefreshTime, C callback);

    public <C extends Callback1<DailyIndexRefreshTime>> C retrieveDailyIndexRefreshTime(C callback);
}
