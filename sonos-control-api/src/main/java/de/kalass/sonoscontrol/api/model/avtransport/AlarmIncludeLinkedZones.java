package de.kalass.sonoscontrol.api.model.avtransport;

public enum AlarmIncludeLinkedZones {
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

    public static AlarmIncludeLinkedZones getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
