package de.kalass.sonoscontrol.api.model.avtransport;

public enum SeekMode {
    TRACK_NR("TRACK_NR"),
    REL_TIME("REL_TIME"),
    SECTION("SECTION");

    private final String _sonosName;

    SeekMode(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static SeekMode valueOfSonosName(String b) {
        	for (SeekMode v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
