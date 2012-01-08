/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AVTransportService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.avtransport.AddURIToQueueResult;
import de.kalass.sonoscontrol.api.model.avtransport.ObjectID;
import de.kalass.sonoscontrol.api.model.avtransport.GetMediaInfoResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetTransportInfoResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetPositionInfoResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetDeviceCapabilitiesResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetTransportSettingsResult;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentCrossfadeMode;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTransportActions;
import de.kalass.sonoscontrol.api.model.avtransport.GetRemainingSleepTimerDurationResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetRunningAlarmPropertiesResult;
import de.kalass.sonoscontrol.api.model.avtransport.TransportErrorDescription;
import de.kalass.sonoscontrol.api.model.avtransport.AbsoluteTimePosition;
import de.kalass.sonoscontrol.api.model.avtransport.NextAVTransportURI;
import de.kalass.sonoscontrol.api.model.avtransport.ResumePlayback;
import de.kalass.sonoscontrol.api.model.avtransport.TransportPlaySpeed;
import de.kalass.sonoscontrol.api.model.avtransport.TransportState;
import de.kalass.sonoscontrol.api.model.avtransport.SavedQueueTitle;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTrackURI;
import de.kalass.sonoscontrol.api.model.avtransport.QueueUpdateID;
import de.kalass.sonoscontrol.api.model.avtransport.EnqueueAsNext;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmState;
import de.kalass.sonoscontrol.api.model.avtransport.URI;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmLoggedStartTime;
import de.kalass.sonoscontrol.api.model.avtransport.URIMetaData;
import de.kalass.sonoscontrol.api.model.avtransport.TransportSettings;
import de.kalass.sonoscontrol.api.model.avtransport.PlaybackStorageMedium;
import de.kalass.sonoscontrol.api.model.avtransport.SourceState;
import de.kalass.sonoscontrol.api.model.avtransport.RelativeTimePosition;
import de.kalass.sonoscontrol.api.model.avtransport.TransportErrorURI;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentMediaDuration;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTrackMetaData;
import de.kalass.sonoscontrol.api.model.avtransport.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.avtransport.RelativeCounterPosition;
import de.kalass.sonoscontrol.api.model.avtransport.SeekMode;
import de.kalass.sonoscontrol.api.eventmodels.avtransport.LastAVTransportChange;
import de.kalass.sonoscontrol.api.model.avtransport.ISO8601Time;
import de.kalass.sonoscontrol.api.model.avtransport.PossibleRecordStorageMedia;
import de.kalass.sonoscontrol.api.model.avtransport.StreamRestartState;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTrackDuration;
import de.kalass.sonoscontrol.api.model.avtransport.PossiblePlaybackStorageMedia;
import de.kalass.sonoscontrol.api.model.avtransport.SleepTimerGeneration;
import de.kalass.sonoscontrol.api.model.avtransport.SeekTarget;
import de.kalass.sonoscontrol.api.model.avtransport.AVTransportURIMetaData;
import de.kalass.sonoscontrol.api.model.InstanceID;
import de.kalass.sonoscontrol.api.model.avtransport.NumberOfTracks;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentPlayMode;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.avtransport.RecordStorageMedium;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmIDRunning;
import de.kalass.sonoscontrol.api.model.avtransport.SnoozeRunning;
import de.kalass.sonoscontrol.api.model.avtransport.TransportStatus;
import de.kalass.sonoscontrol.api.model.avtransport.SleepTimerState;
import de.kalass.sonoscontrol.api.model.avtransport.AVTransportURI;
import de.kalass.sonoscontrol.api.model.avtransport.Queue;
import de.kalass.sonoscontrol.api.model.avtransport.NumTracks;
import de.kalass.sonoscontrol.api.model.avtransport.RecordMediumWriteStatus;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmIncludeLinkedZones;
import de.kalass.sonoscontrol.api.model.avtransport.GroupID;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmRunning;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentSection;
import de.kalass.sonoscontrol.api.model.avtransport.MemberList;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmVolume;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTrack;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentAVTransportURI;
import de.kalass.sonoscontrol.api.model.avtransport.RestartPending;
import de.kalass.sonoscontrol.api.model.avtransport.AbsoluteCounterPosition;
import de.kalass.sonoscontrol.api.model.avtransport.NextAVTransportURIMetaData;
import de.kalass.sonoscontrol.api.model.avtransport.PossibleRecordQualityModes;
import de.kalass.sonoscontrol.api.model.avtransport.TrackNumber;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentRecordQualityMode;

public class AVTransportServiceTest extends AbstractSonosServiceTest<AVTransportService> {

