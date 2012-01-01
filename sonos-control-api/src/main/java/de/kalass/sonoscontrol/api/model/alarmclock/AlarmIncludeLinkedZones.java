package de.kalass.sonoscontrol.api.model.alarmclock;

public enum AlarmIncludeLinkedZones {
    ON(true),
    OFF(false);
    private final boolean _b;
    AlarmIncludeLinkedZones(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static AlarmIncludeLinkedZones valueOf(boolean b) {
        return b?ON:OFF;
    }
}
