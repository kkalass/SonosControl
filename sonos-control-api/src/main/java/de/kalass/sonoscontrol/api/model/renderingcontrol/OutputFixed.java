package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum OutputFixed {
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

    public static OutputFixed getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
