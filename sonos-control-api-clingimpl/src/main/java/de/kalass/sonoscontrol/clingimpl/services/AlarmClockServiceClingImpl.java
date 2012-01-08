/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AlarmClockService;
import de.kalass.sonoscontrol.api.core.EventListener;

import org.teleal.cling.model.gena.GENASubscription;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.state.StateVariableValue;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.google.common.base.Objects;

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
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AlarmClockServiceClingImpl.class);
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();
    
    private final List<EventListener<TimeGeneration>> _changeTimeGenerationListeners = new ArrayList<EventListener<TimeGeneration>>();
    private final List<EventListener<AlarmListVersion>> _changeAlarmListVersionListeners = new ArrayList<EventListener<AlarmListVersion>>();
    private final List<EventListener<DateFormat>> _changeDateFormatListeners = new ArrayList<EventListener<DateFormat>>();
    private final List<EventListener<TimeServer>> _changeTimeServerListeners = new ArrayList<EventListener<TimeServer>>();
    private final List<EventListener<TimeZone>> _changeTimeZoneListeners = new ArrayList<EventListener<TimeZone>>();
    private final List<EventListener<TimeFormat>> _changeTimeFormatListeners = new ArrayList<EventListener<TimeFormat>>();
    private final List<EventListener<DailyIndexRefreshTime>> _changeDailyIndexRefreshTimeListeners = new ArrayList<EventListener<DailyIndexRefreshTime>>();

    public AlarmClockServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("AlarmClock", upnpService, device, errorStrategy);
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
                final TimeFormat currentTimeFormat = TimeFormat.getInstance((String)getValue("string",output[0].getValue()));
                final DateFormat currentDateFormat = DateFormat.getInstance((String)getValue("string",output[1].getValue()));
                final GetFormatResult value = GetFormatResult.getInstance(currentTimeFormat,currentDateFormat);
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
                final TimeZoneIndex index = TimeZoneIndex.getInstance((Long)getValue("i4",output[0].getValue()));
                final TimeZoneAutoAdjustDst autoAdjustDst = TimeZoneAutoAdjustDst.getInstance((Boolean)getValue("boolean",output[1].getValue()));
                final GetTimeZoneResult value = GetTimeZoneResult.getInstance(index,autoAdjustDst);
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
                final TimeZoneIndex index = TimeZoneIndex.getInstance((Long)getValue("i4",output[0].getValue()));
                final TimeZoneAutoAdjustDst autoAdjustDst = TimeZoneAutoAdjustDst.getInstance((Boolean)getValue("boolean",output[1].getValue()));
                final TimeZone currentTimeZone = TimeZone.getInstance((String)getValue("string",output[2].getValue()));
                final GetTimeZoneAndRuleResult value = GetTimeZoneAndRuleResult.getInstance(index,autoAdjustDst,currentTimeZone);
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
                 final TimeZone value = TimeZone.getInstance((String)getValue("string",output[0].getValue()));
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
                 final TimeServer value = TimeServer.getInstance((String)getValue("string",output[0].getValue()));
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
                 final ISO8601Time value = ISO8601Time.getInstance((String)getValue("string",output[0].getValue()));
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
                final ISO8601Time currentUTCTime = ISO8601Time.getInstance((String)getValue("string",output[0].getValue()));
                final ISO8601Time currentLocalTime = ISO8601Time.getInstance((String)getValue("string",output[1].getValue()));
                final TimeZone currentTimeZone = TimeZone.getInstance((String)getValue("string",output[2].getValue()));
                final TimeGeneration currentTimeGeneration = TimeGeneration.getInstance((Long)getValue("ui4",output[3].getValue()));
                final GetTimeNowResult value = GetTimeNowResult.getInstance(currentUTCTime,currentLocalTime,currentTimeZone,currentTimeGeneration);
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
                 final AlarmID value = AlarmID.getInstance((Long)getValue("ui4",output[0].getValue()));
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
                final AlarmList currentAlarmList = AlarmList.getInstance((String)getValue("string",output[0].getValue()));
                final AlarmListVersion currentAlarmListVersion = AlarmListVersion.getInstance((String)getValue("string",output[1].getValue()));
                final ListAlarmsResult value = ListAlarmsResult.getInstance(currentAlarmList,currentAlarmListVersion);
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
                 final DailyIndexRefreshTime value = DailyIndexRefreshTime.getInstance((String)getValue("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        TimeGeneration newTimeGeneration = null;
        TimeGeneration oldTimeGeneration = (TimeGeneration)stored.get("TimeGeneration");
        try {
        newTimeGeneration = convertTimeGeneration((Long)getValue("ui4", ((StateVariableValue)values.get("TimeGeneration")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for TimeGeneration, will ignore", e);
            // make sure the value is not changed/overridden
            newTimeGeneration = null;
            oldTimeGeneration = null;
        }
        if (!Objects.equal(oldTimeGeneration, newTimeGeneration)) {
            _eventedValues.put("TimeGeneration", newTimeGeneration);
        }

        AlarmListVersion newAlarmListVersion = null;
        AlarmListVersion oldAlarmListVersion = (AlarmListVersion)stored.get("AlarmListVersion");
        try {
        newAlarmListVersion = convertAlarmListVersion((String)getValue("string", ((StateVariableValue)values.get("AlarmListVersion")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for AlarmListVersion, will ignore", e);
            // make sure the value is not changed/overridden
            newAlarmListVersion = null;
            oldAlarmListVersion = null;
        }
        if (!Objects.equal(oldAlarmListVersion, newAlarmListVersion)) {
            _eventedValues.put("AlarmListVersion", newAlarmListVersion);
        }

        DateFormat newDateFormat = null;
        DateFormat oldDateFormat = (DateFormat)stored.get("DateFormat");
        try {
        newDateFormat = convertDateFormat((String)getValue("string", ((StateVariableValue)values.get("DateFormat")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for DateFormat, will ignore", e);
            // make sure the value is not changed/overridden
            newDateFormat = null;
            oldDateFormat = null;
        }
        if (!Objects.equal(oldDateFormat, newDateFormat)) {
            _eventedValues.put("DateFormat", newDateFormat);
        }

        TimeServer newTimeServer = null;
        TimeServer oldTimeServer = (TimeServer)stored.get("TimeServer");
        try {
        newTimeServer = convertTimeServer((String)getValue("string", ((StateVariableValue)values.get("TimeServer")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for TimeServer, will ignore", e);
            // make sure the value is not changed/overridden
            newTimeServer = null;
            oldTimeServer = null;
        }
        if (!Objects.equal(oldTimeServer, newTimeServer)) {
            _eventedValues.put("TimeServer", newTimeServer);
        }

        TimeZone newTimeZone = null;
        TimeZone oldTimeZone = (TimeZone)stored.get("TimeZone");
        try {
        newTimeZone = convertTimeZone((String)getValue("string", ((StateVariableValue)values.get("TimeZone")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for TimeZone, will ignore", e);
            // make sure the value is not changed/overridden
            newTimeZone = null;
            oldTimeZone = null;
        }
        if (!Objects.equal(oldTimeZone, newTimeZone)) {
            _eventedValues.put("TimeZone", newTimeZone);
        }

        TimeFormat newTimeFormat = null;
        TimeFormat oldTimeFormat = (TimeFormat)stored.get("TimeFormat");
        try {
        newTimeFormat = convertTimeFormat((String)getValue("string", ((StateVariableValue)values.get("TimeFormat")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for TimeFormat, will ignore", e);
            // make sure the value is not changed/overridden
            newTimeFormat = null;
            oldTimeFormat = null;
        }
        if (!Objects.equal(oldTimeFormat, newTimeFormat)) {
            _eventedValues.put("TimeFormat", newTimeFormat);
        }

        DailyIndexRefreshTime newDailyIndexRefreshTime = null;
        DailyIndexRefreshTime oldDailyIndexRefreshTime = (DailyIndexRefreshTime)stored.get("DailyIndexRefreshTime");
        try {
        newDailyIndexRefreshTime = convertDailyIndexRefreshTime((String)getValue("string", ((StateVariableValue)values.get("DailyIndexRefreshTime")).getValue()));
        } catch(RuntimeException e) {
            LOG.error("failed to read new value for DailyIndexRefreshTime, will ignore", e);
            // make sure the value is not changed/overridden
            newDailyIndexRefreshTime = null;
            oldDailyIndexRefreshTime = null;
        }
        if (!Objects.equal(oldDailyIndexRefreshTime, newDailyIndexRefreshTime)) {
            _eventedValues.put("DailyIndexRefreshTime", newDailyIndexRefreshTime);
        }

        // after the values were updated, send the change notifications

        if (!Objects.equal(oldTimeGeneration, newTimeGeneration)) {
            notifyTimeGenerationChanged(oldTimeGeneration, newTimeGeneration);
        }

        if (!Objects.equal(oldAlarmListVersion, newAlarmListVersion)) {
            notifyAlarmListVersionChanged(oldAlarmListVersion, newAlarmListVersion);
        }

        if (!Objects.equal(oldDateFormat, newDateFormat)) {
            notifyDateFormatChanged(oldDateFormat, newDateFormat);
        }

        if (!Objects.equal(oldTimeServer, newTimeServer)) {
            notifyTimeServerChanged(oldTimeServer, newTimeServer);
        }

        if (!Objects.equal(oldTimeZone, newTimeZone)) {
            notifyTimeZoneChanged(oldTimeZone, newTimeZone);
        }

        if (!Objects.equal(oldTimeFormat, newTimeFormat)) {
            notifyTimeFormatChanged(oldTimeFormat, newTimeFormat);
        }

        if (!Objects.equal(oldDailyIndexRefreshTime, newDailyIndexRefreshTime)) {
            notifyDailyIndexRefreshTimeChanged(oldDailyIndexRefreshTime, newDailyIndexRefreshTime);
        }
    }

    protected Object getEventedValueOrWait(String key) {
        try {
            _eventsReceivedLatch.await();
        } catch (InterruptedException e) {
            LOG.warn("waiting for evented value countdown latch was interrupted, will continue");
        }
        return _eventedValues.get(key);
    }

    
    
    
    

    public TimeGeneration getTimeGeneration() {
        return (TimeGeneration)getEventedValueOrWait("TimeGeneration");
    }

    public void addTimeGenerationListener(EventListener<TimeGeneration> listener) {
        synchronized(_changeTimeGenerationListeners) {
            _changeTimeGenerationListeners.add(listener);
        }
    }

    public void removeTimeGenerationListener(EventListener<TimeGeneration> listener) {
        synchronized(_changeTimeGenerationListeners) {
            _changeTimeGenerationListeners.remove(listener);
        }
    }

    protected void notifyTimeGenerationChanged(TimeGeneration oldValue, TimeGeneration newValue) {
        final Iterable<EventListener<TimeGeneration>> listeners;
        synchronized(_changeTimeGenerationListeners) {
            listeners = new ArrayList<EventListener<TimeGeneration>>(_changeTimeGenerationListeners);            
        }
        for(EventListener<TimeGeneration> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  TimeGeneration convertTimeGeneration(Long rawValue) {
        return TimeGeneration.getInstance(rawValue);
    }
    
    

    public AlarmListVersion getAlarmListVersion() {
        return (AlarmListVersion)getEventedValueOrWait("AlarmListVersion");
    }

    public void addAlarmListVersionListener(EventListener<AlarmListVersion> listener) {
        synchronized(_changeAlarmListVersionListeners) {
            _changeAlarmListVersionListeners.add(listener);
        }
    }

    public void removeAlarmListVersionListener(EventListener<AlarmListVersion> listener) {
        synchronized(_changeAlarmListVersionListeners) {
            _changeAlarmListVersionListeners.remove(listener);
        }
    }

    protected void notifyAlarmListVersionChanged(AlarmListVersion oldValue, AlarmListVersion newValue) {
        final Iterable<EventListener<AlarmListVersion>> listeners;
        synchronized(_changeAlarmListVersionListeners) {
            listeners = new ArrayList<EventListener<AlarmListVersion>>(_changeAlarmListVersionListeners);            
        }
        for(EventListener<AlarmListVersion> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  AlarmListVersion convertAlarmListVersion(String rawValue) {
        return AlarmListVersion.getInstance(rawValue);
    }
    
    
    
    

    public DateFormat getDateFormat() {
        return (DateFormat)getEventedValueOrWait("DateFormat");
    }

    public void addDateFormatListener(EventListener<DateFormat> listener) {
        synchronized(_changeDateFormatListeners) {
            _changeDateFormatListeners.add(listener);
        }
    }

    public void removeDateFormatListener(EventListener<DateFormat> listener) {
        synchronized(_changeDateFormatListeners) {
            _changeDateFormatListeners.remove(listener);
        }
    }

    protected void notifyDateFormatChanged(DateFormat oldValue, DateFormat newValue) {
        final Iterable<EventListener<DateFormat>> listeners;
        synchronized(_changeDateFormatListeners) {
            listeners = new ArrayList<EventListener<DateFormat>>(_changeDateFormatListeners);            
        }
        for(EventListener<DateFormat> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  DateFormat convertDateFormat(String rawValue) {
        return DateFormat.getInstance(rawValue);
    }
    
    

    public TimeServer getTimeServer() {
        return (TimeServer)getEventedValueOrWait("TimeServer");
    }

    public void addTimeServerListener(EventListener<TimeServer> listener) {
        synchronized(_changeTimeServerListeners) {
            _changeTimeServerListeners.add(listener);
        }
    }

    public void removeTimeServerListener(EventListener<TimeServer> listener) {
        synchronized(_changeTimeServerListeners) {
            _changeTimeServerListeners.remove(listener);
        }
    }

    protected void notifyTimeServerChanged(TimeServer oldValue, TimeServer newValue) {
        final Iterable<EventListener<TimeServer>> listeners;
        synchronized(_changeTimeServerListeners) {
            listeners = new ArrayList<EventListener<TimeServer>>(_changeTimeServerListeners);            
        }
        for(EventListener<TimeServer> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  TimeServer convertTimeServer(String rawValue) {
        return TimeServer.getInstance(rawValue);
    }
    

    public TimeZone getTimeZone() {
        return (TimeZone)getEventedValueOrWait("TimeZone");
    }

    public void addTimeZoneListener(EventListener<TimeZone> listener) {
        synchronized(_changeTimeZoneListeners) {
            _changeTimeZoneListeners.add(listener);
        }
    }

    public void removeTimeZoneListener(EventListener<TimeZone> listener) {
        synchronized(_changeTimeZoneListeners) {
            _changeTimeZoneListeners.remove(listener);
        }
    }

    protected void notifyTimeZoneChanged(TimeZone oldValue, TimeZone newValue) {
        final Iterable<EventListener<TimeZone>> listeners;
        synchronized(_changeTimeZoneListeners) {
            listeners = new ArrayList<EventListener<TimeZone>>(_changeTimeZoneListeners);            
        }
        for(EventListener<TimeZone> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  TimeZone convertTimeZone(String rawValue) {
        return TimeZone.getInstance(rawValue);
    }
    
    

    public TimeFormat getTimeFormat() {
        return (TimeFormat)getEventedValueOrWait("TimeFormat");
    }

    public void addTimeFormatListener(EventListener<TimeFormat> listener) {
        synchronized(_changeTimeFormatListeners) {
            _changeTimeFormatListeners.add(listener);
        }
    }

    public void removeTimeFormatListener(EventListener<TimeFormat> listener) {
        synchronized(_changeTimeFormatListeners) {
            _changeTimeFormatListeners.remove(listener);
        }
    }

    protected void notifyTimeFormatChanged(TimeFormat oldValue, TimeFormat newValue) {
        final Iterable<EventListener<TimeFormat>> listeners;
        synchronized(_changeTimeFormatListeners) {
            listeners = new ArrayList<EventListener<TimeFormat>>(_changeTimeFormatListeners);            
        }
        for(EventListener<TimeFormat> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  TimeFormat convertTimeFormat(String rawValue) {
        return TimeFormat.getInstance(rawValue);
    }

    public DailyIndexRefreshTime getDailyIndexRefreshTime() {
        return (DailyIndexRefreshTime)getEventedValueOrWait("DailyIndexRefreshTime");
    }

    public void addDailyIndexRefreshTimeListener(EventListener<DailyIndexRefreshTime> listener) {
        synchronized(_changeDailyIndexRefreshTimeListeners) {
            _changeDailyIndexRefreshTimeListeners.add(listener);
        }
    }

    public void removeDailyIndexRefreshTimeListener(EventListener<DailyIndexRefreshTime> listener) {
        synchronized(_changeDailyIndexRefreshTimeListeners) {
            _changeDailyIndexRefreshTimeListeners.remove(listener);
        }
    }

    protected void notifyDailyIndexRefreshTimeChanged(DailyIndexRefreshTime oldValue, DailyIndexRefreshTime newValue) {
        final Iterable<EventListener<DailyIndexRefreshTime>> listeners;
        synchronized(_changeDailyIndexRefreshTimeListeners) {
            listeners = new ArrayList<EventListener<DailyIndexRefreshTime>>(_changeDailyIndexRefreshTimeListeners);            
        }
        for(EventListener<DailyIndexRefreshTime> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  DailyIndexRefreshTime convertDailyIndexRefreshTime(String rawValue) {
        return DailyIndexRefreshTime.getInstance(rawValue);
    }
}
