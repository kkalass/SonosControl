/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum MuteChannel {
    MASTER("Master"),
    LF("LF"),
    RF("RF"),
    SPEAKER_ONLY("SpeakerOnly");

    private final String _value;

    MuteChannel(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static MuteChannel getInstance(String value) {
        for (MuteChannel v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}