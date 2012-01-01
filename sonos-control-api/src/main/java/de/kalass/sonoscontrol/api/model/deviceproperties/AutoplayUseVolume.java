package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum AutoplayUseVolume {
    ON(true),
    OFF(false);
    private final boolean _b;
    AutoplayUseVolume(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static AutoplayUseVolume valueOf(boolean b) {
        return b?ON:OFF;
    }
}
