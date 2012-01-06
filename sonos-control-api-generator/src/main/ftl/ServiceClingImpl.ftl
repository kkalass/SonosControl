

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
import java.util.concurrent.CountDownLatch;

import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

<#list data.neededImports as import>
import ${import.FQN};
</#list>

@SuppressWarnings("rawtypes")
public final class ${data.javaImplClassName.name} extends AbstractServiceImpl implements ${data.javaClassName.name} {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(${data.javaImplClassName.name}.class);
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();
    private final CountDownLatch _eventsReceivedLatch = new CountDownLatch(1);
    <#list data.stateVariables as stateVariable>
    <#if stateVariable.sendEvents>
    private final List<EventListener<${stateVariable.type.javaClassName.name}>> _change${stateVariable.stateVariableName}Listeners = new ArrayList<EventListener<${stateVariable.type.javaClassName.name}>>();
    </#if>
    </#list>

    public ${data.javaImplClassName.name}(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("${data.upnpName}", upnpService, device, errorStrategy);
    }

  <#list data.actions as action>

    <#if action.anyInputArgumentHardcoded>
    /**
       <#list action.allIn as param>
       <#if param.valueHardcoded>
      * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link ${param.relatedStateVariable.type.javaClassName.name} ${param.parameterName}} is set to an appropriate default value automatically.</p>
       </#if>
       </#list>
      */
    </#if>
    public <C extends <#if action.out.javaClassName.FQN == 'java.lang.Void'>Callback0<#else>Callback1<${action.out.javaClassName.name}></#if
    >> C ${action.methodName}(<#list action.in as param>final ${param.relatedStateVariable.type.javaClassName.name} ${param.parameterName}, </#list>final C successHandler) {
        return execute(successHandler, new Call<C>("${action.upnpName}") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                <#list action.allIn as param>
                setInput(invocation,"${param.relatedStateVariable.type.dataType.value}", "${param.upnpName}", <#if param.valueHardcoded>${param.relatedStateVariable.type.javaClassName.name}.DEFAULT_VALUE<#else>${param.parameterName}</#if>.getValue());
                </#list>
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                <#if action.out.type??>
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final ${action.out.type.relatedStateVariable.type.javaClassName.name} value = ${action.out.type.relatedStateVariable.type.javaClassName.name}.getInstance((${action.out.type.relatedStateVariable.type.dataType.javaClass.simpleName})getValue("${action.out.type.relatedStateVariable.type.dataType.value}",output[0].getValue()));
                 handler.success(value);
                <#else>
                <#if action.out.properties??>
                final ActionArgumentValue[] output = invocation.getOutput();
                <#list action.out.properties as param>
                final ${param.relatedStateVariable.type.javaClassName.name} value${param_index} = ${param.relatedStateVariable.type.javaClassName.name}.getInstance((${param.relatedStateVariable.type.dataType.javaClass.simpleName})getValue("${param.relatedStateVariable.type.dataType.value}",output[${param_index}].getValue()));
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

        final ${stateVariable.type.javaClassName.name} new${stateVariable.stateVariableName} = convert${stateVariable.stateVariableName}((${stateVariable.type.dataType.javaClass.simpleName})getValue("${stateVariable.type.dataType.value}", ((StateVariableValue)values.get("${stateVariable.stateVariableName}")).getValue()));
        final ${stateVariable.type.javaClassName.name} old${stateVariable.stateVariableName} = (${stateVariable.type.javaClassName.name})stored.get("${stateVariable.stateVariableName}");
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
        _eventsReceivedLatch.countDown();
    }

    protected Object getEventedValueOrWait(String key) {
        try {
            _eventsReceivedLatch.await();
        } catch (InterruptedException e) {
            LOG.warn("waiting for evented value countdown latch was interrupted, will continue");
        }
        return _eventedValues.get(key);
    }

    <#list data.stateVariables as stateVariable>
    <#if stateVariable.sendEvents>

    public ${stateVariable.type.javaClassName.name} get${stateVariable.stateVariableName}() {
        return (${stateVariable.type.javaClassName.name})getEventedValueOrWait("${stateVariable.stateVariableName}");
    }

    public void add${stateVariable.stateVariableName}Listener(EventListener<${stateVariable.type.javaClassName.name}> listener) {
        synchronized(_change${stateVariable.stateVariableName}Listeners) {
            _change${stateVariable.stateVariableName}Listeners.add(listener);
        }
    }

    public void remove${stateVariable.stateVariableName}Listener(EventListener<${stateVariable.type.javaClassName.name}> listener) {
        synchronized(_change${stateVariable.stateVariableName}Listeners) {
            _change${stateVariable.stateVariableName}Listeners.remove(listener);
        }
    }

    protected void notify${stateVariable.stateVariableName}Changed(${stateVariable.type.javaClassName.name} oldValue, ${stateVariable.type.javaClassName.name} newValue) {
        final Iterable<EventListener<${stateVariable.type.javaClassName.name}>> listeners;
        synchronized(_change${stateVariable.stateVariableName}Listeners) {
            listeners = new ArrayList<EventListener<${stateVariable.type.javaClassName.name}>>(_change${stateVariable.stateVariableName}Listeners);            
        }
        for(EventListener<${stateVariable.type.javaClassName.name}> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected ${stateVariable.type.javaClassName.name} convert${stateVariable.stateVariableName}(${stateVariable.type.dataType.javaClass.simpleName} rawValue) {
        return ${stateVariable.type.javaClassName.name}.getInstance(rawValue);
    }
    </#if>
    </#list>
}
