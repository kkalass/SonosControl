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
import de.kalass.sonoscontrol.api.eventmodels.renderingcontrol.LastRenderingControlChange;

public class RenderingControlServiceTest extends AbstractSonosServiceTest<RenderingControlService> {

    @Override
    protected RenderingControlService extractService(SonosDevice device) {
        return device.getRenderingControlService();
    }

    @Test
    public void testLastChange() {
        final LastRenderingControlChange value = getService().getLastChange();
        Assert.assertNotNull(value);
        System.out.println("Got LastChange: " + value);
    }

}

