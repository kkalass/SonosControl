// AUTOGENERATED: b8fd59b422fe5bb7ade6f39ed2c4abf2
// AUTOGENERATED: 09.01.2012 12:49:21
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