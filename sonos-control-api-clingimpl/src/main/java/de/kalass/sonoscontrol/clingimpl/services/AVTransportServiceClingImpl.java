

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AVTransportService;
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

@SuppressWarnings("rawtypes")
public final class AVTransportServiceClingImpl extends AbstractServiceImpl implements AVTransportService {

    public AVTransportServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("AVTransport", upnpService, device, errorStrategy);
    }


    public LastChange getLastChange() {
        throw new UnsupportedOperationException();
    }


    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setAVTransportURI(final AVTransportURI currentURI, final AVTransportURIMetaData currentURIMetaData, final C successHandler) {
        return execute(successHandler, new Call<C>("SetAVTransportURI") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "CurrentURI", currentURI.getValue());
                setInput(invocation,"string", "CurrentURIMetaData", currentURIMetaData.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<AddURIToQueueResult>> C addURIToQueue(final URI enqueuedURI, final URIMetaData enqueuedURIMetaData, final TrackNumber desiredFirstTrackNumberEnqueued, final EnqueueAsNext enqueueAsNext, final C successHandler) {
        return execute(successHandler, new Call<C>("AddURIToQueue") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "EnqueuedURI", enqueuedURI.getValue());
                setInput(invocation,"string", "EnqueuedURIMetaData", enqueuedURIMetaData.getValue());
                setInput(invocation,"ui4", "DesiredFirstTrackNumberEnqueued", desiredFirstTrackNumberEnqueued.getValue());
                setInput(invocation,"boolean", "EnqueueAsNext", enqueueAsNext.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final TrackNumber value0 = TrackNumber.getInstance(getLong("ui4",output[0].getValue()));
                final NumTracks value1 = NumTracks.getInstance(getLong("ui4",output[1].getValue()));
                final NumTracks value2 = NumTracks.getInstance(getLong("ui4",output[2].getValue()));
                final AddURIToQueueResult value = AddURIToQueueResult.getInstance(value0,value1,value2);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C reorderTracksInQueue(final TrackNumber startingIndex, final NumTracks numberOfTracks, final TrackNumber insertBefore, final QueueUpdateID updateID, final C successHandler) {
        return execute(successHandler, new Call<C>("ReorderTracksInQueue") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"ui4", "StartingIndex", startingIndex.getValue());
                setInput(invocation,"ui4", "NumberOfTracks", numberOfTracks.getValue());
                setInput(invocation,"ui4", "InsertBefore", insertBefore.getValue());
                setInput(invocation,"ui4", "UpdateID", updateID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C removeTrackFromQueue(final ObjectID objectID, final QueueUpdateID updateID, final C successHandler) {
        return execute(successHandler, new Call<C>("RemoveTrackFromQueue") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "ObjectID", objectID.getValue());
                setInput(invocation,"ui4", "UpdateID", updateID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C removeAllTracksFromQueue(final C successHandler) {
        return execute(successHandler, new Call<C>("RemoveAllTracksFromQueue") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<ObjectID>> C saveQueue(final SavedQueueTitle title, final ObjectID objectID, final C successHandler) {
        return execute(successHandler, new Call<C>("SaveQueue") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Title", title.getValue());
                setInput(invocation,"string", "ObjectID", objectID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final ObjectID value = ObjectID.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<GetMediaInfoResult>> C retrieveMediaInfo(final C successHandler) {
        return execute(successHandler, new Call<C>("GetMediaInfo") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final NumberOfTracks value0 = NumberOfTracks.getInstance(getLong("ui4",output[0].getValue()));
                final CurrentMediaDuration value1 = CurrentMediaDuration.getInstance(getString("string",output[1].getValue()));
                final AVTransportURI value2 = AVTransportURI.getInstance(getString("string",output[2].getValue()));
                final AVTransportURIMetaData value3 = AVTransportURIMetaData.getInstance(getString("string",output[3].getValue()));
                final NextAVTransportURI value4 = NextAVTransportURI.getInstance(getString("string",output[4].getValue()));
                final NextAVTransportURIMetaData value5 = NextAVTransportURIMetaData.getInstance(getString("string",output[5].getValue()));
                final PlaybackStorageMedium value6 = PlaybackStorageMedium.getInstance(getString("string",output[6].getValue()));
                final RecordStorageMedium value7 = RecordStorageMedium.getInstance(getString("string",output[7].getValue()));
                final RecordMediumWriteStatus value8 = RecordMediumWriteStatus.getInstance(getString("string",output[8].getValue()));
                final GetMediaInfoResult value = GetMediaInfoResult.getInstance(value0,value1,value2,value3,value4,value5,value6,value7,value8);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<GetTransportInfoResult>> C retrieveTransportInfo(final C successHandler) {
        return execute(successHandler, new Call<C>("GetTransportInfo") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final TransportState value0 = TransportState.getInstance(getString("string",output[0].getValue()));
                final TransportStatus value1 = TransportStatus.getInstance(getString("string",output[1].getValue()));
                final TransportPlaySpeed value2 = TransportPlaySpeed.getInstance(getString("string",output[2].getValue()));
                final GetTransportInfoResult value = GetTransportInfoResult.getInstance(value0,value1,value2);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<GetPositionInfoResult>> C retrievePositionInfo(final C successHandler) {
        return execute(successHandler, new Call<C>("GetPositionInfo") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final CurrentTrack value0 = CurrentTrack.getInstance(getLong("ui4",output[0].getValue()));
                final CurrentTrackDuration value1 = CurrentTrackDuration.getInstance(getString("string",output[1].getValue()));
                final CurrentTrackMetaData value2 = CurrentTrackMetaData.getInstance(getString("string",output[2].getValue()));
                final CurrentTrackURI value3 = CurrentTrackURI.getInstance(getString("string",output[3].getValue()));
                final RelativeTimePosition value4 = RelativeTimePosition.getInstance(getString("string",output[4].getValue()));
                final AbsoluteTimePosition value5 = AbsoluteTimePosition.getInstance(getString("string",output[5].getValue()));
                final RelativeCounterPosition value6 = RelativeCounterPosition.getInstance(getLong("i4",output[6].getValue()));
                final AbsoluteCounterPosition value7 = AbsoluteCounterPosition.getInstance(getLong("i4",output[7].getValue()));
                final GetPositionInfoResult value = GetPositionInfoResult.getInstance(value0,value1,value2,value3,value4,value5,value6,value7);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<GetDeviceCapabilitiesResult>> C retrieveDeviceCapabilities(final C successHandler) {
        return execute(successHandler, new Call<C>("GetDeviceCapabilities") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final PossiblePlaybackStorageMedia value0 = PossiblePlaybackStorageMedia.getInstance(getString("string",output[0].getValue()));
                final PossibleRecordStorageMedia value1 = PossibleRecordStorageMedia.getInstance(getString("string",output[1].getValue()));
                final PossibleRecordQualityModes value2 = PossibleRecordQualityModes.getInstance(getString("string",output[2].getValue()));
                final GetDeviceCapabilitiesResult value = GetDeviceCapabilitiesResult.getInstance(value0,value1,value2);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<GetTransportSettingsResult>> C retrieveTransportSettings(final C successHandler) {
        return execute(successHandler, new Call<C>("GetTransportSettings") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final CurrentPlayMode value0 = CurrentPlayMode.getInstance(getString("string",output[0].getValue()));
                final CurrentRecordQualityMode value1 = CurrentRecordQualityMode.getInstance(getString("string",output[1].getValue()));
                final GetTransportSettingsResult value = GetTransportSettingsResult.getInstance(value0,value1);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<CurrentCrossfadeMode>> C retrieveCrossfadeMode(final C successHandler) {
        return execute(successHandler, new Call<C>("GetCrossfadeMode") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final CurrentCrossfadeMode value = CurrentCrossfadeMode.getInstance(getBoolean("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C stop(final C successHandler) {
        return execute(successHandler, new Call<C>("Stop") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link TransportPlaySpeed speed} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C play(final C successHandler) {
        return execute(successHandler, new Call<C>("Play") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Speed", TransportPlaySpeed.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C pause(final C successHandler) {
        return execute(successHandler, new Call<C>("Pause") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C seek(final SeekMode unit, final SeekTarget target, final C successHandler) {
        return execute(successHandler, new Call<C>("Seek") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Unit", unit.getValue());
                setInput(invocation,"string", "Target", target.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C next(final C successHandler) {
        return execute(successHandler, new Call<C>("Next") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C nextProgrammedRadioTracks(final C successHandler) {
        return execute(successHandler, new Call<C>("NextProgrammedRadioTracks") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C previous(final C successHandler) {
        return execute(successHandler, new Call<C>("Previous") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C nextSection(final C successHandler) {
        return execute(successHandler, new Call<C>("NextSection") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C previousSection(final C successHandler) {
        return execute(successHandler, new Call<C>("PreviousSection") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setPlayMode(final CurrentPlayMode newPlayMode, final C successHandler) {
        return execute(successHandler, new Call<C>("SetPlayMode") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "NewPlayMode", newPlayMode.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C setCrossfadeMode(final CurrentCrossfadeMode crossfadeMode, final C successHandler) {
        return execute(successHandler, new Call<C>("SetCrossfadeMode") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"boolean", "CrossfadeMode", crossfadeMode.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C notifyDeletedURI(final AVTransportURI deletedURI, final C successHandler) {
        return execute(successHandler, new Call<C>("NotifyDeletedURI") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "DeletedURI", deletedURI.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<CurrentTransportActions>> C retrieveCurrentTransportActions(final C successHandler) {
        return execute(successHandler, new Call<C>("GetCurrentTransportActions") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final CurrentTransportActions value = CurrentTransportActions.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C becomeCoordinatorOfStandaloneGroup(final C successHandler) {
        return execute(successHandler, new Call<C>("BecomeCoordinatorOfStandaloneGroup") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C becomeGroupCoordinator(final MemberID currentCoordinator, final GroupID currentGroupID, final MemberList otherMembers, final TransportSettings transportSettings, final AVTransportURI currentURI, final AVTransportURIMetaData currentURIMetaData, final SleepTimerState sleepTimerState, final AlarmState alarmState, final StreamRestartState streamRestartState, final Queue currentQueueTrackList, final C successHandler) {
        return execute(successHandler, new Call<C>("BecomeGroupCoordinator") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "CurrentCoordinator", currentCoordinator.getValue());
                setInput(invocation,"string", "CurrentGroupID", currentGroupID.getValue());
                setInput(invocation,"string", "OtherMembers", otherMembers.getValue());
                setInput(invocation,"string", "TransportSettings", transportSettings.getValue());
                setInput(invocation,"string", "CurrentURI", currentURI.getValue());
                setInput(invocation,"string", "CurrentURIMetaData", currentURIMetaData.getValue());
                setInput(invocation,"string", "SleepTimerState", sleepTimerState.getValue());
                setInput(invocation,"string", "AlarmState", alarmState.getValue());
                setInput(invocation,"string", "StreamRestartState", streamRestartState.getValue());
                setInput(invocation,"string", "CurrentQueueTrackList", currentQueueTrackList.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C becomeGroupCoordinatorAndSource(final MemberID currentCoordinator, final GroupID currentGroupID, final MemberList otherMembers, final AVTransportURI currentURI, final AVTransportURIMetaData currentURIMetaData, final SleepTimerState sleepTimerState, final AlarmState alarmState, final StreamRestartState streamRestartState, final Queue currentAVTTrackList, final Queue currentQueueTrackList, final SourceState currentSourceState, final ResumePlayback resumePlayback, final C successHandler) {
        return execute(successHandler, new Call<C>("BecomeGroupCoordinatorAndSource") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "CurrentCoordinator", currentCoordinator.getValue());
                setInput(invocation,"string", "CurrentGroupID", currentGroupID.getValue());
                setInput(invocation,"string", "OtherMembers", otherMembers.getValue());
                setInput(invocation,"string", "CurrentURI", currentURI.getValue());
                setInput(invocation,"string", "CurrentURIMetaData", currentURIMetaData.getValue());
                setInput(invocation,"string", "SleepTimerState", sleepTimerState.getValue());
                setInput(invocation,"string", "AlarmState", alarmState.getValue());
                setInput(invocation,"string", "StreamRestartState", streamRestartState.getValue());
                setInput(invocation,"string", "CurrentAVTTrackList", currentAVTTrackList.getValue());
                setInput(invocation,"string", "CurrentQueueTrackList", currentQueueTrackList.getValue());
                setInput(invocation,"string", "CurrentSourceState", currentSourceState.getValue());
                setInput(invocation,"boolean", "ResumePlayback", resumePlayback.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C changeCoordinator(final MemberID currentCoordinator, final MemberID newCoordinator, final TransportSettings newTransportSettings, final C successHandler) {
        return execute(successHandler, new Call<C>("ChangeCoordinator") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "CurrentCoordinator", currentCoordinator.getValue());
                setInput(invocation,"string", "NewCoordinator", newCoordinator.getValue());
                setInput(invocation,"string", "NewTransportSettings", newTransportSettings.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C changeTransportSettings(final TransportSettings newTransportSettings, final CurrentAVTransportURI currentAVTransportURI, final C successHandler) {
        return execute(successHandler, new Call<C>("ChangeTransportSettings") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "NewTransportSettings", newTransportSettings.getValue());
                setInput(invocation,"string", "CurrentAVTransportURI", currentAVTransportURI.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C configureSleepTimer(final ISO8601Time newSleepTimerDuration, final C successHandler) {
        return execute(successHandler, new Call<C>("ConfigureSleepTimer") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "NewSleepTimerDuration", newSleepTimerDuration.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<GetRemainingSleepTimerDurationResult>> C retrieveRemainingSleepTimerDuration(final C successHandler) {
        return execute(successHandler, new Call<C>("GetRemainingSleepTimerDuration") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final ISO8601Time value0 = ISO8601Time.getInstance(getString("string",output[0].getValue()));
                final SleepTimerGeneration value1 = SleepTimerGeneration.getInstance(getLong("ui4",output[1].getValue()));
                final GetRemainingSleepTimerDurationResult value = GetRemainingSleepTimerDurationResult.getInstance(value0,value1);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C runAlarm(final AlarmIDRunning alarmID, final AlarmLoggedStartTime loggedStartTime, final ISO8601Time duration, final AVTransportURI programURI, final AVTransportURIMetaData programMetaData, final CurrentPlayMode playMode, final AlarmVolume volume, final AlarmIncludeLinkedZones includeLinkedZones, final C successHandler) {
        return execute(successHandler, new Call<C>("RunAlarm") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"ui4", "AlarmID", alarmID.getValue());
                setInput(invocation,"string", "LoggedStartTime", loggedStartTime.getValue());
                setInput(invocation,"string", "Duration", duration.getValue());
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

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C startAutoplay(final AVTransportURI programURI, final AVTransportURIMetaData programMetaData, final AlarmVolume volume, final AlarmIncludeLinkedZones includeLinkedZones, final ResetVolumeAfter resetVolumeAfter, final C successHandler) {
        return execute(successHandler, new Call<C>("StartAutoplay") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "ProgramURI", programURI.getValue());
                setInput(invocation,"string", "ProgramMetaData", programMetaData.getValue());
                setInput(invocation,"ui2", "Volume", volume.getValue());
                setInput(invocation,"boolean", "IncludeLinkedZones", includeLinkedZones.getValue());
                setInput(invocation,"boolean", "ResetVolumeAfter", resetVolumeAfter.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback1<GetRunningAlarmPropertiesResult>> C retrieveRunningAlarmProperties(final C successHandler) {
        return execute(successHandler, new Call<C>("GetRunningAlarmProperties") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final AlarmIDRunning value0 = AlarmIDRunning.getInstance(getLong("ui4",output[0].getValue()));
                final GroupID value1 = GroupID.getInstance(getString("string",output[1].getValue()));
                final AlarmLoggedStartTime value2 = AlarmLoggedStartTime.getInstance(getString("string",output[2].getValue()));
                final GetRunningAlarmPropertiesResult value = GetRunningAlarmPropertiesResult.getInstance(value0,value1,value2);
                handler.success(value);
            }
        });
    }

    /**
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link InstanceID instanceID} is set to an appropriate default value automatically.</p>
      */
    public <C extends Callback0> C snoozeAlarm(final ISO8601Time duration, final C successHandler) {
        return execute(successHandler, new Call<C>("SnoozeAlarm") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "InstanceID", InstanceID.DEFAULT_VALUE.getValue());
                setInput(invocation,"string", "Duration", duration.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

}
