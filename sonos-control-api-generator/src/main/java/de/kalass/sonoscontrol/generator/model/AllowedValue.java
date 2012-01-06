package de.kalass.sonoscontrol.generator.model;

public final class AllowedValue {
    private final String _value;
    public AllowedValue(String value) {
        _value = value;
    }
    public String getValue() {
        return _value;
    }
    public final String getEnumValue() {
        if ("1".equals(_value)) {
            // special case needed for TransportPlaySpeed
            return "ONE";
        }
        final StringBuilder sb = new StringBuilder();
        boolean wasLower = false;
        for (int i = 0; i < _value.length(); i++) {
            char c = _value.charAt(i);
            boolean isLower = Character.isLowerCase(c);
            if (wasLower && ! isLower) {
                sb.append("_");
            }
            sb.append(Character.toUpperCase(c));
            wasLower = isLower;
        }
        return sb.toString();
    }
}