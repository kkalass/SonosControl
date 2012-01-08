package de.kalass.sonoscontrol.generator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.model.JavaPackageName;
import de.kalass.sonoscontrol.generator.model.ServiceNameFactory;

public final class ServiceNameFactoryImpl implements ServiceNameFactory {
    private final JavaPackageName _servicePackageName;
    private final String _serviceName;
    private final JavaPackageName _modelPackageName;
    private final Map<String, Collection<String>> _servicesByTypeName;
    private final TypeConfigurations _typeConfigs;

    ServiceNameFactoryImpl(
            JavaPackageName servicePackageName,
            String serviceName,
            JavaPackageName modelbasePackageName,
            TypeConfigurations typeConfigs,
            Map<String, Collection<String>> servicesByTypeName
            ) {
        _serviceName = serviceName;
        _typeConfigs = Preconditions.checkNotNull(typeConfigs);
        _servicePackageName = servicePackageName;
        _modelPackageName = modelbasePackageName.childPackage(serviceName.toLowerCase());
        _servicesByTypeName = servicesByTypeName;
    }
    @Override
    public JavaClassName getServiceClassName() {
        return _servicePackageName.childClass(_serviceName + "Service");
    }
    @Override
    public JavaClassName getModelClassName(String nameInput) {
        String name = nameInput.startsWith("A_ARG_TYPE_") ? nameInput.substring("A_ARG_TYPE_".length()): nameInput;
        final TypeConfiguration config = _typeConfigs.getConfiguration(_serviceName, name);
        final JavaClassName mappedJavaClassName = config.getJavaClassName();
        Collection<String> names = _servicesByTypeName.get(name);
        if (names == null) {
            names = new HashSet<String>();
            _servicesByTypeName.put(name, names);
        }
        names.add(_serviceName);
        return mappedJavaClassName == null ? _modelPackageName.childClass(name) : mappedJavaClassName;
    }
}