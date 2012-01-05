

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AudioInService;
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

    public AudioInServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("AudioIn", upnpService, device, errorStrategy);
    }


    public RightLineInLevel getRightLineInLevel() {
        throw new UnsupportedOperationException();
    }

    public LeftLineInLevel getLeftLineInLevel() {
        throw new UnsupportedOperationException();
    }

    public AudioInputName getAudioInputName() {
        throw new UnsupportedOperationException();
    }

    public LineInConnected getLineInConnected() {
        throw new UnsupportedOperationException();
    }

    public Playing getPlaying() {
        throw new UnsupportedOperationException();
    }

    public Icon getIcon() {
        throw new UnsupportedOperationException();
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
                 final TransportSettings value = TransportSettings.getInstance(getString("string",output[0].getValue()));
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
                final AudioInputName value0 = AudioInputName.getInstance(getString("string",output[0].getValue()));
                final Icon value1 = Icon.getInstance(getString("string",output[1].getValue()));
                final GetAudioInputAttributesResult value = GetAudioInputAttributesResult.getInstance(value0,value1);
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
                final LeftLineInLevel value0 = LeftLineInLevel.getInstance(getLong("i4",output[0].getValue()));
                final RightLineInLevel value1 = RightLineInLevel.getInstance(getLong("i4",output[1].getValue()));
                final GetLineInLevelResult value = GetLineInLevelResult.getInstance(value0,value1);
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

}
