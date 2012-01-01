package de.kalass.sonoscontrol.api.model.avtransport;

public enum PlaybackStorageMedium {
    NONE("NONE"),
    NETWORK("NETWORK");

    private final String _sonosValue;

    PlaybackStorageMedium(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static PlaybackStorageMedium valueOfBySonosValue(String sonosValue) {
        	for (PlaybackStorageMedium v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
