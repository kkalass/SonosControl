/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.RenderingControlService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.renderingcontrol.LastRenderingControlChange;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Mute;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ResetBasicEQResult;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Volume;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeDB;
import de.kalass.sonoscontrol.api.model.renderingcontrol.GetVolumeDBRangeResult;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Bass;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Treble;
import de.kalass.sonoscontrol.api.model.renderingcontrol.EQValue;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Loudness;
import de.kalass.sonoscontrol.api.model.renderingcontrol.SupportsOutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.OutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.HeadphoneConnected;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RampTimeSeconds;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RampType;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeAdjustment;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RightVolume;
import de.kalass.sonoscontrol.api.model.renderingcontrol.MuteChannel;
import de.kalass.sonoscontrol.api.model.InstanceID;
import de.kalass.sonoscontrol.api.model.renderingcontrol.LeftVolume;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ProgramURI;
import de.kalass.sonoscontrol.api.model.renderingcontrol.EQType;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ChannelMap;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Channel;

public class RenderingControlServiceTest extends AbstractSonosServiceTest<RenderingControlService> {

    @Override
    protected RenderingControlService extractService(SonosDevice device) {
        return device.getRenderingControlService();
    }

  @Override
    protected String getServiceName() {
        return "RenderingControlService";
    }
    
    @Test
    public void testGetLastChange() {
        final LastRenderingControlChange value = getService().getLastValueForLastChange();
        Assert.assertNotNull(value);
        System.out.println("Got LastChange: " + value);
    }




    @Test
    public void resetBasicEQTest() throws Exception{
        final ResetBasicEQResult value = getService().resetBasicEQ(new de.kalass.sonoscontrol.api.core.AsyncValue<ResetBasicEQResult>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got resetBasicEQ: " + value);
    }








    @Test
    public void retrieveBassTest() throws Exception{
        final Bass value = getService().retrieveBass(new de.kalass.sonoscontrol.api.core.AsyncValue<Bass>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveBass: " + value);
    }


    @Test
    public void retrieveTrebleTest() throws Exception{
        final Treble value = getService().retrieveTreble(new de.kalass.sonoscontrol.api.core.AsyncValue<Treble>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveTreble: " + value);
    }






    @Test
    public void retrieveSupportsOutputFixedTest() throws Exception{
        final SupportsOutputFixed value = getService().retrieveSupportsOutputFixed(new de.kalass.sonoscontrol.api.core.AsyncValue<SupportsOutputFixed>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveSupportsOutputFixed: " + value);
    }

    @Test
    public void retrieveOutputFixedTest() throws Exception{
        final OutputFixed value = getService().retrieveOutputFixed(new de.kalass.sonoscontrol.api.core.AsyncValue<OutputFixed>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveOutputFixed: " + value);
    }


    @Test
    public void retrieveHeadphoneConnectedTest() throws Exception{
        final HeadphoneConnected value = getService().retrieveHeadphoneConnected(new de.kalass.sonoscontrol.api.core.AsyncValue<HeadphoneConnected>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got retrieveHeadphoneConnected: " + value);
    }



}

