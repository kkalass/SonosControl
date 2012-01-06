/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;

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

public interface AudioInService {


    RightLineInLevel getRightLineInLevel();

    void addRightLineInLevelListener(EventListener<RightLineInLevel> listener);

    void removeRightLineInLevelListener(EventListener<RightLineInLevel> listener);

    LeftLineInLevel getLeftLineInLevel();

    void addLeftLineInLevelListener(EventListener<LeftLineInLevel> listener);

    void removeLeftLineInLevelListener(EventListener<LeftLineInLevel> listener);

    AudioInputName getAudioInputName();

    void addAudioInputNameListener(EventListener<AudioInputName> listener);

    void removeAudioInputNameListener(EventListener<AudioInputName> listener);

    LineInConnected getLineInConnected();

    void addLineInConnectedListener(EventListener<LineInConnected> listener);

    void removeLineInConnectedListener(EventListener<LineInConnected> listener);

    Playing getPlaying();

    void addPlayingListener(EventListener<Playing> listener);

    void removePlayingListener(EventListener<Playing> listener);

    Icon getIcon();

    void addIconListener(EventListener<Icon> listener);

    void removeIconListener(EventListener<Icon> listener);


    <C extends Callback1<TransportSettings>> C startTransmissionToGroup(MemberID coordinatorID, C callback);

    <C extends Callback0> C stopTransmissionToGroup(MemberID coordinatorID, C callback);

    <C extends Callback0> C setAudioInputAttributes(AudioInputName desiredName, Icon desiredIcon, C callback);

    <C extends Callback1<GetAudioInputAttributesResult>> C retrieveAudioInputAttributes(C callback);

    <C extends Callback0> C setLineInLevel(LeftLineInLevel desiredLeftLineInLevel, RightLineInLevel desiredRightLineInLevel, C callback);

    <C extends Callback1<GetLineInLevelResult>> C retrieveLineInLevel(C callback);

    <C extends Callback0> C selectAudio(ObjectID objectID, C callback);

}
