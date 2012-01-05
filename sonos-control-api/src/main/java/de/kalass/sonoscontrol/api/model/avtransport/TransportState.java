/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

public enum TransportState {
        STOPPED("STOPPED"),
        PLAYING("PLAYING"),
        PAUSED_PLAYBACK("PAUSED_PLAYBACK"),
        TRANSITIONING("TRANSITIONING");

    private final String _value;

    TransportState(String value) {
        _value = value;
    } 

    public String asString() {
        return _value;
    }

    public static TransportState getInstance(String value) {
        for (TransportState v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}