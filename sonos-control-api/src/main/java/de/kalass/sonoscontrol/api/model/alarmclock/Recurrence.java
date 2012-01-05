/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.alarmclock;

public enum Recurrence {
    ONCE("ONCE"),
    WEEKDAYS("WEEKDAYS"),
    WEEKENDS("WEEKENDS"),
    DAILY("DAILY");

    private final String _value;

    Recurrence(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static Recurrence getInstance(String value) {
        for (Recurrence v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}