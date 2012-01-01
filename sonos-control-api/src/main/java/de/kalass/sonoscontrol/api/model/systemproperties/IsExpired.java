package de.kalass.sonoscontrol.api.model.systemproperties;

public enum IsExpired {
    ON(true),
    OFF(false);
    private final boolean _b;
    IsExpired(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static IsExpired valueOf(boolean b) {
        return b?ON:OFF;
    }
}
