package de.kalass.sonoscontrol.generator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.model.JavaPackageName;
import de.kalass.sonoscontrol.generator.model.ServiceNameFactory;

public final class ServiceNameFactoryImpl implements ServiceNameFactory {
    private final JavaPackageName _servicePackageName;
    private final String _serviceName;
    private final JavaPackageName _modelPackageName;
    private final Map<String, Collection<String>> _servicesByTypeName;
    private final Function<String, JavaClassName> _mapping;

    ServiceNameFactoryImpl(
            JavaPackageName servicePackageName,
            String serviceName,
            JavaPackageName modelbasePackageName,
            Function<String, JavaClassName> mapping,
            Map<String, Collection<String>> servicesByTypeName
            ) {
        _serviceName = serviceName;
        _mapping = Preconditions.checkNotNull(mapping);
        _servicePackageName = servicePackageName;
        _modelPackageName = modelbasePackageName.childPackage(serviceName.toLowerCase());
        _servicesByTypeName = servicesByTypeName;
    }
    @Override
    public JavaClassName getServiceClassName() {
        return _servicePackageName.childClass(_serviceName + "Service");
    }
    @Override
    public JavaClassName getModelClassName(String name) {
        final JavaClassName javaClassName = _mapping.apply(name);
        Collection<String> names = _servicesByTypeName.get(name);
        if (names == null) {
            names = new HashSet<String>();
            _servicesByTypeName.put(name, names);
        }
        names.add(_serviceName);
        return javaClassName == null ? _modelPackageName.childClass(name) : javaClassName;
    }
}