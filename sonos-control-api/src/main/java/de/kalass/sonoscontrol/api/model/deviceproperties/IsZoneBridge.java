package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum IsZoneBridge {
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
    
    public static IsZoneBridge getInstance(boolean b) {
        return b ? ON : OFF;
    }
    
}
