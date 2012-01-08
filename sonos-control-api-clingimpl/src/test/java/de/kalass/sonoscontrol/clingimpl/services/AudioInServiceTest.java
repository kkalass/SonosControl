/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.AudioInService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

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

public class AudioInServiceTest extends AbstractSonosServiceTest<AudioInService> {

    @Override
    protected AudioInService extractService(SonosDevice device) {
        return device.getAudioInService();
    }

  @Override
    protected String getServiceName() {
        return "AudioInService";
    }
    
    @Test
    public void testGetRightLineInLevel() {
        final RightLineInLevel value = getService().getLastValueForRightLineInLevel();
        Assert.assertNotNull(value);
        System.out.println("Got RightLineInLevel: " + value);
    }
    @Test
    public void testGetLeftLineInLevel() {
        final LeftLineInLevel value = getService().getLastValueForLeftLineInLevel();
        Assert.assertNotNull(value);
        System.out.println("Got LeftLineInLevel: " + value);
    }
    @Test
    public void testGetAudioInputName() {
        final AudioInputName value = getService().getLastValueForAudioInputName();
        Assert.assertNotNull(value);
        System.out.println("Got AudioInputName: " + value);
    }
    @Test
    public void testGetLineInConnected() {
        final LineInConnected value = getService().getLastValueForLineInConnected();
        Assert.assertNotNull(value);
        System.out.println("Got LineInConnected: " + value);
    }
    @Test
    public void testGetPlaying() {
        final Playing value = getService().getLastValueForPlaying();
        Assert.assertNotNull(value);
        System.out.println("Got Playing: " + value);
    }
    @Test
    public void testGetIcon() {
        final Icon value = getService().getLastValueForIcon();
        Assert.assertNotNull(value);
        System.out.println("Got Icon: " + value);
    }





    @Test
    public void retrieveAudioInputAttributesTest() throws Exception{
        final GetAudioInputAttributesResult value = getService().retrieveAudioInputAttributes(new de.kalass.sonoscontrol.api.core.AsyncValue<GetAudioInputAttributesResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveAudioInputAttributes: " + value);
    }


    @Test
    public void retrieveLineInLevelTest() throws Exception{
        final GetLineInLevelResult value = getService().retrieveLineInLevel(new de.kalass.sonoscontrol.api.core.AsyncValue<GetLineInLevelResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveLineInLevel: " + value);
    }

}

