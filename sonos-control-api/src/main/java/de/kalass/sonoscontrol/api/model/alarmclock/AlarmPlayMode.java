/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.alarmclock;

public enum AlarmPlayMode {
    NORMAL("NORMAL"),
    REPEAT_ALL("REPEAT_ALL"),
    SHUFFLE_NOREPEAT("SHUFFLE_NOREPEAT"),
    SHUFFLE("SHUFFLE");

    private final String _value;

    AlarmPlayMode(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static AlarmPlayMode getInstance(String value) {
        for (AlarmPlayMode v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}