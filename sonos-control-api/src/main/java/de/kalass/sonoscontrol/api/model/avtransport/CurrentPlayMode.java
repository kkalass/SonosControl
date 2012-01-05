package de.kalass.sonoscontrol.api.model.avtransport;

public enum CurrentPlayMode {
		NORMAL("NORMAL"),
		REPEAT_ALL("REPEAT_ALL"),
		SHUFFLE_NOREPEAT("SHUFFLE_NOREPEAT"),
		SHUFFLE("SHUFFLE");
	
	private final String _value;
	
	CurrentPlayMode(String value) {
	    _value = value;
	} 
	
    public String asString() {
        return _value;
    }
    
    public static CurrentPlayMode getInstance(String value) {
        for (CurrentPlayMode v: values()) {
            if (v._value.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Could not find " + value);   
    }
    
}