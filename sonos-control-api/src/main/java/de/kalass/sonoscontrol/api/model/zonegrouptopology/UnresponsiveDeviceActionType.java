package de.kalass.sonoscontrol.api.model.zonegrouptopology;

public enum UnresponsiveDeviceActionType {
    REMOVE("Remove"),
    VERIFY_THEN_REMOVE_SYSTEMWIDE("VerifyThenRemoveSystemwide");

    private final String _sonosValue;

    UnresponsiveDeviceActionType(final String sonosValue) {
        _sonosValue = sonosValue;
    }

    public String getSonosValue() {
        return _sonosValue;
    }

    public static UnresponsiveDeviceActionType valueOfBySonosValue(String sonosValue) {
        	for (UnresponsiveDeviceActionType v : values()) {
    		if (v._sonosValue.equals(sonosValue)) {
    			return v;
    		}
    	}
    	throw new IllegalArgumentException("Unknown sonos name: " + sonosValue);
    }
}
