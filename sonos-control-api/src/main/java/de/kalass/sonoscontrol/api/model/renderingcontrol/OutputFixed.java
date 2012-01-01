package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum OutputFixed {
    ON(true),
    OFF(false);
    private final boolean _b;
    OutputFixed(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static OutputFixed valueOf(boolean b) {
        return b?ON:OFF;
    }
}
