package de.kalass.sonoscontrol.generator.upnp;

import java.util.List;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;

public final class UpnpStateVariable {
    @Nonnull
    private final String name;
    @Nonnull
    private final UpnpDatatype dataType;
    @Nonnull
    private final List<String> allowedValueList;
    @CheckForNull
    private final UpnpAllowedValueRange allowedValueRange;
    private final boolean _sendEvents;

    public UpnpStateVariable(
            @Nonnull String name,
            @Nonnull UpnpDatatype dataType,
            boolean sendEvents,
            @Nonnull List<String> allowedValueList,
            @Nullable
            UpnpAllowedValueRange allowedValueRange
            ) {
        super();
        _sendEvents = sendEvents;
        this.name = Preconditions.checkNotNull(name);
        this.dataType = Preconditions.checkNotNull(dataType);
        this.allowedValueList = Preconditions.checkNotNull(allowedValueList);
        this.allowedValueRange = allowedValueRange;
    }

    public boolean isSendEvents() {
        return _sendEvents;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public UpnpDatatype getDataType() {
        return dataType;
    }

    @Nonnull
    public List<String> getAllowedValueList() {
        return allowedValueList;
    }

    @CheckForNull
    public UpnpAllowedValueRange getAllowedValueRange() {
        return allowedValueRange;
    }
}