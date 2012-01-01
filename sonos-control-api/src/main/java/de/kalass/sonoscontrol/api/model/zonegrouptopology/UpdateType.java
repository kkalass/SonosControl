package de.kalass.sonoscontrol.api.model.zonegrouptopology;

public enum UpdateType {
    ALL("All"),
    SOFTWARE("Software");

    private final String _sonosName;

    UpdateType(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static UpdateType valueOfSonosName(String b) {
        	for (UpdateType v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
