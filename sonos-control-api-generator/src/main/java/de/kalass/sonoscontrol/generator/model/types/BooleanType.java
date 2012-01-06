package de.kalass.sonoscontrol.generator.model.types;

import javax.annotation.Nonnull;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.upnp.UpnpDatatype;

public final class BooleanType extends CustomType {

    public BooleanType(@Nonnull UpnpDatatype upnpDataType, @Nonnull JavaClassName javaClassName) {
        super(Preconditions.checkNotNull(upnpDataType), Preconditions.checkNotNull(javaClassName));
    }

}