package de.kalass.sonoscontrol.api.model.avtransport;

public enum AlarmIncludeLinkedZones {
    ON(true),
    OFF(false);
    private final boolean _b;
    AlarmIncludeLinkedZones(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static AlarmIncludeLinkedZones valueOf(boolean b) {
        return b?ON:OFF;
    }
}