package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum RampType {
    SLEEP_TIMER_RAMP_TYPE("SLEEP_TIMER_RAMP_TYPE"),
    ALARM_RAMP_TYPE("ALARM_RAMP_TYPE"),
    AUTOPLAY_RAMP_TYPE("AUTOPLAY_RAMP_TYPE");

    private final String _sonosName;

    RampType(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static RampType valueOfSonosName(String b) {
        	for (RampType v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
