

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AlarmClockService;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

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

@SuppressWarnings("rawtypes")
public final class AlarmClockServiceClingImpl extends AbstractServiceImpl implements AlarmClockService {

    public AlarmClockServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("AlarmClock", upnpService, device, errorStrategy);
    }


    public TimeGeneration getTimeGeneration() {
        throw new UnsupportedOperationException();
    }

    public AlarmListVersion getAlarmListVersion() {
        throw new UnsupportedOperationException();
    }

    public DateFormat getDateFormat() {
        throw new UnsupportedOperationException();
    }

    public TimeServer getTimeServer() {
        throw new UnsupportedOperationException();
    }

    public TimeZone getTimeZone() {
        throw new UnsupportedOperationException();
    }

    public TimeFormat getTimeFormat() {
        throw new UnsupportedOperationException();
    }

    public DailyIndexRefreshTime getDailyIndexRefreshTime() {
        throw new UnsupportedOperationException();
    }


    public <C extends Callback0> C setFormat(final TimeFormat desiredTimeFormat, final DateFormat desiredDateFormat, final C successHandler) {
        return execute(successHandler, new Call<C>("SetFormat") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DesiredTimeFormat", desiredTimeFormat.getValue());
                setInput(invocation,"string", "DesiredDateFormat", desiredDateFormat.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<GetFormatResult>> C retrieveFormat(final C successHandler) {
        return execute(successHandler, new Call<C>("GetFormat") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final TimeFormat value0 = TimeFormat.getInstance(getString("string",output[0].getValue()));
                final DateFormat value1 = DateFormat.getInstance(getString("string",output[1].getValue()));
                final GetFormatResult value = GetFormatResult.getInstance(value0,value1);
                handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setTimeZone(final TimeZoneIndex index, final TimeZoneAutoAdjustDst autoAdjustDst, final C successHandler) {
        return execute(successHandler, new Call<C>("SetTimeZone") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"i4", "Index", index.getValue());
                setInput(invocation,"boolean", "AutoAdjustDst", autoAdjustDst.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<GetTimeZoneResult>> C retrieveTimeZone(final C successHandler) {
        return execute(successHandler, new Call<C>("GetTimeZone") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final TimeZoneIndex value0 = TimeZoneIndex.getInstance(getLong("i4",output[0].getValue()));
                final TimeZoneAutoAdjustDst value1 = TimeZoneAutoAdjustDst.getInstance(getBoolean("boolean",output[1].getValue()));
                final GetTimeZoneResult value = GetTimeZoneResult.getInstance(value0,value1);
                handler.success(value);
            }
        });
    }

    public <C extends Callback1<GetTimeZoneAndRuleResult>> C retrieveTimeZoneAndRule(final C successHandler) {
        return execute(successHandler, new Call<C>("GetTimeZoneAndRule") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final TimeZoneIndex value0 = TimeZoneIndex.getInstance(getLong("i4",output[0].getValue()));
                final TimeZoneAutoAdjustDst value1 = TimeZoneAutoAdjustDst.getInstance(getBoolean("boolean",output[1].getValue()));
                final TimeZone value2 = TimeZone.getInstance(getString("string",output[2].getValue()));
                final GetTimeZoneAndRuleResult value = GetTimeZoneAndRuleResult.getInstance(value0,value1,value2);
                handler.success(value);
            }
        });
    }

    public <C extends Callback1<TimeZone>> C retrieveTimeZoneRule(final TimeZoneIndex index, final C successHandler) {
        return execute(successHandler, new Call<C>("GetTimeZoneRule") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"i4", "Index", index.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final TimeZone value = TimeZone.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setTimeServer(final TimeServer desiredTimeServer, final C successHandler) {
        return execute(successHandler, new Call<C>("SetTimeServer") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DesiredTimeServer", desiredTimeServer.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<TimeServer>> C retrieveTimeServer(final C successHandler) {
        return execute(successHandler, new Call<C>("GetTimeServer") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final TimeServer value = TimeServer.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setTimeNow(final ISO8601Time desiredTime, final TimeZoneInformation timeZoneForDesiredTime, final C successHandler) {
        return execute(successHandler, new Call<C>("SetTimeNow") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DesiredTime", desiredTime.getValue());
                setInput(invocation,"string", "TimeZoneForDesiredTime", timeZoneForDesiredTime.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<ISO8601Time>> C retrieveHouseholdTimeAtStamp(final TimeStamp timeStamp, final C successHandler) {
        return execute(successHandler, new Call<C>("GetHouseholdTimeAtStamp") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "TimeStamp", timeStamp.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final ISO8601Time value = ISO8601Time.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback1<GetTimeNowResult>> C retrieveTimeNow(final C successHandler) {
        return execute(successHandler, new Call<C>("GetTimeNow") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final ISO8601Time value0 = ISO8601Time.getInstance(getString("string",output[0].getValue()));
                final ISO8601Time value1 = ISO8601Time.getInstance(getString("string",output[1].getValue()));
                final TimeZone value2 = TimeZone.getInstance(getString("string",output[2].getValue()));
                final TimeGeneration value3 = TimeGeneration.getInstance(getLong("ui4",output[3].getValue()));
                final GetTimeNowResult value = GetTimeNowResult.getInstance(value0,value1,value2,value3);
                handler.success(value);
            }
        });
    }

    public <C extends Callback1<AlarmID>> C createAlarm(final ISO8601Time startLocalTime, final ISO8601Time duration, final Recurrence recurrence, final AlarmEnabled enabled, final AlarmRoomUUID roomUUID, final AlarmProgramURI programURI, final AlarmProgramMetaData programMetaData, final AlarmPlayMode playMode, final AlarmVolume volume, final AlarmIncludeLinkedZones includeLinkedZones, final C successHandler) {
        return execute(successHandler, new Call<C>("CreateAlarm") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "StartLocalTime", startLocalTime.getValue());
                setInput(invocation,"string", "Duration", duration.getValue());
                setInput(invocation,"string", "Recurrence", recurrence.getValue());
                setInput(invocation,"boolean", "Enabled", enabled.getValue());
                setInput(invocation,"string", "RoomUUID", roomUUID.getValue());
                setInput(invocation,"string", "ProgramURI", programURI.getValue());
                setInput(invocation,"string", "ProgramMetaData", programMetaData.getValue());
                setInput(invocation,"string", "PlayMode", playMode.getValue());
                setInput(invocation,"ui2", "Volume", volume.getValue());
                setInput(invocation,"boolean", "IncludeLinkedZones", includeLinkedZones.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final AlarmID value = AlarmID.getInstance(getLong("ui4",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C updateAlarm(final AlarmID iD, final ISO8601Time startLocalTime, final ISO8601Time duration, final Recurrence recurrence, final AlarmEnabled enabled, final AlarmRoomUUID roomUUID, final AlarmProgramURI programURI, final AlarmProgramMetaData programMetaData, final AlarmPlayMode playMode, final AlarmVolume volume, final AlarmIncludeLinkedZones includeLinkedZones, final C successHandler) {
        return execute(successHandler, new Call<C>("UpdateAlarm") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "ID", iD.getValue());
                setInput(invocation,"string", "StartLocalTime", startLocalTime.getValue());
                setInput(invocation,"string", "Duration", duration.getValue());
                setInput(invocation,"string", "Recurrence", recurrence.getValue());
                setInput(invocation,"boolean", "Enabled", enabled.getValue());
                setInput(invocation,"string", "RoomUUID", roomUUID.getValue());
                setInput(invocation,"string", "ProgramURI", programURI.getValue());
                setInput(invocation,"string", "ProgramMetaData", programMetaData.getValue());
                setInput(invocation,"string", "PlayMode", playMode.getValue());
                setInput(invocation,"ui2", "Volume", volume.getValue());
                setInput(invocation,"boolean", "IncludeLinkedZones", includeLinkedZones.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C destroyAlarm(final AlarmID iD, final C successHandler) {
        return execute(successHandler, new Call<C>("DestroyAlarm") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "ID", iD.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<ListAlarmsResult>> C listAlarms(final C successHandler) {
        return execute(successHandler, new Call<C>("ListAlarms") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final AlarmList value0 = AlarmList.getInstance(getString("string",output[0].getValue()));
                final AlarmListVersion value1 = AlarmListVersion.getInstance(getString("string",output[1].getValue()));
                final ListAlarmsResult value = ListAlarmsResult.getInstance(value0,value1);
                handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setDailyIndexRefreshTime(final DailyIndexRefreshTime desiredDailyIndexRefreshTime, final C successHandler) {
        return execute(successHandler, new Call<C>("SetDailyIndexRefreshTime") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DesiredDailyIndexRefreshTime", desiredDailyIndexRefreshTime.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<DailyIndexRefreshTime>> C retrieveDailyIndexRefreshTime(final C successHandler) {
        return execute(successHandler, new Call<C>("GetDailyIndexRefreshTime") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final DailyIndexRefreshTime value = DailyIndexRefreshTime.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

}
