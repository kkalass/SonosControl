package de.kalass.sonoscontrol.api.model.avtransport;

public enum AlarmRunning {
    ON(true),
    OFF(false);
    private final boolean _b;
    AlarmRunning(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static AlarmRunning valueOf(boolean b) {
        return b?ON:OFF;
    }
}
