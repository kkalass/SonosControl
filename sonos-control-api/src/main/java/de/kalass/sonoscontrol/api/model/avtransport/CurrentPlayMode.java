// AUTOGENERATED: 6a77861825aa2a04213afa24ca6a2bc6
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

public enum CurrentPlayMode {
    NORMAL("NORMAL"),
    REPEAT_ALL("REPEAT_ALL"),
    SHUFFLE_NOREPEAT("SHUFFLE_NOREPEAT"),
    SHUFFLE("SHUFFLE");

    private final String _value;

    CurrentPlayMode(String value) {
        _value = value;
    } 

    public String getValue() {
        return _value;
    }

    public static CurrentPlayMode getInstance(String value) {
        if ("NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        for (CurrentPlayMode v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}