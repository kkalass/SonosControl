/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum ResetVolumeAfter {
    ON() {
        public boolean asBoolean() {
            return true;
        }
    },
    OFF() {
        public boolean asBoolean() {
            return false;
        }
    };

    public abstract boolean asBoolean();

    public static ResetVolumeAfter getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
