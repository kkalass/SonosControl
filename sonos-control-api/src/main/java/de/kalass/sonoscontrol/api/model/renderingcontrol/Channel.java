package de.kalass.sonoscontrol.api.model.renderingcontrol;

public enum Channel {
		MASTER("Master"),
		LF("LF"),
		RF("RF");
	
	private final String _value;
	
	Channel(String value) {
	    _value = value;
	} 
	
    public String asString() {
        return _value;
    }
    
    public static Channel getInstance(String value) {
        for (Channel v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }
    
}