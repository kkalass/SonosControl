/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package ${data.javaClassName.package.FQN};

public enum ${data.javaClassName.name} {
    <#list data.allowedValues as value>
        ${value.enumValue}("${value.value}")<#if value_has_next>,<#else>;</#if>
    </#list>

    private final String _value;

    ${data.javaClassName.name}(String value) {
        _value = value;
    } 

    public String asString() {
        return _value;
    }

    public static ${data.javaClassName.name} getInstance(String value) {
        for (${data.javaClassName.name} v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}