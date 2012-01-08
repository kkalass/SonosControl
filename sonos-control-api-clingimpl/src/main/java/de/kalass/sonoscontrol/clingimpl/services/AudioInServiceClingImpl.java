/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AudioInService;
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
import de.kalass.sonoscontrol.api.model.audioin.TransportSettings;
import de.kalass.sonoscontrol.api.model.audioin.GetAudioInputAttributesResult;
import de.kalass.sonoscontrol.api.model.audioin.GetLineInLevelResult;
import de.kalass.sonoscontrol.api.model.audioin.RightLineInLevel;
import de.kalass.sonoscontrol.api.model.audioin.LeftLineInLevel;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.audioin.AudioInputName;
import de.kalass.sonoscontrol.api.model.audioin.ObjectID;
import de.kalass.sonoscontrol.api.model.audioin.LineInConnected;
import de.kalass.sonoscontrol.api.model.audioin.Playing;
import de.kalass.sonoscontrol.api.model.audioin.Icon;

@SuppressWarnings("rawtypes")
public final class AudioInServiceClingImpl extends AbstractServiceImpl implements AudioInService {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AudioInServiceClingImpl.class);
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();
    
    private final List<EventListener<RightLineInLevel>> _changeRightLineInLevelListeners = new ArrayList<EventListener<RightLineInLevel>>();
    private final List<EventListener<LeftLineInLevel>> _changeLeftLineInLevelListeners = new ArrayList<EventListener<LeftLineInLevel>>();
    private final List<EventListener<AudioInputName>> _changeAudioInputNameListeners = new ArrayList<EventListener<AudioInputName>>();
    private final List<EventListener<LineInConnected>> _changeLineInConnectedListeners = new ArrayList<EventListener<LineInConnected>>();
    private final List<EventListener<Playing>> _changePlayingListeners = new ArrayList<EventListener<Playing>>();
    private final List<EventListener<Icon>> _changeIconListeners = new ArrayList<EventListener<Icon>>();

    public AudioInServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("AudioIn", upnpService, device, errorStrategy);
    }


    public <C extends Callback1<TransportSettings>> C startTransmissionToGroup(final MemberID coordinatorID, final C successHandler) {
        return execute(successHandler, new Call<C>("StartTransmissionToGroup") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "CoordinatorID", coordinatorID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final TransportSettings value = TransportSettings.getInstance((String)getValue("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C stopTransmissionToGroup(final MemberID coordinatorID, final C successHandler) {
        return execute(successHandler, new Call<C>("StopTransmissionToGroup") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "CoordinatorID", coordinatorID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C setAudioInputAttributes(final AudioInputName desiredName, final Icon desiredIcon, final C successHandler) {
        return execute(successHandler, new Call<C>("SetAudioInputAttributes") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DesiredName", desiredName.getValue());
                setInput(invocation,"string", "DesiredIcon", desiredIcon.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<GetAudioInputAttributesResult>> C retrieveAudioInputAttributes(final C successHandler) {
        return execute(successHandler, new Call<C>("GetAudioInputAttributes") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final AudioInputName currentName = AudioInputName.getInstance((String)getValue("string",output[0].getValue()));
                final Icon currentIcon = Icon.getInstance((String)getValue("string",output[1].getValue()));
                final GetAudioInputAttributesResult value = GetAudioInputAttributesResult.getInstance(currentName,currentIcon);
                handler.success(value);
            }
        });
    }

    public <C extends Callback0> C setLineInLevel(final LeftLineInLevel desiredLeftLineInLevel, final RightLineInLevel desiredRightLineInLevel, final C successHandler) {
        return execute(successHandler, new Call<C>("SetLineInLevel") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"i4", "DesiredLeftLineInLevel", desiredLeftLineInLevel.getValue());
                setInput(invocation,"i4", "DesiredRightLineInLevel", desiredRightLineInLevel.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<GetLineInLevelResult>> C retrieveLineInLevel(final C successHandler) {
        return execute(successHandler, new Call<C>("GetLineInLevel") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final LeftLineInLevel currentLeftLineInLevel = LeftLineInLevel.getInstance((Long)getValue("i4",output[0].getValue()));
                final RightLineInLevel currentRightLineInLevel = RightLineInLevel.getInstance((Long)getValue("i4",output[1].getValue()));
                final GetLineInLevelResult value = GetLineInLevelResult.getInstance(currentLeftLineInLevel,currentRightLineInLevel);
                handler.success(value);
            }
        });
    }

    public <C extends Callback0> C selectAudio(final ObjectID objectID, final C successHandler) {
        return execute(successHandler, new Call<C>("SelectAudio") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "ObjectID", objectID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        final RightLineInLevel newRightLineInLevel = convertRightLineInLevel((Long)getValue("i4", ((StateVariableValue)values.get("RightLineInLevel")).getValue()));
        final RightLineInLevel oldRightLineInLevel = (RightLineInLevel)stored.get("RightLineInLevel");
        if (!Objects.equal(oldRightLineInLevel, newRightLineInLevel)) {
            _eventedValues.put("RightLineInLevel", newRightLineInLevel);
        }

        final LeftLineInLevel newLeftLineInLevel = convertLeftLineInLevel((Long)getValue("i4", ((StateVariableValue)values.get("LeftLineInLevel")).getValue()));
        final LeftLineInLevel oldLeftLineInLevel = (LeftLineInLevel)stored.get("LeftLineInLevel");
        if (!Objects.equal(oldLeftLineInLevel, newLeftLineInLevel)) {
            _eventedValues.put("LeftLineInLevel", newLeftLineInLevel);
        }

        final AudioInputName newAudioInputName = convertAudioInputName((String)getValue("string", ((StateVariableValue)values.get("AudioInputName")).getValue()));
        final AudioInputName oldAudioInputName = (AudioInputName)stored.get("AudioInputName");
        if (!Objects.equal(oldAudioInputName, newAudioInputName)) {
            _eventedValues.put("AudioInputName", newAudioInputName);
        }

        final LineInConnected newLineInConnected = convertLineInConnected((Boolean)getValue("boolean", ((StateVariableValue)values.get("LineInConnected")).getValue()));
        final LineInConnected oldLineInConnected = (LineInConnected)stored.get("LineInConnected");
        if (!Objects.equal(oldLineInConnected, newLineInConnected)) {
            _eventedValues.put("LineInConnected", newLineInConnected);
        }

        final Playing newPlaying = convertPlaying((Boolean)getValue("boolean", ((StateVariableValue)values.get("Playing")).getValue()));
        final Playing oldPlaying = (Playing)stored.get("Playing");
        if (!Objects.equal(oldPlaying, newPlaying)) {
            _eventedValues.put("Playing", newPlaying);
        }

        final Icon newIcon = convertIcon((String)getValue("string", ((StateVariableValue)values.get("Icon")).getValue()));
        final Icon oldIcon = (Icon)stored.get("Icon");
        if (!Objects.equal(oldIcon, newIcon)) {
            _eventedValues.put("Icon", newIcon);
        }

        // after the values were updated, send the change notifications

        if (!Objects.equal(oldRightLineInLevel, newRightLineInLevel)) {
            notifyRightLineInLevelChanged(oldRightLineInLevel, newRightLineInLevel);
        }

        if (!Objects.equal(oldLeftLineInLevel, newLeftLineInLevel)) {
            notifyLeftLineInLevelChanged(oldLeftLineInLevel, newLeftLineInLevel);
        }

        if (!Objects.equal(oldAudioInputName, newAudioInputName)) {
            notifyAudioInputNameChanged(oldAudioInputName, newAudioInputName);
        }

        if (!Objects.equal(oldLineInConnected, newLineInConnected)) {
            notifyLineInConnectedChanged(oldLineInConnected, newLineInConnected);
        }

        if (!Objects.equal(oldPlaying, newPlaying)) {
            notifyPlayingChanged(oldPlaying, newPlaying);
        }

        if (!Objects.equal(oldIcon, newIcon)) {
            notifyIconChanged(oldIcon, newIcon);
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


    public RightLineInLevel getRightLineInLevel() {
        return (RightLineInLevel)getEventedValueOrWait("RightLineInLevel");
    }

    public void addRightLineInLevelListener(EventListener<RightLineInLevel> listener) {
        synchronized(_changeRightLineInLevelListeners) {
            _changeRightLineInLevelListeners.add(listener);
        }
    }

    public void removeRightLineInLevelListener(EventListener<RightLineInLevel> listener) {
        synchronized(_changeRightLineInLevelListeners) {
            _changeRightLineInLevelListeners.remove(listener);
        }
    }

    protected void notifyRightLineInLevelChanged(RightLineInLevel oldValue, RightLineInLevel newValue) {
        final Iterable<EventListener<RightLineInLevel>> listeners;
        synchronized(_changeRightLineInLevelListeners) {
            listeners = new ArrayList<EventListener<RightLineInLevel>>(_changeRightLineInLevelListeners);            
        }
        for(EventListener<RightLineInLevel> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  RightLineInLevel convertRightLineInLevel(Long rawValue) {
        return RightLineInLevel.getInstance(rawValue);
    }

    public LeftLineInLevel getLeftLineInLevel() {
        return (LeftLineInLevel)getEventedValueOrWait("LeftLineInLevel");
    }

    public void addLeftLineInLevelListener(EventListener<LeftLineInLevel> listener) {
        synchronized(_changeLeftLineInLevelListeners) {
            _changeLeftLineInLevelListeners.add(listener);
        }
    }

    public void removeLeftLineInLevelListener(EventListener<LeftLineInLevel> listener) {
        synchronized(_changeLeftLineInLevelListeners) {
            _changeLeftLineInLevelListeners.remove(listener);
        }
    }

    protected void notifyLeftLineInLevelChanged(LeftLineInLevel oldValue, LeftLineInLevel newValue) {
        final Iterable<EventListener<LeftLineInLevel>> listeners;
        synchronized(_changeLeftLineInLevelListeners) {
            listeners = new ArrayList<EventListener<LeftLineInLevel>>(_changeLeftLineInLevelListeners);            
        }
        for(EventListener<LeftLineInLevel> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  LeftLineInLevel convertLeftLineInLevel(Long rawValue) {
        return LeftLineInLevel.getInstance(rawValue);
    }
    

    public AudioInputName getAudioInputName() {
        return (AudioInputName)getEventedValueOrWait("AudioInputName");
    }

    public void addAudioInputNameListener(EventListener<AudioInputName> listener) {
        synchronized(_changeAudioInputNameListeners) {
            _changeAudioInputNameListeners.add(listener);
        }
    }

    public void removeAudioInputNameListener(EventListener<AudioInputName> listener) {
        synchronized(_changeAudioInputNameListeners) {
            _changeAudioInputNameListeners.remove(listener);
        }
    }

    protected void notifyAudioInputNameChanged(AudioInputName oldValue, AudioInputName newValue) {
        final Iterable<EventListener<AudioInputName>> listeners;
        synchronized(_changeAudioInputNameListeners) {
            listeners = new ArrayList<EventListener<AudioInputName>>(_changeAudioInputNameListeners);            
        }
        for(EventListener<AudioInputName> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  AudioInputName convertAudioInputName(String rawValue) {
        return AudioInputName.getInstance(rawValue);
    }
    
    

    public LineInConnected getLineInConnected() {
        return (LineInConnected)getEventedValueOrWait("LineInConnected");
    }

    public void addLineInConnectedListener(EventListener<LineInConnected> listener) {
        synchronized(_changeLineInConnectedListeners) {
            _changeLineInConnectedListeners.add(listener);
        }
    }

    public void removeLineInConnectedListener(EventListener<LineInConnected> listener) {
        synchronized(_changeLineInConnectedListeners) {
            _changeLineInConnectedListeners.remove(listener);
        }
    }

    protected void notifyLineInConnectedChanged(LineInConnected oldValue, LineInConnected newValue) {
        final Iterable<EventListener<LineInConnected>> listeners;
        synchronized(_changeLineInConnectedListeners) {
            listeners = new ArrayList<EventListener<LineInConnected>>(_changeLineInConnectedListeners);            
        }
        for(EventListener<LineInConnected> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  LineInConnected convertLineInConnected(Boolean rawValue) {
        return LineInConnected.getInstance(rawValue);
    }

    public Playing getPlaying() {
        return (Playing)getEventedValueOrWait("Playing");
    }

    public void addPlayingListener(EventListener<Playing> listener) {
        synchronized(_changePlayingListeners) {
            _changePlayingListeners.add(listener);
        }
    }

    public void removePlayingListener(EventListener<Playing> listener) {
        synchronized(_changePlayingListeners) {
            _changePlayingListeners.remove(listener);
        }
    }

    protected void notifyPlayingChanged(Playing oldValue, Playing newValue) {
        final Iterable<EventListener<Playing>> listeners;
        synchronized(_changePlayingListeners) {
            listeners = new ArrayList<EventListener<Playing>>(_changePlayingListeners);            
        }
        for(EventListener<Playing> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  Playing convertPlaying(Boolean rawValue) {
        return Playing.getInstance(rawValue);
    }

    public Icon getIcon() {
        return (Icon)getEventedValueOrWait("Icon");
    }

    public void addIconListener(EventListener<Icon> listener) {
        synchronized(_changeIconListeners) {
            _changeIconListeners.add(listener);
        }
    }

    public void removeIconListener(EventListener<Icon> listener) {
        synchronized(_changeIconListeners) {
            _changeIconListeners.remove(listener);
        }
    }

    protected void notifyIconChanged(Icon oldValue, Icon newValue) {
        final Iterable<EventListener<Icon>> listeners;
        synchronized(_changeIconListeners) {
            listeners = new ArrayList<EventListener<Icon>>(_changeIconListeners);            
        }
        for(EventListener<Icon> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected  Icon convertIcon(String rawValue) {
        return Icon.getInstance(rawValue);
    }
}
