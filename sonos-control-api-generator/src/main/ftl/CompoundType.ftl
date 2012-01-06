/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package ${data.javaClassName.package.FQN};

import com.google.common.base.Objects;
import java.io.Serializable;

<#list data.neededImports as import>
import ${import.FQN};
</#list>

public final class ${data.javaClassName.name} implements Serializable {
    private static final long serialVersionUID = 1L;

    <#list data.properties as prop>
    private final ${prop.type.javaClassName.name} _${prop.parameterName};
    </#list>

    private ${data.javaClassName.name}(
        <#list data.properties as prop>
        final ${prop.type.javaClassName.name} ${prop.parameterName}<#if prop_has_next>,</#if>
        </#list>
    ) {
        <#list data.properties as prop>
        _${prop.parameterName} = ${prop.parameterName};
        </#list>
    } 

    public static ${data.javaClassName.name} getInstance(
        <#list data.properties as prop>
        final ${prop.type.javaClassName.name} ${prop.parameterName}<#if prop_has_next>,</#if>
        </#list>
    ) {
        return new ${data.javaClassName.name}(<#list data.properties as prop>${prop.parameterName}<#if prop_has_next>, </#if></#list>);
    } 
    <#list data.properties as prop>
    public ${prop.type.javaClassName.name} ${prop.getterName}() {
        return _${prop.parameterName};
    }
    </#list>

    public String toString() {
        return Objects.toStringHelper(this)
        <#list data.properties as prop>
        .add("${prop.parameterName}", _${prop.parameterName})
        </#list>
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
        <#list data.properties as prop>
            _${prop.parameterName}<#if prop_has_next>,</#if>
        </#list>
        );
    }

    public boolean equals(Object other) {
        if (other instanceof ${data.javaClassName.name}) {
            ${data.javaClassName.name} obj = (${data.javaClassName.name})other;
            return 
                <#list data.properties as prop>
                    Objects.equal(_${prop.parameterName}, obj._${prop.parameterName}) <#if prop_has_next>&&</#if>
                </#list>
            ;
        }
        return false;
    }

}
