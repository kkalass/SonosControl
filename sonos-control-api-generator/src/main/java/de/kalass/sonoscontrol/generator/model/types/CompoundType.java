package de.kalass.sonoscontrol.generator.model.types;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.model.Parameter;
import de.kalass.sonoscontrol.generator.model.Util;
import de.kalass.sonoscontrol.generator.upnp.UpnpDatatype;

public final class CompoundType extends CustomType {

    @Nonnull
    private final List<Parameter> _properties;

    public CompoundType(
            @Nullable UpnpDatatype upnpDataType, @Nonnull JavaClassName javaClassName,
            @Nonnull List<Parameter> properties) {
        super(upnpDataType, Preconditions.checkNotNull(javaClassName));
        _properties = properties;
    }

    public List<Parameter> getProperties() {
        return _properties;
    }

    public List<JavaClassName> getNeededImports() {
        final Iterable<JavaClassName> classNames = Iterables.transform(_properties, Parameter.GET_JAVA_CLASS_NAME);
        return Util.getNeededImports(getJavaClassName().getPackage(), classNames);
    }

}