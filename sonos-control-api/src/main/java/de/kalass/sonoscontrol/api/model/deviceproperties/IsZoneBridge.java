package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum IsZoneBridge {
    ON(true),
    OFF(false);
    private final boolean _b;
    IsZoneBridge(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static IsZoneBridge valueOf(boolean b) {
        return b?ON:OFF;
    }
}
