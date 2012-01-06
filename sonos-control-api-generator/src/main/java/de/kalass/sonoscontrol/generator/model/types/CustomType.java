package de.kalass.sonoscontrol.generator.model.types;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Function;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.upnp.UpnpDatatype;

public abstract class CustomType extends Type {
    public static final Function<CustomType, UpnpDatatype> GET_DATATYPE = new Function<CustomType, UpnpDatatype>() {
        @Override
        public UpnpDatatype apply(CustomType input) {
            return input._dataType;
        }
    };

    @Nonnull
    private final JavaClassName _javaClassName;
    @Nullable
    private final UpnpDatatype _dataType;

    public CustomType(@Nullable UpnpDatatype upnpDataType, @Nonnull JavaClassName javaClassName) {
        super(javaClassName);
        _javaClassName = javaClassName;
        _dataType = upnpDataType;
    }

    @Override
    @Nonnull
    public JavaClassName getJavaClassName() {
        return _javaClassName;
    }

    @CheckForNull
    public UpnpDatatype getDataType() {
        return _dataType;
    }
}