/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.SystemPropertiesService;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.systemproperties.VariableStringValue;
import de.kalass.sonoscontrol.api.model.systemproperties.IsExpired;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountID;
import de.kalass.sonoscontrol.api.model.systemproperties.VariableName;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountMd;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountType;
import de.kalass.sonoscontrol.api.model.systemproperties.StubsCreated;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountPassword;

public class SystemPropertiesServiceTest extends AbstractSonosServiceTest<SystemPropertiesService> {

    @Override
    protected SystemPropertiesService extractService(SonosDevice device) {
        return device.getSystemPropertiesService();
    }

  @Override
    protected String getServiceName() {
        return "SystemPropertiesService";
    }
    













    /*
    @Test
    public void doPostUpdateTasksTest() throws Exception{
        getService().doPostUpdateTasks(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished doPostUpdateTasks");
    }
    */

    /*
    @Test
    public void resetThirdPartyCredentialsTest() throws Exception{
        getService().resetThirdPartyCredentials(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished resetThirdPartyCredentials");
    }
    */
}

