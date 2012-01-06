package de.kalass.sonoscontrol.generator;

import java.util.Collection;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.model.JavaPackageName;
import de.kalass.sonoscontrol.generator.model.NameFactory;
import de.kalass.sonoscontrol.generator.model.ServiceNameFactory;

public final class NameFactoryImpl implements NameFactory {
    private final JavaPackageName _corePackageName;
    private final JavaPackageName _servicePackageName;
    private final JavaPackageName _modelBasePackageName;
    private final Function<String, Function<String, JavaClassName>> _mapping;
    private final Map<String, Collection<String>> _servicesByTypeName;

    public NameFactoryImpl(JavaPackageName corePackageName,
            JavaPackageName servicePackageName,
            JavaPackageName modelBasePackageName,
            Function<String, Function<String, JavaClassName>> mapping
            ) {
        super();
        _corePackageName = corePackageName;
        _servicePackageName = servicePackageName;
        _modelBasePackageName = modelBasePackageName;
        _mapping = Preconditions.checkNotNull(mapping);
        _servicesByTypeName = Maps.newHashMap();
    }

    @Override
    public JavaPackageName getCorePackageName() {
        return _corePackageName;
    }

    @Override
    public ServiceNameFactory getServiceNameFactory(String serviceName) {
        return new ServiceNameFactoryImpl(
                _servicePackageName, serviceName, _modelBasePackageName,
                _mapping.apply(serviceName),
                _servicesByTypeName
                );
    }

    public Map<String, Collection<String>> getServicesByTypeName() {
        return _servicesByTypeName;
    }

}