package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum MuteChannel {
    MASTER("Master"),
    LF("LF"),
    RF("RF"),
    SPEAKER_ONLY("SpeakerOnly");

    private final String _sonosName;

    MuteChannel(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static MuteChannel valueOfSonosName(String b) {
        	for (MuteChannel v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
