package de.kalass.sonoscontrol.api.model.avtransport;

public enum SnoozeRunning {
    ON(true),
    OFF(false);
    private final boolean _b;
    SnoozeRunning(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static SnoozeRunning valueOf(boolean b) {
        return b?ON:OFF;
    }
}
