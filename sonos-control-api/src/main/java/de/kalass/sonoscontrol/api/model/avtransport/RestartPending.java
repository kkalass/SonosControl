package de.kalass.sonoscontrol.api.model.avtransport;

public enum RestartPending {
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
    
    public static RestartPending getInstance(boolean b) {
        return b ? ON : OFF;
    }
    
}
