package de.kalass.sonoscontrol.clingimpl;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.avtransport.AVTransportURI;
import de.kalass.sonoscontrol.api.model.avtransport.AVTransportURIMetaData;
import de.kalass.sonoscontrol.api.model.avtransport.AddURIToQueueResult;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmIDRunning;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmIncludeLinkedZones;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmLoggedStartTime;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmState;
import de.kalass.sonoscontrol.api.model.avtransport.AlarmVolume;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentAVTransportURI;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentCrossfadeMode;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentPlayMode;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTransportActions;
import de.kalass.sonoscontrol.api.model.avtransport.DeviceCapabilities;
import de.kalass.sonoscontrol.api.model.avtransport.EnqueueAsNext;
import de.kalass.sonoscontrol.api.model.avtransport.GroupID;
import de.kalass.sonoscontrol.api.model.avtransport.ISO8601Time;
import de.kalass.sonoscontrol.api.model.avtransport.MediaInfo;
import de.kalass.sonoscontrol.api.model.avtransport.MemberList;
import de.kalass.sonoscontrol.api.model.avtransport.NumTracks;
import de.kalass.sonoscontrol.api.model.avtransport.ObjectID;
import de.kalass.sonoscontrol.api.model.avtransport.PositionInfo;
import de.kalass.sonoscontrol.api.model.avtransport.Queue;
import de.kalass.sonoscontrol.api.model.avtransport.QueueUpdateID;
import de.kalass.sonoscontrol.api.model.avtransport.RemainingSleepTimerDuration;
import de.kalass.sonoscontrol.api.model.avtransport.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.avtransport.ResumePlayback;
import de.kalass.sonoscontrol.api.model.avtransport.RunningAlarmProperties;
import de.kalass.sonoscontrol.api.model.avtransport.SavedQueueTitle;
import de.kalass.sonoscontrol.api.model.avtransport.SeekMode;
import de.kalass.sonoscontrol.api.model.avtransport.SeekTarget;
import de.kalass.sonoscontrol.api.model.avtransport.SleepTimerState;
import de.kalass.sonoscontrol.api.model.avtransport.SourceState;
import de.kalass.sonoscontrol.api.model.avtransport.StreamRestartState;
import de.kalass.sonoscontrol.api.model.avtransport.TrackNumber;
import de.kalass.sonoscontrol.api.model.avtransport.TransportInfo;
import de.kalass.sonoscontrol.api.model.avtransport.TransportPlaySpeed;
import de.kalass.sonoscontrol.api.model.avtransport.TransportSettings;
import de.kalass.sonoscontrol.api.model.avtransport.URI;
import de.kalass.sonoscontrol.api.model.avtransport.URIMetaData;
import de.kalass.sonoscontrol.api.services.AVTransportService;

@SuppressWarnings("rawtypes")
public class AVTransportServiceImpl extends AbstractServiceImpl implements AVTransportService {
    //private static final Logger LOG = LoggerFactory.getLogger(RenderingControlServiceImpl.class);

    public AVTransportServiceImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("AVTransport", upnpService, device, errorStrategy);
    }

    @Override
    public <C extends Callback0> C stop(C successHandler) {
        return execute(successHandler, new Call0("Stop") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(0l));
            }

        });
    }

    @Override
    public <C extends Callback0> C play(C successHandler) {
        return execute(successHandler, new Call0("Play") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(0l));
                invocation.setInput("Speed", TransportPlaySpeed.ONE.asString());
            }

        });
    }

    @Override
    public <C extends Callback0> C setAVTransportURI(
            final AVTransportURI currentURI,
            final AVTransportURIMetaData currentURIMetaData,
            C callback
            ) {
        return execute(callback, new Call0("SetAVTransportURI"){
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(0l));
                invocation.setInput("CurrentURI", currentURI.asString());
                invocation.setInput("CurrentURIMetaData", currentURIMetaData == null ? null : currentURIMetaData.asString());
            }
        });

    }

    @Override
    public <C extends Callback1<AddURIToQueueResult>> C addURIToQueue(
            URI enqueuedURI, URIMetaData enqueuedURIMetaData,
            TrackNumber desiredFirstTrackNumberEnqueued,
            EnqueueAsNext enqueueAsNext, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C reorderTracksInQueue(
            TrackNumber startingIndex, NumTracks numberOfTracks,
            TrackNumber insertBefore, QueueUpdateID updateID, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C removeTrackFromQueue(ObjectID objectID,
            QueueUpdateID updateID, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C removeAllTracksFromQueue(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<ObjectID>> C saveQueue(SavedQueueTitle title,
            ObjectID objectID, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<MediaInfo>> C retrieveMediaInfo(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<TransportInfo>> C retrieveTransportInfo(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<PositionInfo>> C retrievePositionInfo(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<DeviceCapabilities>> C retrieveDeviceCapabilities(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<TransportSettings>> C retrieveTransportSettings(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<CurrentCrossfadeMode>> C retrieveCrossfadeMode(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C pause(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C seek(SeekMode unit, SeekTarget target,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C next(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C nextProgrammedRadioTracks(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C previous(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C nextSection(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C previousSection(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setPlayMode(CurrentPlayMode newPlayMode,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C setCrossfadeMode(
            CurrentCrossfadeMode crossfadeMode, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C notifyDeletedURI(AVTransportURI deletedURI,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<CurrentTransportActions>> C retrieveCurrentTransportActions(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C becomeCoordinatorOfStandaloneGroup(C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C becomeGroupCoordinator(
            MemberID currentCoordinator, GroupID currentGroupID,
            MemberList otherMembers, TransportSettings transportSettings,
            AVTransportURI currentURI,
            AVTransportURIMetaData currentURIMetaData,
            SleepTimerState sleepTimerState, AlarmState alarmState,
            StreamRestartState streamRestartState, Queue currentQueueTrackList,
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C becomeGroupCoordinatorAndSource(
            MemberID currentCoordinator, GroupID currentGroupID,
            MemberList otherMembers, AVTransportURI currentURI,
            AVTransportURIMetaData currentURIMetaData,
            SleepTimerState sleepTimerState, AlarmState alarmState,
            StreamRestartState streamRestartState, Queue currentAVTTrackList,
            Queue currentQueueTrackList, SourceState currentSourceState,
            ResumePlayback resumePlayback, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C changeCoordinator(
            MemberID currentCoordinator, MemberID newCoordinator,
            TransportSettings newTransportSettings, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C changeTransportSettings(
            TransportSettings newTransportSettings,
            CurrentAVTransportURI currentAVTransportURI, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C configureSleepTimer(
            ISO8601Time newSleepTimerDuration, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<RemainingSleepTimerDuration>> C retrieveRemainingSleepTimerDuration(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C runAlarm(AlarmIDRunning alarmID,
            AlarmLoggedStartTime loggedStartTime, ISO8601Time duration,
            AVTransportURI programURI, AVTransportURIMetaData programMetaData,
            CurrentPlayMode playMode, AlarmVolume volume,
            AlarmIncludeLinkedZones includeLinkedZones, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C startAutoplay(AVTransportURI programURI,
            AVTransportURIMetaData programMetaData, AlarmVolume volume,
            AlarmIncludeLinkedZones includeLinkedZones,
            ResetVolumeAfter resetVolumeAfter, C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback1<RunningAlarmProperties>> C retrieveRunningAlarmProperties(
            C callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <C extends Callback0> C snoozeAlarm(ISO8601Time duration, C callback) {
        throw new UnsupportedOperationException();
    }
}
