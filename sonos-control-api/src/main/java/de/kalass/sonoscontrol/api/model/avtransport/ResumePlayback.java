package de.kalass.sonoscontrol.api.model.avtransport;

public enum ResumePlayback {
    ON(true),
    OFF(false);
    private final boolean _b;
    ResumePlayback(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static ResumePlayback valueOf(boolean b) {
        return b?ON:OFF;
    }
}
