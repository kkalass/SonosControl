package de.kalass.sonoscontrol.generator;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.generator.model.JavaClassName;

public final class TypeNameMappings {
    private final Map<String, JavaClassName> _generalMappings = Maps.newHashMap();
    private final Map<String, Map<String, JavaClassName>> _serviceMappings = Maps.newHashMap();
    private boolean _serviceStage;
    public void add(String typename, JavaClassName clsname) {
        if (_serviceStage) {
            throw new IllegalStateException("first finish all general type mappings, before doing service-specific ones");
        }
        _generalMappings.put(typename, clsname);
    }
    public void add(String serviceName, String typename, JavaClassName clsname) {
        _serviceStage = true;
        Map<String, JavaClassName> map = _serviceMappings.get(serviceName);
        if (map == null) {
            map = Maps.newHashMap();
            map.putAll(_generalMappings);
            _serviceMappings.put(serviceName, map);
        }
        map.put(typename, clsname);
    }
    public Function<String, Function<String, JavaClassName>> asFkt() {
        Map<String, Function<String, JavaClassName>> m = Maps.transformValues(_serviceMappings, new Function<Map<String, JavaClassName>, Function<String, JavaClassName>>() {
            @Override
            public Function<String, JavaClassName> apply(
                    Map<String, JavaClassName> input) {
                return Functions.forMap(input, null);
            }
        });
        return Functions.forMap(m, Functions.forMap(_generalMappings, null));
    }
}