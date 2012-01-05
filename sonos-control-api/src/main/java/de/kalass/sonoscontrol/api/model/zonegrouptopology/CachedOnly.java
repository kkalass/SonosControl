/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.zonegrouptopology;

public enum CachedOnly {
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

    public static CachedOnly getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
