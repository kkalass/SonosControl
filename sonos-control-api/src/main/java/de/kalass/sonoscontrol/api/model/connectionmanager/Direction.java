package de.kalass.sonoscontrol.api.model.connectionmanager;

public enum Direction {
    INPUT("Input"),
    OUTPUT("Output");

    private final String _sonosValue;

    Direction(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static Direction valueOfBySonosValue(String sonosValue) {
        	for (Direction v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
