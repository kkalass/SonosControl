/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.groupmanagement;

public enum GroupCoordinatorIsLocal {
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

    public static GroupCoordinatorIsLocal getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
