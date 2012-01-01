package de.kalass.sonoscontrol.api.model.avtransport;

public enum CurrentPlayMode {
    NORMAL("NORMAL"),
    REPEAT_ALL("REPEAT_ALL"),
    SHUFFLE_NOREPEAT("SHUFFLE_NOREPEAT"),
    SHUFFLE("SHUFFLE");

    private final String _sonosName;

    CurrentPlayMode(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static CurrentPlayMode valueOfSonosName(String b) {
        	for (CurrentPlayMode v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
