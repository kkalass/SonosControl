package de.kalass.sonoscontrol.generator.model.types;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import de.kalass.sonoscontrol.generator.model.AllowedValue;
import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.upnp.UpnpDatatype;

public final class EnumType extends CustomType {

    @Nonnull
    private final List<AllowedValue> _allowedValueList;

    public EnumType(@Nonnull UpnpDatatype upnpDataType, @Nonnull JavaClassName javaClassName, @Nonnull List<String> allowedValueList) {
        super(Preconditions.checkNotNull(upnpDataType), Preconditions.checkNotNull(javaClassName));
        _allowedValueList = Lists.transform(allowedValueList, new Function<String, AllowedValue>() {
            @Override
            public AllowedValue apply(String input) {
                return new AllowedValue(input);
            }
        });

    }

    public boolean isSingleInstanceType() {
        // the type is restricted, but there is only one valid value...
        // one example of this currently (1.1.2012) is TransportPlaySpeed
        return _allowedValueList.size() == 1;
    }

    @Nonnull
    public List<AllowedValue> getAllowedValues() {
        return _allowedValueList;
    }

}