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

    public String getValue() {
        return _value;
    }

    public static UpdateType getInstance(String value) {
        if ("NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        for (UpdateType v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}