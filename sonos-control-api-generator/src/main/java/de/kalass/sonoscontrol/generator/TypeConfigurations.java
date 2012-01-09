package de.kalass.sonoscontrol.generator;

import java.util.Map;

import javax.annotation.Nonnull;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.generator.model.JavaClassName;

public final class TypeConfigurations {


    public static final class Builder {
        private final ImmutableMap.Builder<String, TypeConfiguration> _generalMappings = ImmutableMap.builder();
        private final Map<String, ImmutableMap.Builder<String, TypeConfiguration>> _serviceMappings = Maps.newHashMap();

        private Builder() {
        }

        public void add(String typename, TypeConfiguration configuration) {
            _generalMappings.put(typename, configuration);
        }

        public void add(String typename, JavaClassName clsname) {
            add(typename, TypeConfiguration.builder().setJavaClassName(clsname).build());
        }

        public void add(String serviceName, String typename, TypeConfiguration configuration) {
            ImmutableMap.Builder<String, TypeConfiguration> map = _serviceMappings.get(serviceName);
            if (map == null) {
                map = ImmutableMap.builder();
                _serviceMappings.put(serviceName, map);
            }
            map.put(typename, configuration);
        }

        public void add(String serviceName, String typename, JavaClassName clsname) {
            add(serviceName, typename, TypeConfiguration.builder().setJavaClassName(clsname).build());
        }

        public void add(String serviceName, String typename, boolean customSerializationNeeded) {
            add(serviceName, typename, TypeConfiguration.builder().setCustomSerializationNeeded(customSerializationNeeded).build());
        }

        public TypeConfigurations build() {
            return new TypeConfigurations(_generalMappings.build(), ImmutableMap.copyOf(
                    Maps.transformValues(_serviceMappings, new Function<ImmutableMap.Builder<String, TypeConfiguration>, Map<String, TypeConfiguration>>() {
                        @Override
                        public Map<String, TypeConfiguration> apply(
                                com.google.common.collect.ImmutableMap.Builder<String, TypeConfiguration> input) {
                            return input.build();
                        }
                    })));
        }
    }

    private static final TypeConfiguration DEFAULT_CONFIG = TypeConfiguration.builder().build();
    private final Map<String, TypeConfiguration> _generalMappings;
    private final Map<String, Map<String, TypeConfiguration>> _serviceMappings;

    public TypeConfigurations(Map<String, TypeConfiguration> generalMappings, Map<String, Map<String, TypeConfiguration>> serviceMappings) {
        _generalMappings = ImmutableMap.copyOf(generalMappings);
        _serviceMappings = ImmutableMap.copyOf(serviceMappings);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public TypeConfiguration getConfiguration(@Nonnull String service, @Nonnull String typename) {
        final Map<String, TypeConfiguration> map = _serviceMappings.get(service);
        if (map != null) {
            TypeConfiguration typeConfiguration = map.get(typename);
            if (typeConfiguration != null) {
                return typeConfiguration;
            }
        }
        final TypeConfiguration generalConfig = _generalMappings.get(typename);
        if (generalConfig != null) {
            return generalConfig;
        }
        return DEFAULT_CONFIG;
    }

}