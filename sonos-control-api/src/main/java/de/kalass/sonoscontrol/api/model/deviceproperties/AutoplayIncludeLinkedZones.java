package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum AutoplayIncludeLinkedZones {
    ON(true),
    OFF(false);
    private final boolean _b;
    AutoplayIncludeLinkedZones(final boolean value) {
        _b = value;
    }
    public boolean asBoolean() {
        return _b;
    }
    public static AutoplayIncludeLinkedZones valueOf(boolean b) {
        return b?ON:OFF;
    }
}
