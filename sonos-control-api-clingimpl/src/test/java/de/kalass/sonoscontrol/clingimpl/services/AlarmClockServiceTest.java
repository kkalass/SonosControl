/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AlarmClockService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

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

public class AlarmClockServiceTest extends AbstractSonosServiceTest<AlarmClockService> {

    @Override
    protected AlarmClockService extractService(SonosDevice device) {
        return device.getAlarmClockService();
    }

    @Test
    public void testTimeGeneration() {
        final TimeGeneration value = getService().getTimeGeneration();
        Assert.assertNotNull(value);
        System.out.println("Got TimeGeneration: " + value);
    }
    @Test
    public void testAlarmListVersion() {
        final AlarmListVersion value = getService().getAlarmListVersion();
        Assert.assertNotNull(value);
        System.out.println("Got AlarmListVersion: " + value);
    }
    @Test
    public void testDateFormat() {
        final DateFormat value = getService().getDateFormat();
        Assert.assertNotNull(value);
        System.out.println("Got DateFormat: " + value);
    }
    @Test
    public void testTimeServer() {
        final TimeServer value = getService().getTimeServer();
        Assert.assertNotNull(value);
        System.out.println("Got TimeServer: " + value);
    }
    @Test
    public void testTimeZone() {
        final TimeZone value = getService().getTimeZone();
        Assert.assertNotNull(value);
        System.out.println("Got TimeZone: " + value);
    }
    @Test
    public void testTimeFormat() {
        final TimeFormat value = getService().getTimeFormat();
        Assert.assertNotNull(value);
        System.out.println("Got TimeFormat: " + value);
    }
    @Test
    public void testDailyIndexRefreshTime() {
        final DailyIndexRefreshTime value = getService().getDailyIndexRefreshTime();
        Assert.assertNotNull(value);
        System.out.println("Got DailyIndexRefreshTime: " + value);
    }

}

