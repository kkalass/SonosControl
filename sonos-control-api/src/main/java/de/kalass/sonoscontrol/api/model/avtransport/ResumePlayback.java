package de.kalass.sonoscontrol.api.model.avtransport;

public enum ResumePlayback {
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
    
    public static ResumePlayback getInstance(boolean b) {
        return b ? ON : OFF;
    }
    
}
