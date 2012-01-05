/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

public enum RecordStorageMedium {
        NONE("NONE");

    private final String _value;

    RecordStorageMedium(String value) {
        _value = value;
    } 

    public String asString() {
        return _value;
    }

    public static RecordStorageMedium getInstance(String value) {
        for (RecordStorageMedium v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}