// AUTOGENERATED: 6098f610d2be3bb4ea46325caa0859b9
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
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
        if ("NOT_IMPLEMENTED".equals(value)) {
            return null;
        }
        for (PlaybackStorageMedium v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }

}