

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package ${data.javaImplClassName.package.FQN};

import ${data.javaClassName.FQN};
import de.kalass.sonoscontrol.api.core.EventListener;

import org.teleal.cling.model.gena.GENASubscription;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.state.StateVariableValue;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

<#list data.neededImports as import>
import ${import.FQN};
</#list>

@SuppressWarnings("rawtypes")
public final class ${data.javaImplClassName.name} extends AbstractServiceImpl implements ${data.javaClassName.name} {
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();

    public ${data.javaImplClassName.name}(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("${data.upnpName}", upnpService, device, errorStrategy);
    }

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
                <#if action.out.type??>
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final ${action.out.type.relatedStateVariable.javaClassName.name} value = ${action.out.type.relatedStateVariable.javaClassName.name}.getInstance((${action.out.type.relatedStateVariable.dataType.javaClass.simpleName})getValue("${action.out.type.relatedStateVariable.dataType.value}",output[0].getValue()));
                 handler.success(value);
                <#else>
                <#if action.out.properties??>
                final ActionArgumentValue[] output = invocation.getOutput();
                <#list action.out.properties as param>
                final ${param.relatedStateVariable.javaClassName.name} value${param_index} = ${param.relatedStateVariable.javaClassName.name}.getInstance((${param.relatedStateVariable.dataType.javaClass.simpleName})getValue("${param.relatedStateVariable.dataType.value}",output[${param_index}].getValue()));
                </#list>
                final ${action.out.javaClassName.name} value = ${action.out.javaClassName.name}.getInstance(<#list action.out.properties as param>value${param_index}<#if param_has_next>,</#if></#list>);
                handler.success(value);
                <#else>
                // no return values
                handler.success();
                </#if>
                </#if>
            }
        });
    }
  </#list>

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);

        <#list data.stateVariables as stateVariable>
        <#if stateVariable.sendEvents>

        final ${stateVariable.javaClassName.name} new${stateVariable.stateVariableName} = convert${stateVariable.stateVariableName}((${stateVariable.dataType.javaClass.simpleName})getValue("${stateVariable.dataType.value}", ((StateVariableValue)values.get("${stateVariable.stateVariableName}")).getValue()));
        final ${stateVariable.javaClassName.name} old${stateVariable.stateVariableName} = (${stateVariable.javaClassName.name})stored.get("${stateVariable.stateVariableName}");
        if (!Objects.equal(old${stateVariable.stateVariableName}, new${stateVariable.stateVariableName})) {
            _eventedValues.put("${stateVariable.stateVariableName}", new${stateVariable.stateVariableName});
        }
        </#if>
        </#list>

        // after the values were updated, send the change notifications
        <#list data.stateVariables as stateVariable>
        <#if stateVariable.sendEvents>

        if (!Objects.equal(old${stateVariable.stateVariableName}, new${stateVariable.stateVariableName})) {
            notify${stateVariable.stateVariableName}Changed(old${stateVariable.stateVariableName}, new${stateVariable.stateVariableName});
        }
        </#if>
        </#list>

    }

    <#list data.stateVariables as stateVariable>
    <#if stateVariable.sendEvents>
    public ${stateVariable.javaClassName.name} get${stateVariable.stateVariableName}() {
        return (${stateVariable.javaClassName.name})_eventedValues.get("${stateVariable.stateVariableName}");
    }

    private final List<EventListener<${stateVariable.javaClassName.name}>> _change${stateVariable.stateVariableName}Listeners = new ArrayList<EventListener<${stateVariable.javaClassName.name}>>();

    public void add${stateVariable.stateVariableName}Listener(EventListener<${stateVariable.javaClassName.name}> listener) {
        synchronized(_change${stateVariable.stateVariableName}Listeners) {
            _change${stateVariable.stateVariableName}Listeners.add(listener);
        }
    }

    public void remove${stateVariable.stateVariableName}Listener(EventListener<${stateVariable.javaClassName.name}> listener) {
        synchronized(_change${stateVariable.stateVariableName}Listeners) {
            _change${stateVariable.stateVariableName}Listeners.remove(listener);
        }
    }

    protected void notify${stateVariable.stateVariableName}Changed(${stateVariable.javaClassName.name} oldValue, ${stateVariable.javaClassName.name} newValue) {
        final Iterable<EventListener<${stateVariable.javaClassName.name}>> listeners;
        synchronized(_change${stateVariable.stateVariableName}Listeners) {
            listeners = new ArrayList<EventListener<${stateVariable.javaClassName.name}>>(_change${stateVariable.stateVariableName}Listeners);            
        }
        for(EventListener<${stateVariable.javaClassName.name}> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected ${stateVariable.javaClassName.name} convert${stateVariable.stateVariableName}(${stateVariable.dataType.javaClass.simpleName} rawValue) {
        return ${stateVariable.javaClassName.name}.getInstance(rawValue);
    }
    </#if>
    </#list>
}
