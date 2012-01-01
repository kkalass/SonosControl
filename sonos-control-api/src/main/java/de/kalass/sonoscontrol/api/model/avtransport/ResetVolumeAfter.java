package de.kalass.sonoscontrol.api.model.avtransport;

public enum ResetVolumeAfter {
    ON(true),
    OFF(false);
    private final boolean _b;
    ResetVolumeAfter(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static ResetVolumeAfter valueOf(boolean b) {
        return b?ON:OFF;
    }
}
