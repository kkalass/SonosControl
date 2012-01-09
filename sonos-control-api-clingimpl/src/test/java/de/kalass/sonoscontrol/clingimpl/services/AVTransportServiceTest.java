// AUTOGENERATED: c0deeee0e801744a96a222c464303f31
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AVTransportService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.core.VoidCallback;
import de.kalass.sonoscontrol.api.core.AsyncValue;
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
import de.kalass.sonoscontrol.api.model.avtransport.LastChange;
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
        final LastChange value = getService().getLastValueForLastChange();
        Assert.assertNotNull(value);
        System.out.println("Got LastChange: " + value);
    }


    /*
    @Test
    public void setAVTransportURITest() throws Exception{
        getService().setAVTransportURI(currentURI, currentURIMetaData, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setAVTransportURI");
    }
    */

    /*
    @Test
    public void addURIToQueueTest() throws Exception{
        final AddURIToQueueResult value = getService().addURIToQueue(enqueuedURI, enqueuedURIMetaData, desiredFirstTrackNumberEnqueued, enqueueAsNext, new AsyncValue<AddURIToQueueResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got addURIToQueue: " + value);
    }
    */

    /*
    @Test
    public void reorderTracksInQueueTest() throws Exception{
        getService().reorderTracksInQueue(startingIndex, numberOfTracks, insertBefore, updateID, new VoidCallback()).waitForSuccess();
        System.out.println("Finished reorderTracksInQueue");
    }
    */

    /*
    @Test
    public void removeTrackFromQueueTest() throws Exception{
        getService().removeTrackFromQueue(objectID, updateID, new VoidCallback()).waitForSuccess();
        System.out.println("Finished removeTrackFromQueue");
    }
    */

    /*
    @Test
    public void removeAllTracksFromQueueTest() throws Exception{
        getService().removeAllTracksFromQueue(new VoidCallback()).waitForSuccess();
        System.out.println("Finished removeAllTracksFromQueue");
    }
    */

    /*
    @Test
    public void saveQueueTest() throws Exception{
        final ObjectID value = getService().saveQueue(title, objectID, new AsyncValue<ObjectID>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got saveQueue: " + value);
    }
    */

    @Test
    public void retrieveMediaInfoTest() throws Exception{
        final GetMediaInfoResult value = getService().retrieveMediaInfo(new AsyncValue<GetMediaInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveMediaInfo: " + value);
    }

    @Test
    public void retrieveTransportInfoTest() throws Exception{
        final GetTransportInfoResult value = getService().retrieveTransportInfo(new AsyncValue<GetTransportInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveTransportInfo: " + value);
    }

    @Test
    public void retrievePositionInfoTest() throws Exception{
        final GetPositionInfoResult value = getService().retrievePositionInfo(new AsyncValue<GetPositionInfoResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrievePositionInfo: " + value);
    }

    @Test
    public void retrieveDeviceCapabilitiesTest() throws Exception{
        final GetDeviceCapabilitiesResult value = getService().retrieveDeviceCapabilities(new AsyncValue<GetDeviceCapabilitiesResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveDeviceCapabilities: " + value);
    }

    @Test
    public void retrieveTransportSettingsTest() throws Exception{
        final GetTransportSettingsResult value = getService().retrieveTransportSettings(new AsyncValue<GetTransportSettingsResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveTransportSettings: " + value);
    }

    @Test
    public void retrieveCrossfadeModeTest() throws Exception{
        final CurrentCrossfadeMode value = getService().retrieveCrossfadeMode(new AsyncValue<CurrentCrossfadeMode>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveCrossfadeMode: " + value);
    }

    /*
    @Test
    public void stopTest() throws Exception{
        getService().stop(new VoidCallback()).waitForSuccess();
        System.out.println("Finished stop");
    }
    */

    /*
    @Test
    public void playTest() throws Exception{
        getService().play(new VoidCallback()).waitForSuccess();
        System.out.println("Finished play");
    }
    */

    /*
    @Test
    public void pauseTest() throws Exception{
        getService().pause(new VoidCallback()).waitForSuccess();
        System.out.println("Finished pause");
    }
    */

    /*
    @Test
    public void seekTest() throws Exception{
        getService().seek(unit, target, new VoidCallback()).waitForSuccess();
        System.out.println("Finished seek");
    }
    */

    /*
    @Test
    public void nextTest() throws Exception{
        getService().next(new VoidCallback()).waitForSuccess();
        System.out.println("Finished next");
    }
    */

    /*
    @Test
    public void nextProgrammedRadioTracksTest() throws Exception{
        getService().nextProgrammedRadioTracks(new VoidCallback()).waitForSuccess();
        System.out.println("Finished nextProgrammedRadioTracks");
    }
    */

    /*
    @Test
    public void previousTest() throws Exception{
        getService().previous(new VoidCallback()).waitForSuccess();
        System.out.println("Finished previous");
    }
    */

    /*
    @Test
    public void nextSectionTest() throws Exception{
        getService().nextSection(new VoidCallback()).waitForSuccess();
        System.out.println("Finished nextSection");
    }
    */

    /*
    @Test
    public void previousSectionTest() throws Exception{
        getService().previousSection(new VoidCallback()).waitForSuccess();
        System.out.println("Finished previousSection");
    }
    */

    /*
    @Test
    public void setPlayModeTest() throws Exception{
        getService().setPlayMode(newPlayMode, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setPlayMode");
    }
    */

    /*
    @Test
    public void setCrossfadeModeTest() throws Exception{
        getService().setCrossfadeMode(crossfadeMode, new VoidCallback()).waitForSuccess();
        System.out.println("Finished setCrossfadeMode");
    }
    */

    /*
    @Test
    public void notifyDeletedURITest() throws Exception{
        getService().notifyDeletedURI(deletedURI, new VoidCallback()).waitForSuccess();
        System.out.println("Finished notifyDeletedURI");
    }
    */

    @Test
    public void retrieveCurrentTransportActionsTest() throws Exception{
        final CurrentTransportActions value = getService().retrieveCurrentTransportActions(new AsyncValue<CurrentTransportActions>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveCurrentTransportActions: " + value);
    }

    /*
    @Test
    public void becomeCoordinatorOfStandaloneGroupTest() throws Exception{
        getService().becomeCoordinatorOfStandaloneGroup(new VoidCallback()).waitForSuccess();
        System.out.println("Finished becomeCoordinatorOfStandaloneGroup");
    }
    */

    /*
    @Test
    public void becomeGroupCoordinatorTest() throws Exception{
        getService().becomeGroupCoordinator(currentCoordinator, currentGroupID, otherMembers, transportSettings, currentURI, currentURIMetaData, sleepTimerState, alarmState, streamRestartState, currentQueueTrackList, new VoidCallback()).waitForSuccess();
        System.out.println("Finished becomeGroupCoordinator");
    }
    */

    /*
    @Test
    public void becomeGroupCoordinatorAndSourceTest() throws Exception{
        getService().becomeGroupCoordinatorAndSource(currentCoordinator, currentGroupID, otherMembers, currentURI, currentURIMetaData, sleepTimerState, alarmState, streamRestartState, currentAVTTrackList, currentQueueTrackList, currentSourceState, resumePlayback, new VoidCallback()).waitForSuccess();
        System.out.println("Finished becomeGroupCoordinatorAndSource");
    }
    */

    /*
    @Test
    public void changeCoordinatorTest() throws Exception{
        getService().changeCoordinator(currentCoordinator, newCoordinator, newTransportSettings, new VoidCallback()).waitForSuccess();
        System.out.println("Finished changeCoordinator");
    }
    */

    /*
    @Test
    public void changeTransportSettingsTest() throws Exception{
        getService().changeTransportSettings(newTransportSettings, currentAVTransportURI, new VoidCallback()).waitForSuccess();
        System.out.println("Finished changeTransportSettings");
    }
    */

    /*
    @Test
    public void configureSleepTimerTest() throws Exception{
        getService().configureSleepTimer(newSleepTimerDuration, new VoidCallback()).waitForSuccess();
        System.out.println("Finished configureSleepTimer");
    }
    */

    @Test
    public void retrieveRemainingSleepTimerDurationTest() throws Exception{
        final GetRemainingSleepTimerDurationResult value = getService().retrieveRemainingSleepTimerDuration(new AsyncValue<GetRemainingSleepTimerDurationResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveRemainingSleepTimerDuration: " + value);
    }

    /*
    @Test
    public void runAlarmTest() throws Exception{
        getService().runAlarm(alarmID, loggedStartTime, duration, programURI, programMetaData, playMode, volume, includeLinkedZones, new VoidCallback()).waitForSuccess();
        System.out.println("Finished runAlarm");
    }
    */

    /*
    @Test
    public void startAutoplayTest() throws Exception{
        getService().startAutoplay(programURI, programMetaData, volume, includeLinkedZones, resetVolumeAfter, new VoidCallback()).waitForSuccess();
        System.out.println("Finished startAutoplay");
    }
    */

    @Test
    public void retrieveRunningAlarmPropertiesTest() throws Exception{
        final GetRunningAlarmPropertiesResult value = getService().retrieveRunningAlarmProperties(new AsyncValue<GetRunningAlarmPropertiesResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveRunningAlarmProperties: " + value);
    }

    /*
    @Test
    public void snoozeAlarmTest() throws Exception{
        getService().snoozeAlarm(duration, new VoidCallback()).waitForSuccess();
        System.out.println("Finished snoozeAlarm");
    }
    */
}

