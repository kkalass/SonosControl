package ${data.javaClassName.package.FQN};

import com.google.common.base.Objects;

<#list data.neededImports as import>
import ${import.FQN};
</#list>

public interface ${data.javaClassName.name} {

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
    <C extends <#if action.out.javaClassName.FQN == 'java.lang.Void'>Callback0<#else>Callback1<${action.out.javaClassName.name}></#if
    >> C ${action.methodName}(<#list action.in as param>${param.relatedStateVariable.javaClassName.name} ${param.parameterName}, </#list>C callback);
  </#list>

}
