package de.kalass.sonoscontrol.api.model.avtransport;

public enum RecordStorageMedium {
    NONE("NONE");

    private final String _sonosValue;

    RecordStorageMedium(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static RecordStorageMedium valueOfBySonosValue(String sonosValue) {
        	for (RecordStorageMedium v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
