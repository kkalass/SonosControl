package de.kalass.sonoscontrol.generator;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import de.kalass.sonoscontrol.generator.model.JavaClassName;

public final class TypeConfiguration {
    @CheckForNull
    private final JavaClassName _clsname;
    private final boolean _customDeserializerNeeded;

    public static final class Builder {
        private JavaClassName _clsname;
        private boolean _customDeserializerNeeded;
        private Builder() {
        }

        @CheckForNull
        public JavaClassName getJavaClassName() {
            return _clsname;
        }
        public TypeConfiguration.Builder setJavaClassName(JavaClassName clsname) {
            _clsname = clsname;
            return this;
        }
        public boolean isCustomSerializationNeeded() {
            return _customDeserializerNeeded;
        }
        public TypeConfiguration.Builder setCustomSerializationNeeded(boolean customDeserializerNeeded) {
            _customDeserializerNeeded = customDeserializerNeeded;
            return this;
        }

        @Nonnull
        public TypeConfiguration build() {
            return new TypeConfiguration(_clsname, _customDeserializerNeeded);
        }

    }

    private TypeConfiguration(@Nullable JavaClassName clsname,
            boolean customDeserializerNeeded) {
        super();
        _clsname = clsname;
        _customDeserializerNeeded = customDeserializerNeeded;
    }

    @Nonnull
    public static TypeConfiguration.Builder builder() {
        return new Builder();
    }

    @CheckForNull
    public JavaClassName getJavaClassName() {
        return _clsname;
    }

    public boolean isCustomSerializationNeeded() {
        return _customDeserializerNeeded;
    }

}