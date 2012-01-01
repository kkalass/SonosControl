package de.kalass.sonoscontrol.api.model.avtransport;

public enum TransportState {
    STOPPED("STOPPED"),
    PLAYING("PLAYING"),
    PAUSED_PLAYBACK("PAUSED_PLAYBACK"),
    TRANSITIONING("TRANSITIONING");

    private final String _sonosName;

    TransportState(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static TransportState valueOfSonosName(String b) {
        	for (TransportState v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
