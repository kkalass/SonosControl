// AUTOGENERATED: 5a3dd2bd60702995b632276d490bfc3f
// AUTOGENERATED: 09.01.2012 13:05:47
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.model.avtransport;

public enum AlarmIncludeLinkedZones {
    ON() {
        public boolean getValue() {
            return true;
        }
    },
    OFF() {
        public boolean getValue() {
            return false;
        }
    };

    public abstract boolean getValue();

    public static AlarmIncludeLinkedZones getInstance(Boolean b) {
        return b == null ? null : (b.booleanValue() ? ON : OFF);
    }

}
