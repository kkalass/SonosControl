/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum LEDState {
    ON("On"),
    OFF("Off");

    private final String _value;

    LEDState(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static LEDState getInstance(String value) {
        if ("NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        for (LEDState v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}