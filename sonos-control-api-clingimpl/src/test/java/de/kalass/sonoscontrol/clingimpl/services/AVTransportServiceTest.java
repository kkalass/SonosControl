// AUTOGENERATED: c0deeee0e801744a96a222c464303f31
// AUTOGENERATED: Please feel free to enhance this sourcecode manually
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.clingimpl.services;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.AsyncValue;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentCrossfadeMode;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTransportActions;
import de.kalass.sonoscontrol.api.model.avtransport.GetDeviceCapabilitiesResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetMediaInfoResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetPositionInfoResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetRemainingSleepTimerDurationResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetRunningAlarmPropertiesResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetTransportInfoResult;
import de.kalass.sonoscontrol.api.model.avtransport.GetTransportSettingsResult;
import de.kalass.sonoscontrol.api.model.avtransport.LastChange;
import de.kalass.sonoscontrol.api.services.AVTransportService;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

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

    /**
     * 09.01.2012 (KK): Disabled test, because it keeps triggering a "500 Internal Server Error"
     */
    @Test(enabled = false)
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

