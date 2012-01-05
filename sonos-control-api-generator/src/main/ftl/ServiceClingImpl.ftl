

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package ${data.javaClassName.package.FQN};

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

<#list data.neededImports as import>
import ${import.FQN};
</#list>

@SuppressWarnings("rawtypes")
public final class ${data.javaClassName.name} extends AbstractServiceImpl {

    public ${data.javaClassName.name}(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("${data.upnpName}", upnpService, device, errorStrategy);
    }

  <#list data.stateVariables as stateVariable>
    <#if stateVariable.sendEvents>

    public ${stateVariable.javaClassName.name} get${stateVariable.stateVariableName}() {
        throw new UnsupportedOperationException();
    }
    </#if>
  </#list>

  <#list data.actions as action>

    <#if action.anyInputArgumentHardcoded>
    /**
       <#list action.allIn as param>
       <#if param.valueHardcoded>
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link ${param.relatedStateVariable.javaClassName.name} ${param.parameterName}} is set to an appropriate default value automatically.</p>
       </#if>
       </#list>
      */
    </#if>
    public <C extends <#if action.out.javaClassName.FQN == 'java.lang.Void'>Callback0<#else>Callback1<${action.out.javaClassName.name}></#if
    >> C ${action.methodName}(<#list action.in as param>final ${param.relatedStateVariable.javaClassName.name} ${param.parameterName}, </#list>final C successHandler) {
        return execute(successHandler, new Call<C>("${action.upnpName}") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                <#list action.allIn as param>
                setInput(invocation,"${param.relatedStateVariable.dataType.value}", "${param.upnpName}", <#if param.valueHardcoded>${param.relatedStateVariable.javaClassName.name}.DEFAULT_VALUE<#else>${param.parameterName}</#if>.getValue());
                </#list>
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                handler.success();
            }
        });
    }
  </#list>

}
