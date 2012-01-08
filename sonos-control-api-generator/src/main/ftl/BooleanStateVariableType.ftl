/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package ${data.javaClassName.package.FQN};

public enum ${data.javaClassName.name} {
    ON() {
        public boolean getValue() {
            return true;
        }
    },
    OFF() {
        public boolean getValue() {
            return false;
        }
    };

    public abstract boolean getValue();

    public static ${data.javaClassName.name} getInstance(Boolean b) {
        return b == null ? null : (b.booleanValue() ? ON : OFF);
    }

}
