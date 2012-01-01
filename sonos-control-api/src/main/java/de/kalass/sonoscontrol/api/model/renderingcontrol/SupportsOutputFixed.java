package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum SupportsOutputFixed {
    ON(true),
    OFF(false);
    private final boolean _b;
    SupportsOutputFixed(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static SupportsOutputFixed valueOf(boolean b) {
        return b?ON:OFF;
    }
}
