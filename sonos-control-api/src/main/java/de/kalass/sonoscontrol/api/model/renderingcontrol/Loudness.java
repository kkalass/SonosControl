package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum Loudness {
    ON(true),
    OFF(false);
    private final boolean _b;
    Loudness(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static Loudness valueOf(boolean b) {
        return b?ON:OFF;
    }
}
