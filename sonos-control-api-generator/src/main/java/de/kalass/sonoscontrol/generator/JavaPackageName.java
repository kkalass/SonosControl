package de.kalass.sonoscontrol.generator;

public class JavaPackageName extends JavaFQNName {
    public static JavaPackageName JAVA_LANG = JavaPackageName.valueOf("java.lang");

    private JavaPackageName(String fqn) {
        super(fqn);
    }

    public static JavaPackageName valueOf(String fqn) {
        return new JavaPackageName(fqn);
    }

    public JavaPackageName childPackage(String name) {
        return new JavaPackageName(getFQN() + "." + name);
    }


    public JavaClassName childClass(String name) {
        return new JavaClassName(this, name);
    }

}
