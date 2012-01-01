package de.kalass.sonoscontrol.api.model.zonegrouptopology;

public enum UnresponsiveDeviceActionType {
    REMOVE("Remove"),
    VERIFY_THEN_REMOVE_SYSTEMWIDE("VerifyThenRemoveSystemwide");

    private final String _sonosName;

    UnresponsiveDeviceActionType(final String sonosName) {
        _sonosName = sonosName;
    }

    public String getSonosName() {
        return _sonosName;
    }

    public static UnresponsiveDeviceActionType valueOfSonosName(String b) {
        	for (UnresponsiveDeviceActionType v : values()) {
    		if (v._sonosName.equals(b)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + b);
    }
}
