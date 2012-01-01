package de.kalass.sonoscontrol.api.model.avtransport;

public enum RecordStorageMedium {
    NONE("NONE");

    private final String _sonosName;

    RecordStorageMedium(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static RecordStorageMedium valueOfSonosName(String b) {
        	for (RecordStorageMedium v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
