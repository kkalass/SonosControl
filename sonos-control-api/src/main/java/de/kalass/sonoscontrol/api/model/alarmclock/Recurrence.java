package de.kalass.sonoscontrol.api.model.alarmclock;

public enum Recurrence {
    ONCE("ONCE"),
    WEEKDAYS("WEEKDAYS"),
    WEEKENDS("WEEKENDS"),
    DAILY("DAILY");

    private final String _sonosName;

    Recurrence(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static Recurrence valueOfSonosName(String b) {
        	for (Recurrence v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
