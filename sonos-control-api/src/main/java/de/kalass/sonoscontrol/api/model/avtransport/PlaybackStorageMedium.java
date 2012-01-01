package de.kalass.sonoscontrol.api.model.avtransport;

public enum PlaybackStorageMedium {
    NONE("NONE"),
    NETWORK("NETWORK");

    private final String _sonosName;

    PlaybackStorageMedium(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static PlaybackStorageMedium valueOfSonosName(String b) {
        	for (PlaybackStorageMedium v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
