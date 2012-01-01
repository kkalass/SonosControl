package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum Channel {
    MASTER("Master"),
    LF("LF"),
    RF("RF");

    private final String _sonosName;

    Channel(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static Channel valueOfSonosName(String b) {
        	for (Channel v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
