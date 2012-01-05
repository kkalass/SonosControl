package de.kalass.sonoscontrol.api.model.avtransport;

public enum EnqueueAsNext {
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
    
    public static EnqueueAsNext getInstance(boolean b) {
        return b ? ON : OFF;
    }
    
}
