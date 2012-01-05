/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum AutoplayIncludeLinkedZones {
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

    public static AutoplayIncludeLinkedZones getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
