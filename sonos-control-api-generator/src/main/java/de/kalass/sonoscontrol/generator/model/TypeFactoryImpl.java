package de.kalass.sonoscontrol.generator.model;

import java.util.Map;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.generator.TypeConfiguration;
import de.kalass.sonoscontrol.generator.TypeConfigurations;
import de.kalass.sonoscontrol.generator.model.Service.TypeFactory;
import de.kalass.sonoscontrol.generator.model.types.BooleanType;
import de.kalass.sonoscontrol.generator.model.types.EnumType;
import de.kalass.sonoscontrol.generator.model.types.SingleValueType;
import de.kalass.sonoscontrol.generator.model.types.Type;
import de.kalass.sonoscontrol.generator.upnp.UpnpDatatype;
import de.kalass.sonoscontrol.generator.upnp.UpnpStateVariable;

public class TypeFactoryImpl implements TypeFactory {
    private final TypeConfigurations _configurations;

    public TypeFactoryImpl(TypeConfigurations configurations) {
        _configurations = configurations;
    }

    @Override
    public Type getType(
            String serviceName,
            UpnpStateVariable stateVariable,
            Map<String, JavaClassName> javaClassesByStateVariableName
            ) {
        String name = stateVariable.getName();
        final JavaClassName javaClassName = Preconditions.checkNotNull(javaClassesByStateVariableName.get(name));
        final UpnpDatatype upnpDataType = stateVariable.getDataType();

        if (javaClassName.getFQN().startsWith("java.")) {
            // definitely not a custom type
            return new Type(javaClassName);
        }

        if ("boolean".equals(upnpDataType.getValue())) {
            return new BooleanType(upnpDataType, javaClassName);
        }
        if (!stateVariable.getAllowedValueList().isEmpty()) {
            return new EnumType(upnpDataType, javaClassName, stateVariable.getAllowedValueList());
        }
        final TypeConfiguration configuration = _configurations.getConfiguration(serviceName, name.startsWith("A_ARG_TYPE_") ? name.substring("A_ARG_TYPE_".length()):name);
        return new SingleValueType(upnpDataType, javaClassName, stateVariable.getAllowedValueRange(), configuration.isCustomSerializationNeeded());
    }
}