package de.kalass.sonoscontrol.api.model.avtransport;

public enum EnqueueAsNext {
    ON(true),
    OFF(false);
    private final boolean _b;
    EnqueueAsNext(final boolean value) {
        _b = value;
    }
    public boolean toBoolean() {
        return _b;
    }
    public static EnqueueAsNext valueOf(boolean b) {
        return b?ON:OFF;
    }
}
