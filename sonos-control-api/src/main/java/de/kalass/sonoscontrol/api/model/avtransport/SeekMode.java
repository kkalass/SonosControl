package de.kalass.sonoscontrol.api.model.avtransport;

public enum SeekMode {
    TRACK_NR("TRACK_NR"),
    REL_TIME("REL_TIME"),
    SECTION("SECTION");

    private final String _sonosValue;

    SeekMode(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static SeekMode valueOfBySonosValue(String sonosValue) {
        	for (SeekMode v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
