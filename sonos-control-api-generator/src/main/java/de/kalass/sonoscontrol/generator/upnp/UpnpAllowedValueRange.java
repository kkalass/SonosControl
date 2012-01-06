package de.kalass.sonoscontrol.generator.upnp;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;

public final class UpnpAllowedValueRange {
    @Nonnull
    private final String _minimum;
    @Nonnull
    private final String _maximum;
    @CheckForNull
    private final String _step;

    public UpnpAllowedValueRange(@Nonnull String minimum, @Nonnull  String maximum, @Nullable String step) {
        _minimum = Preconditions.checkNotNull(minimum);
        _maximum = Preconditions.checkNotNull(maximum);
        _step = step;
    }

    public String getMinimum() {
        return _minimum;
    }

    public String getMaximum() {
        return _maximum;
    }

    public String getStep() {
        return _step;
    }
}