package de.kalass.sonoscontrol.api.model.avtransport;

public enum RestartPending {
    ON(true),
    OFF(false);
    private final boolean _b;
    RestartPending(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static RestartPending valueOf(boolean b) {
        return b?ON:OFF;
    }
}
