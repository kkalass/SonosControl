/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.zonegrouptopology;

public enum UpdateType {
        ALL("All"),
        SOFTWARE("Software");

    private final String _value;

    UpdateType(String value) {
        _value = value;
    } 

    public String asString() {
        return _value;
    }

    public static UpdateType getInstance(String value) {
        for (UpdateType v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}