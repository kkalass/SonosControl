package de.kalass.sonoscontrol.api.model.avtransport;

public enum CurrentCrossfadeMode {
    ON(true),
    OFF(false);
    private final boolean _b;
    CurrentCrossfadeMode(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static CurrentCrossfadeMode valueOf(boolean b) {
        return b?ON:OFF;
    }
}
