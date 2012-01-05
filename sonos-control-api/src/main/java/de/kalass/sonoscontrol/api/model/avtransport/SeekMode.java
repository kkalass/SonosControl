package de.kalass.sonoscontrol.api.model.avtransport;

public enum SeekMode {
        TRACK_NR("TRACK_NR"),
        REL_TIME("REL_TIME"),
        SECTION("SECTION");

    private final String _value;

    SeekMode(String value) {
        _value = value;
    } 

    public String asString() {
        return _value;
    }

    public static SeekMode getInstance(String value) {
        for (SeekMode v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}