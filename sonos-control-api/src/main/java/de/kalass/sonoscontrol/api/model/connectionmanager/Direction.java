package de.kalass.sonoscontrol.api.model.connectionmanager;

public enum Direction {
    INPUT("Input"),
    OUTPUT("Output");

    private final String _sonosName;

    Direction(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static Direction valueOfSonosName(String b) {
        	for (Direction v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
