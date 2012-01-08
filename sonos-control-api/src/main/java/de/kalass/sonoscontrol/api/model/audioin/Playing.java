/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.audioin;

public enum Playing {
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

    public static Playing getInstance(Boolean b) {
        return b == null ? null : (b.booleanValue() ? ON : OFF);
    }

}
