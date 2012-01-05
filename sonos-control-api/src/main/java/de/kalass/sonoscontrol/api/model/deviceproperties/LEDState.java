package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum LEDState {
        ON("On"),
        OFF("Off");

    private final String _value;

    LEDState(String value) {
        _value = value;
    } 

    public String asString() {
        return _value;
    }

    public static LEDState getInstance(String value) {
        for (LEDState v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}