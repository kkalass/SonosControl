package de.kalass.sonoscontrol.api.model.connectionmanager;

public enum ConnectionStatus {
    OK("OK"),
    CONTENT_FORMAT_MISMATCH("ContentFormatMismatch"),
    INSUFFICIENT_BANDWIDTH("InsufficientBandwidth"),
    UNRELIABLE_CHANNEL("UnreliableChannel"),
    UNKNOWN("Unknown");

    private final String _sonosValue;

    ConnectionStatus(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static ConnectionStatus valueOfBySonosValue(String sonosValue) {
        	for (ConnectionStatus v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
