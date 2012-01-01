package de.kalass.sonoscontrol.api.model.audioin;

public enum LineInConnected {
    ON(true),
    OFF(false);
    private final boolean _b;
    LineInConnected(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static LineInConnected valueOf(boolean b) {
        return b?ON:OFF;
    }
}
