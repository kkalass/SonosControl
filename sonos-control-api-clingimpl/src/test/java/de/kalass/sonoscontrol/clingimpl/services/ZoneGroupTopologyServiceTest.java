/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.ZoneGroupTopologyService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology.UpdateItem;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.DiagnosticID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.CachedOnly;
import de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology.AvailableSoftwareUpdate;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateFlags;
import de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology.ZoneGroupState;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateURL;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.Version;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UnresponsiveDeviceActionType;
import de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology.ThirdPartyMediaServers;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.AlarmRunSequence;

public class ZoneGroupTopologyServiceTest extends AbstractSonosServiceTest<ZoneGroupTopologyService> {

    @Override
    protected ZoneGroupTopologyService extractService(SonosDevice device) {
        return device.getZoneGroupTopologyService();
    }

  @Override
    protected String getServiceName() {
        return "ZoneGroupTopologyService";
    }
    
    @Test
    public void testGetAvailableSoftwareUpdate() {
        final AvailableSoftwareUpdate value = getService().getLastValueForAvailableSoftwareUpdate();
        Assert.assertNotNull(value);
        System.out.println("Got AvailableSoftwareUpdate: " + value);
    }
    @Test
    public void testGetZoneGroupState() {
        final ZoneGroupState value = getService().getLastValueForZoneGroupState();
        Assert.assertNotNull(value);
        System.out.println("Got ZoneGroupState: " + value);
    }
    @Test
    public void testGetThirdPartyMediaServers() {
        final ThirdPartyMediaServers value = getService().getLastValueForThirdPartyMediaServers();
        Assert.assertNotNull(value);
        System.out.println("Got ThirdPartyMediaServers: " + value);
    }
    @Test
    public void testGetAlarmRunSequence() {
        final AlarmRunSequence value = getService().getLastValueForAlarmRunSequence();
        Assert.assertNotNull(value);
        System.out.println("Got AlarmRunSequence: " + value);
    }

}

