package de.kalass.sonoscontrol.api.model.alarmclock;

public enum AlarmEnabled {
    ON(true),
    OFF(false);
    private final boolean _b;
    AlarmEnabled(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static AlarmEnabled valueOf(boolean b) {
        return b?ON:OFF;
    }
}
