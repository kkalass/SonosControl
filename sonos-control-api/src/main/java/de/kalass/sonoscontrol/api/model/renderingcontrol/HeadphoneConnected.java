package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum HeadphoneConnected {
    ON(true),
    OFF(false);
    private final boolean _b;
    HeadphoneConnected(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static HeadphoneConnected valueOf(boolean b) {
        return b?ON:OFF;
    }
}
