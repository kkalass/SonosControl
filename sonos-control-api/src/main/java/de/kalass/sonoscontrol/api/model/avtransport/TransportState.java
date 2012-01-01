package de.kalass.sonoscontrol.api.model.avtransport;

public enum TransportState {
    STOPPED("STOPPED"),
    PLAYING("PLAYING"),
    PAUSED_PLAYBACK("PAUSED_PLAYBACK"),
    TRANSITIONING("TRANSITIONING");

    private final String _sonosValue;

    TransportState(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static TransportState valueOfBySonosValue(String sonosValue) {
        	for (TransportState v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
