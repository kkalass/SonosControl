package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum MuteChannel {
    MASTER("Master"),
    LF("LF"),
    RF("RF"),
    SPEAKER_ONLY("SpeakerOnly");

    private final String _sonosValue;

    MuteChannel(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static MuteChannel valueOfBySonosValue(String sonosValue) {
        	for (MuteChannel v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