    @Override
    protected AVTransportService extractService(SonosDevice device) {
        return device.getAVTransportService();
    }

  @Override
    protected String getServiceName() {
        return "AVTransportService";
    }
    
    @Test
    public void testGetLastChange() {
        final LastAVTransportChange value = getService().getLastValueForLastChange();
        Assert.assertNotNull(value);
        System.out.println("Got LastChange: " + value);
    }






    /*
    @Test
    public void removeAllTracksFromQueueTest() throws Exception{
        getService().removeAllTracksFromQueue(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished removeAllTracksFromQueue");
    }
    */


    @Test
    public void retrieveMediaInfoTest() throws Exception{
        final GetMediaInfoResult value = getService().retrieveMediaInfo(new de.kalass.sonoscontrol.api.core.AsyncValue<GetMediaInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveMediaInfo: " + value);
    }

    @Test
    public void retrieveTransportInfoTest() throws Exception{
        final GetTransportInfoResult value = getService().retrieveTransportInfo(new de.kalass.sonoscontrol.api.core.AsyncValue<GetTransportInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveTransportInfo: " + value);
    }

    @Test
    public void retrievePositionInfoTest() throws Exception{
        final GetPositionInfoResult value = getService().retrievePositionInfo(new de.kalass.sonoscontrol.api.core.AsyncValue<GetPositionInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrievePositionInfo: " + value);
    }

    @Test
    public void retrieveDeviceCapabilitiesTest() throws Exception{
        final GetDeviceCapabilitiesResult value = getService().retrieveDeviceCapabilities(new de.kalass.sonoscontrol.api.core.AsyncValue<GetDeviceCapabilitiesResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveDeviceCapabilities: " + value);
    }

    @Test
    public void retrieveTransportSettingsTest() throws Exception{
        final GetTransportSettingsResult value = getService().retrieveTransportSettings(new de.kalass.sonoscontrol.api.core.AsyncValue<GetTransportSettingsResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveTransportSettings: " + value);
    }

    @Test
    public void retrieveCrossfadeModeTest() throws Exception{
        final CurrentCrossfadeMode value = getService().retrieveCrossfadeMode(new de.kalass.sonoscontrol.api.core.AsyncValue<CurrentCrossfadeMode>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveCrossfadeMode: " + value);
    }

    /*
    @Test
    public void stopTest() throws Exception{
        getService().stop(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished stop");
    }
    */

    /*
    @Test
    public void playTest() throws Exception{
        getService().play(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished play");
    }
    */

    /*
    @Test
    public void pauseTest() throws Exception{
        getService().pause(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished pause");
    }
    */


    /*
    @Test
    public void nextTest() throws Exception{
        getService().next(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished next");
    }
    */

    /*
    @Test
    public void nextProgrammedRadioTracksTest() throws Exception{
        getService().nextProgrammedRadioTracks(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished nextProgrammedRadioTracks");
    }
    */

    /*
    @Test
    public void previousTest() throws Exception{
        getService().previous(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished previous");
    }
    */

    /*
    @Test
    public void nextSectionTest() throws Exception{
        getService().nextSection(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished nextSection");
    }
    */

    /*
    @Test
    public void previousSectionTest() throws Exception{
        getService().previousSection(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished previousSection");
    }
    */




    @Test
    public void retrieveCurrentTransportActionsTest() throws Exception{
        final CurrentTransportActions value = getService().retrieveCurrentTransportActions(new de.kalass.sonoscontrol.api.core.AsyncValue<CurrentTransportActions>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveCurrentTransportActions: " + value);
    }

    /*
    @Test
    public void becomeCoordinatorOfStandaloneGroupTest() throws Exception{
        getService().becomeCoordinatorOfStandaloneGroup(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished becomeCoordinatorOfStandaloneGroup");
    }
    */






    @Test
    public void retrieveRemainingSleepTimerDurationTest() throws Exception{
        final GetRemainingSleepTimerDurationResult value = getService().retrieveRemainingSleepTimerDuration(new de.kalass.sonoscontrol.api.core.AsyncValue<GetRemainingSleepTimerDurationResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveRemainingSleepTimerDuration: " + value);
    }



    @Test
    public void retrieveRunningAlarmPropertiesTest() throws Exception{
        final GetRunningAlarmPropertiesResult value = getService().retrieveRunningAlarmProperties(new de.kalass.sonoscontrol.api.core.AsyncValue<GetRunningAlarmPropertiesResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveRunningAlarmProperties: " + value);
    }

}

