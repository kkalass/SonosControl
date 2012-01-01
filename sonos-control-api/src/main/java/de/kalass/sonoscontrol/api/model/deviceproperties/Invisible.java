package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum Invisible {
    ON(true),
    OFF(false);
    private final boolean _b;
    Invisible(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static Invisible valueOf(boolean b) {
        return b?ON:OFF;
    }
}
