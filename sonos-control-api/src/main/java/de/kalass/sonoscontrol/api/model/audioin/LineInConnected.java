/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.audioin;

public enum LineInConnected {
    ON() {
        public boolean getValue() {
            return true;
        }
    },
    OFF() {
        public boolean getValue() {
            return false;
        }
    };

    public abstract boolean getValue();

    public static LineInConnected getInstance(Boolean b) {
        return b == null ? null : (b.booleanValue() ? ON : OFF);
    }

}
