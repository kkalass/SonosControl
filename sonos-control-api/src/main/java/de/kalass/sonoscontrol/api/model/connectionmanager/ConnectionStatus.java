package de.kalass.sonoscontrol.api.model.connectionmanager;

public enum ConnectionStatus {
    OK("OK"),
    CONTENT_FORMAT_MISMATCH("ContentFormatMismatch"),
    INSUFFICIENT_BANDWIDTH("InsufficientBandwidth"),
    UNRELIABLE_CHANNEL("UnreliableChannel"),
    UNKNOWN("Unknown");

    private final String _sonosName;

    ConnectionStatus(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static ConnectionStatus valueOfSonosName(String b) {
        	for (ConnectionStatus v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
