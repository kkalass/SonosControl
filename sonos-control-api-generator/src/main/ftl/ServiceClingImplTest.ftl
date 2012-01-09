package ${data.javaImplClassName.package.FQN};

import ${data.javaClassName.FQN};
import org.testng.Assert;
import org.testng.annotations.Test;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.clingimpl.AbstractSonosServiceTest;

<#list data.neededImports as import>
import ${import.FQN};
</#list>

public class ${data.javaClassName.name}Test extends AbstractSonosServiceTest<${data.javaClassName.name}> {

    @Override
    protected ${data.javaClassName.name} extractService(SonosDevice device) {
        return device.get${data.javaClassName.name}();
    }

  @Override
    protected String getServiceName() {
        return "${data.javaClassName.name}";
    }
    
    <#list data.stateVariables as stateVariable>
    <#if stateVariable.sendEvents>
    @Test
    public void testGet${stateVariable.stateVariableName}() {
        final ${stateVariable.type.javaClassName.name} value = getService().getLastValueFor${stateVariable.stateVariableName}();
        Assert.assertNotNull(value);
        System.out.println("Got ${stateVariable.stateVariableName}: " + value);
    }
    </#if> 
    </#list>

<#list data.actions as action>

    <#if action.noArguments>
    <#if action.out.void??>
    /*
    @Test
    public void ${action.methodName}Test() throws Exception{
        getService().${action.methodName}(new de.kalass.sonoscontrol.api.core.VoidCallback()).waitForSuccess();
        System.out.println("Finished ${action.methodName}");
    }
    */
    <#else>
    @Test
    public void ${action.methodName}Test() throws Exception{
        final ${action.out.javaClassName.name} value = getService().${action.methodName}(new de.kalass.sonoscontrol.api.core.AsyncValue<${action.out.javaClassName.name}>()).get();
        Assert.assertNotNull(value);
        System.out.println("Got ${action.methodName}: " + value);
    }
    </#if>
    </#if>
  </#list>
}

