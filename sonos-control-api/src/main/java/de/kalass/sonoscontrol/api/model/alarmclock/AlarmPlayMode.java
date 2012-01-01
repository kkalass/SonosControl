package de.kalass.sonoscontrol.api.model.alarmclock;

public enum AlarmPlayMode {
    NORMAL("NORMAL"),
    REPEAT_ALL("REPEAT_ALL"),
    SHUFFLE_NOREPEAT("SHUFFLE_NOREPEAT"),
    SHUFFLE("SHUFFLE");

    private final String _sonosValue;

    AlarmPlayMode(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static AlarmPlayMode valueOfBySonosValue(String sonosValue) {
        	for (AlarmPlayMode v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
