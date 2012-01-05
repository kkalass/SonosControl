/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.audioin.TransportSettings;
import de.kalass.sonoscontrol.api.model.audioin.AudioInputAttributes;
import de.kalass.sonoscontrol.api.model.audioin.LineInLevel;
import de.kalass.sonoscontrol.api.model.audioin.RightLineInLevel;
import de.kalass.sonoscontrol.api.model.audioin.LeftLineInLevel;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.audioin.AudioInputName;
import de.kalass.sonoscontrol.api.model.audioin.ObjectID;
import de.kalass.sonoscontrol.api.model.audioin.LineInConnected;
import de.kalass.sonoscontrol.api.model.audioin.Playing;
import de.kalass.sonoscontrol.api.model.audioin.Icon;

public interface AudioInService {


    RightLineInLevel getRightLineInLevel();

    LeftLineInLevel getLeftLineInLevel();

    AudioInputName getAudioInputName();

    LineInConnected getLineInConnected();

    Playing getPlaying();

    Icon getIcon();


    <C extends Callback1<TransportSettings>> C startTransmissionToGroup(MemberID coordinatorID, C callback);

    <C extends Callback0> C stopTransmissionToGroup(MemberID coordinatorID, C callback);

    <C extends Callback0> C setAudioInputAttributes(AudioInputName desiredName, Icon desiredIcon, C callback);

    <C extends Callback1<AudioInputAttributes>> C retrieveAudioInputAttributes(C callback);

    <C extends Callback0> C setLineInLevel(LeftLineInLevel desiredLeftLineInLevel, RightLineInLevel desiredRightLineInLevel, C callback);

    <C extends Callback1<LineInLevel>> C retrieveLineInLevel(C callback);

    <C extends Callback0> C selectAudio(ObjectID objectID, C callback);

}
