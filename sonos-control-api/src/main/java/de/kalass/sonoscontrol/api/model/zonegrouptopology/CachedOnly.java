package de.kalass.sonoscontrol.api.model.zonegrouptopology;

public enum CachedOnly {
    ON(true),
    OFF(false);
    private final boolean _b;
    CachedOnly(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static CachedOnly valueOf(boolean b) {
        return b?ON:OFF;
    }
}
