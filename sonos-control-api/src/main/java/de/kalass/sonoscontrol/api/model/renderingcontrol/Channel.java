package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum Channel {
    MASTER("Master"),
    LF("LF"),
    RF("RF");

    private final String _sonosValue;

    Channel(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static Channel valueOfBySonosValue(String sonosValue) {
        	for (Channel v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
