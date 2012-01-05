package de.kalass.sonoscontrol.api.model.connectionmanager;

public enum Direction {
		INPUT("Input"),
		OUTPUT("Output");
	
	private final String _value;
	
	Direction(String value) {
	    _value = value;
	} 
	
    public String asString() {
        return _value;
    }
    
    public static Direction getInstance(String value) {
        for (Direction v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }
    
}