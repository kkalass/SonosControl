package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum RampType {
        SLEEP_TIMER_RAMP_TYPE("SLEEP_TIMER_RAMP_TYPE"),
        ALARM_RAMP_TYPE("ALARM_RAMP_TYPE"),
        AUTOPLAY_RAMP_TYPE("AUTOPLAY_RAMP_TYPE");

    private final String _value;

    RampType(String value) {
        _value = value;
    } 

    public String asString() {
        return _value;
    }

    public static RampType getInstance(String value) {
        for (RampType v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}