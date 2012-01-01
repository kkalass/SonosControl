package de.kalass.sonoscontrol.api.model.deviceproperties;

public enum LEDState {
    ON("On"),
    OFF("Off");

    private final String _sonosName;

    LEDState(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static LEDState valueOfSonosName(String b) {
        	for (LEDState v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
