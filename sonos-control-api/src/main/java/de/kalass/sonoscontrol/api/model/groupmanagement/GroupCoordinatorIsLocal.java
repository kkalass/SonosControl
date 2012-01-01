package de.kalass.sonoscontrol.api.model.groupmanagement;

public enum GroupCoordinatorIsLocal {
    ON(true),
    OFF(false);
    private final boolean _b;
    GroupCoordinatorIsLocal(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static GroupCoordinatorIsLocal valueOf(boolean b) {
        return b?ON:OFF;
    }
}
