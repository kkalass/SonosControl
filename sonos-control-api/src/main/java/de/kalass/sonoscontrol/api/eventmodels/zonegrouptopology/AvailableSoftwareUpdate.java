/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.eventmodels.zonegrouptopology;

import java.io.Serializable;

import javax.annotation.Nonnull;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class AvailableSoftwareUpdate implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UpdateItem _updateItem;

    private AvailableSoftwareUpdate(@Nonnull UpdateItem updateItem) {
        _updateItem = Preconditions.checkNotNull(updateItem);
    }

    @Nonnull
    public UpdateItem getUpdateItem() {
        return _updateItem;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("updateItem", _updateItem).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_updateItem);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AvailableSoftwareUpdate) {
            AvailableSoftwareUpdate obj = (AvailableSoftwareUpdate)other;
            return Objects.equal(_updateItem, obj._updateItem);
        }
        return false;
    }

    public static AvailableSoftwareUpdate getInstance(UpdateItem updateItem) {
        return updateItem == null ? null : new AvailableSoftwareUpdate(updateItem);
    }
}
