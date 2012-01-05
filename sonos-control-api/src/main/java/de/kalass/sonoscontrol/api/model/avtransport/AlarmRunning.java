package de.kalass.sonoscontrol.api.model.avtransport;

public enum AlarmRunning {
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
    
    public static AlarmRunning getInstance(boolean b) {
        return b ? ON : OFF;
    }
    
}
