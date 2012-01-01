package de.kalass.sonoscontrol.api.model.alarmclock;

public enum TimeZoneAutoAdjustDst {
    ON(true),
    OFF(false);
    private final boolean _b;
    TimeZoneAutoAdjustDst(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static TimeZoneAutoAdjustDst valueOf(boolean b) {
        return b?ON:OFF;
    }
}
