/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.connectionmanager;

public enum Direction {
    INPUT("Input"),
    OUTPUT("Output");

    private final String _value;

    Direction(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static Direction getInstance(String value) {
        if ("NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        for (Direction v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}