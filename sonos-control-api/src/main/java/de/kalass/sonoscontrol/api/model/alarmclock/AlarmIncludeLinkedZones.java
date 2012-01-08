/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.alarmclock;

public enum AlarmIncludeLinkedZones {
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

    public static AlarmIncludeLinkedZones getInstance(Boolean b) {
        return b == null ? null : (b.booleanValue() ? ON : OFF);
    }

}
