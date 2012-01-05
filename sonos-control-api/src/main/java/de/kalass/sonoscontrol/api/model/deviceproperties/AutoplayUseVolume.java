package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum AutoplayUseVolume {
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
    
    public static AutoplayUseVolume getInstance(boolean b) {
        return b ? ON : OFF;
    }
    
}
