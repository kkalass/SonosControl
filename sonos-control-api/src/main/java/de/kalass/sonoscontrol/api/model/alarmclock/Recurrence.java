package de.kalass.sonoscontrol.api.model.alarmclock;

public enum Recurrence {
    ONCE("ONCE"),
    WEEKDAYS("WEEKDAYS"),
    WEEKENDS("WEEKENDS"),
    DAILY("DAILY");

    private final String _sonosValue;

    Recurrence(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static Recurrence valueOfBySonosValue(String sonosValue) {
        	for (Recurrence v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
