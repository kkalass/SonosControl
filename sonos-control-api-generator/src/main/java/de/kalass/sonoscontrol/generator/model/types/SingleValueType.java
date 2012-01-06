package de.kalass.sonoscontrol.generator.model.types;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.upnp.UpnpAllowedValueRange;
import de.kalass.sonoscontrol.generator.upnp.UpnpDatatype;

public final class SingleValueType extends CustomType {

    @CheckForNull
    private final UpnpAllowedValueRange _allowedValueRange;

    public SingleValueType(@Nonnull UpnpDatatype upnpDataType, @Nonnull JavaClassName javaClassName, @Nullable UpnpAllowedValueRange allowedValueRange) {
        super(Preconditions.checkNotNull(upnpDataType), Preconditions.checkNotNull(javaClassName));
        _allowedValueRange = allowedValueRange;
        if (_allowedValueRange != null) {
            if (!getDataType().getJavaClass().equals(Long.class)) {
                throw new IllegalArgumentException("don't know how to implement ranges for " + getDataType().getJavaClass() + ": " + getJavaClassName());
            }
        }
    }

    @CheckForNull
    public UpnpAllowedValueRange getAllowedValueRange() {
        return _allowedValueRange;
    }

}