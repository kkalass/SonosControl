package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum RampType {
    SLEEP_TIMER_RAMP_TYPE("SLEEP_TIMER_RAMP_TYPE"),
    ALARM_RAMP_TYPE("ALARM_RAMP_TYPE"),
    AUTOPLAY_RAMP_TYPE("AUTOPLAY_RAMP_TYPE");

    private final String _sonosValue;

    RampType(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static RampType valueOfBySonosValue(String sonosValue) {
        	for (RampType v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
