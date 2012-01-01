package de.kalass.sonoscontrol.api.model.avtransport;

public enum TransportPlaySpeed {
    ONE("1");

    private final String _sonosName;

    TransportPlaySpeed(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static TransportPlaySpeed valueOfSonosName(String b) {
        	for (TransportPlaySpeed v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
