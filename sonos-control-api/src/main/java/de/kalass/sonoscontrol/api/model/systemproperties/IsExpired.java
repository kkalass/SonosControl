package de.kalass.sonoscontrol.api.model.systemproperties;

public enum IsExpired {
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

    public static IsExpired getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
