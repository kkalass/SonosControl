package de.kalass.sonoscontrol.api.model.alarmclock;

public enum AlarmPlayMode {
    NORMAL("NORMAL"),
    REPEAT_ALL("REPEAT_ALL"),
    SHUFFLE_NOREPEAT("SHUFFLE_NOREPEAT"),
    SHUFFLE("SHUFFLE");

    private final String _sonosName;

    AlarmPlayMode(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static AlarmPlayMode valueOfSonosName(String b) {
        	for (AlarmPlayMode v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
