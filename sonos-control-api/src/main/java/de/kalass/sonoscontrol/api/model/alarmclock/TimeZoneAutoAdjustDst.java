package de.kalass.sonoscontrol.api.model.alarmclock;

public enum TimeZoneAutoAdjustDst {
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
    
    public static TimeZoneAutoAdjustDst getInstance(boolean b) {
        return b ? ON : OFF;
    }
    
}
