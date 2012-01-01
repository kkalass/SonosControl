package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum Mute {
    ON(true),
    OFF(false);
    private final boolean _b;
    Mute(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static Mute valueOf(boolean b) {
        return b?ON:OFF;
    }
}
