package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
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
import de.kalass.sonoscontrol.api.model.avtransport.InstanceID;
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

public interface AVTransportService {


    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setAVTransportURI(AVTransportURI currentURI, AVTransportURIMetaData currentURIMetaData, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<AddURIToQueueResult>> C addURIToQueue(URI enqueuedURI, URIMetaData enqueuedURIMetaData, TrackNumber desiredFirstTrackNumberEnqueued, EnqueueAsNext enqueueAsNext, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C reorderTracksInQueue(TrackNumber startingIndex, NumTracks numberOfTracks, TrackNumber insertBefore, QueueUpdateID updateID, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C removeTrackFromQueue(ObjectID objectID, QueueUpdateID updateID, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C removeAllTracksFromQueue(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<ObjectID>> C saveQueue(SavedQueueTitle title, ObjectID objectID, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<MediaInfo>> C retrieveMediaInfo(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<TransportInfo>> C retrieveTransportInfo(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<PositionInfo>> C retrievePositionInfo(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<DeviceCapabilities>> C retrieveDeviceCapabilities(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<TransportSettings>> C retrieveTransportSettings(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<CurrentCrossfadeMode>> C retrieveCrossfadeMode(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C stop(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link TransportPlaySpeed speed} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C play(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C pause(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C seek(SeekMode unit, SeekTarget target, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C next(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C nextProgrammedRadioTracks(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C previous(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C nextSection(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C previousSection(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setPlayMode(CurrentPlayMode newPlayMode, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C setCrossfadeMode(CurrentCrossfadeMode crossfadeMode, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C notifyDeletedURI(AVTransportURI deletedURI, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<CurrentTransportActions>> C retrieveCurrentTransportActions(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C becomeCoordinatorOfStandaloneGroup(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C becomeGroupCoordinator(MemberID currentCoordinator, GroupID currentGroupID, MemberList otherMembers, TransportSettings transportSettings, AVTransportURI currentURI, AVTransportURIMetaData currentURIMetaData, SleepTimerState sleepTimerState, AlarmState alarmState, StreamRestartState streamRestartState, Queue currentQueueTrackList, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C becomeGroupCoordinatorAndSource(MemberID currentCoordinator, GroupID currentGroupID, MemberList otherMembers, AVTransportURI currentURI, AVTransportURIMetaData currentURIMetaData, SleepTimerState sleepTimerState, AlarmState alarmState, StreamRestartState streamRestartState, Queue currentAVTTrackList, Queue currentQueueTrackList, SourceState currentSourceState, ResumePlayback resumePlayback, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C changeCoordinator(MemberID currentCoordinator, MemberID newCoordinator, TransportSettings newTransportSettings, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C changeTransportSettings(TransportSettings newTransportSettings, CurrentAVTransportURI currentAVTransportURI, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C configureSleepTimer(ISO8601Time newSleepTimerDuration, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<RemainingSleepTimerDuration>> C retrieveRemainingSleepTimerDuration(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C runAlarm(AlarmIDRunning alarmID, AlarmLoggedStartTime loggedStartTime, ISO8601Time duration, AVTransportURI programURI, AVTransportURIMetaData programMetaData, CurrentPlayMode playMode, AlarmVolume volume, AlarmIncludeLinkedZones includeLinkedZones, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C startAutoplay(AVTransportURI programURI, AVTransportURIMetaData programMetaData, AlarmVolume volume, AlarmIncludeLinkedZones includeLinkedZones, ResetVolumeAfter resetVolumeAfter, C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback1<RunningAlarmProperties>> C retrieveRunningAlarmProperties(C callback);

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    <C extends Callback0> C snoozeAlarm(ISO8601Time duration, C callback);

}
