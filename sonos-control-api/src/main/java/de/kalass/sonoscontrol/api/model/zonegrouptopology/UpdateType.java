package de.kalass.sonoscontrol.api.model.zonegrouptopology;

public enum UpdateType {
    ALL("All"),
    SOFTWARE("Software");

    private final String _sonosValue;

    UpdateType(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static UpdateType valueOfBySonosValue(String sonosValue) {
        	for (UpdateType v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
