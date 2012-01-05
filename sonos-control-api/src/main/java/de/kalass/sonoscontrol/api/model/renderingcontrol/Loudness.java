package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum Loudness {
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
    
    public static Loudness getInstance(boolean b) {
        return b ? ON : OFF;
    }
    
}
