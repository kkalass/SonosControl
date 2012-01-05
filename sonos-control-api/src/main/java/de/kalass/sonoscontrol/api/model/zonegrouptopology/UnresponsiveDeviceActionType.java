package de.kalass.sonoscontrol.api.model.zonegrouptopology;

public enum UnresponsiveDeviceActionType {
        REMOVE("Remove"),
        VERIFY_THEN_REMOVE_SYSTEMWIDE("VerifyThenRemoveSystemwide");

    private final String _value;

    UnresponsiveDeviceActionType(String value) {
        _value = value;
    } 

    public String asString() {
        return _value;
    }

    public static UnresponsiveDeviceActionType getInstance(String value) {
        for (UnresponsiveDeviceActionType v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}