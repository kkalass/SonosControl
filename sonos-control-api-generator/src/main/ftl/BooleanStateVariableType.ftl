package ${data.javaClassName.package.FQN};

public enum ${data.javaClassName.name} {
    ON() {
        public boolean asBoolean() {
            return true;
        }
    },
    OFF() {
        public boolean asBoolean() {
            return false;
        }
    };

    public abstract boolean asBoolean();

    public static ${data.javaClassName.name} getInstance(boolean b) {
        return b ? ON : OFF;
    }

}
