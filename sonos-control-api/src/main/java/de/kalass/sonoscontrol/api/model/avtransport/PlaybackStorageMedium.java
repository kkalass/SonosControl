/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

public enum PlaybackStorageMedium {
    NONE("NONE"),
    NETWORK("NETWORK");

    private final String _value;

    PlaybackStorageMedium(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static PlaybackStorageMedium getInstance(String value) {
        for (PlaybackStorageMedium v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}