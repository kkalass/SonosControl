/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.connectionmanager;

public enum ConnectionStatus {
    OK("OK"),
    CONTENT_FORMAT_MISMATCH("ContentFormatMismatch"),
    INSUFFICIENT_BANDWIDTH("InsufficientBandwidth"),
    UNRELIABLE_CHANNEL("UnreliableChannel"),
    UNKNOWN("Unknown");

    private final String _value;

    ConnectionStatus(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static ConnectionStatus getInstance(String value) {
        for (ConnectionStatus v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}