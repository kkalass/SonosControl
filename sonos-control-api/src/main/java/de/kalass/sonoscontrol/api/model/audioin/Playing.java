package de.kalass.sonoscontrol.api.model.audioin;

public enum Playing {
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

    public static Playing getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
