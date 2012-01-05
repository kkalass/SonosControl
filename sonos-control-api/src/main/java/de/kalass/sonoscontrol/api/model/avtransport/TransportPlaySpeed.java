/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.avtransport;

public enum TransportPlaySpeed {
    ONE("1");

    public static final TransportPlaySpeed DEFAULT_VALUE = ONE;
    private final String _value;

    TransportPlaySpeed(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static TransportPlaySpeed getInstance(String value) {
        for (TransportPlaySpeed v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}