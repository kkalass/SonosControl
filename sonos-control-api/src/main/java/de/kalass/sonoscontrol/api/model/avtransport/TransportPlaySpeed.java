package de.kalass.sonoscontrol.api.model.avtransport;

public enum TransportPlaySpeed {
    ONE("1");

    private final String _sonosValue;

    TransportPlaySpeed(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static TransportPlaySpeed valueOfBySonosValue(String sonosValue) {
        	for (TransportPlaySpeed v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
