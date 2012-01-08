/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum Channel {
    MASTER("Master"),
    LF("LF"),
    RF("RF");

    private final String _value;

    Channel(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static Channel getInstance(String value) {
        if ("NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        for (Channel v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}