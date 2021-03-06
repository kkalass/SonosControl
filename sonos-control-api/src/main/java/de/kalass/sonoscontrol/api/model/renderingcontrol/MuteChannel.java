// AUTOGENERATED: 0be535bef3f74632b2b26d6f456185df
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
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
        if ("NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        for (MuteChannel v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}