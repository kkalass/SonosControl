/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
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

    <#list data.stateVariables as stateVariable>
    <#if stateVariable.sendEvents>
    @Test
    public void testGet${stateVariable.stateVariableName}() {
        final ${stateVariable.type.javaClassName.name} value = getService().get${stateVariable.stateVariableName}();
        Assert.assertNotNull(value);
        System.out.println("Got ${stateVariable.stateVariableName}: " + value);
    }
    </#if> 
    </#list>

}

