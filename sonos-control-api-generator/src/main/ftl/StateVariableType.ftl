package ${data.javaClassName.package.FQN};

import java.io.Serializable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ${data.javaClassName.name} implements Serializable {
    private static final long serialVersionUID = 1L;

    <#if data.allowedValueRange??>
    public static final long MIN = ${data.allowedValueRange.minimum};
    public static final long MAX = ${data.allowedValueRange.maximum};
    <#if data.allowedValueRange.step??>
    public static final long STEP = ${data.allowedValueRange.step};
    </#if>
    </#if>

	private final ${data.dataType.javaClass.simpleName} _value;

    private ${data.javaClassName.name}(${data.dataType.javaClass.simpleName} value) {
		_value = Preconditions.checkNotNull(value);
		<#if data.allowedValueRange??>
		Preconditions.checkArgument(value.longValue() >= MIN && value.longValue() <= MAX);
        <#if data.allowedValueRange.step??>
		Preconditions.checkArgument(((value.longValue() -  MIN) % STEP) == 0);
		</#if>
        </#if>
    } 

    public ${data.dataType.javaClass.simpleName} as${data.dataType.javaClass.simpleName}() {
        return _value;
    }  
    
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }
    
    public int hashCode() {
        return Objects.hashCode(_value);
    }

    public boolean equals(Object other) {
        if (other instanceof ${data.javaClassName.name}) {
            ${data.javaClassName.name} obj = (${data.javaClassName.name})other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }

    public static ${data.javaClassName.name} getInstance(${data.dataType.javaClass.simpleName} value) {
        return value == null ? null : new ${data.javaClassName.name}(value);
    }
}
