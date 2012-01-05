/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.audioin;

public enum LineInConnected {
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

    public static LineInConnected getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
