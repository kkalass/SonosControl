package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum LEDState {
    ON("On"),
    OFF("Off");

    private final String _sonosValue;

    LEDState(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static LEDState valueOfBySonosValue(String sonosValue) {
        	for (LEDState v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
