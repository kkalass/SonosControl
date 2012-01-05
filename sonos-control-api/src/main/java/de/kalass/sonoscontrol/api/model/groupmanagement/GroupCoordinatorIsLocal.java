/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.groupmanagement;

public enum GroupCoordinatorIsLocal {
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

    public static GroupCoordinatorIsLocal getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
