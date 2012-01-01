package de.kalass.sonoscontrol.api.model.audioin;

public enum Playing {
    ON(true),
    OFF(false);
    private final boolean _b;
    Playing(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static Playing valueOf(boolean b) {
        return b?ON:OFF;
    }
}
