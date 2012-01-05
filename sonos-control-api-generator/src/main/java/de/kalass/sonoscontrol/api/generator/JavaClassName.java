package de.kalass.sonoscontrol.api.generator;

import com.google.common.base.Function;

public class JavaClassName extends JavaFQNName {
	public static JavaClassName JAVA_LANG_STRING = JavaPackageName.JAVA_LANG.childClass("String");
	public static JavaClassName JAVA_LANG_VOID = JavaPackageName.JAVA_LANG.childClass("Void");
	
	public static final Function<JavaClassName, String> GET_NAME = new Function<JavaClassName, String>() {
		@Override
		public String apply(JavaClassName input) {
			return input.getName();
		}
	};
	
	
	public static final Function<JavaClassName, JavaPackageName> GET_PACKAGE = new Function<JavaClassName, JavaPackageName>() {
		@Override
		public JavaPackageName apply(JavaClassName input) {
			return input.getPackage();
		}
	};
	
	
	private final JavaPackageName _packageName;
	private final String _name;
	
	JavaClassName(JavaPackageName packageName, String name) {
		super(packageName.getFQN() + "." + name);
		_packageName = packageName;
		_name = name;
	}

	/**
	 * @return The name of the class, e.g. "String" for "java.lang.String"
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @return The package of the class, e.g. "java.lang" for "java.lang.String"
	 */
	public JavaPackageName getPackage() {
		return _packageName;
	}

	/**
	 * The fully qualified name of the class, e.g. "java.lang.String"
	 */
	@Override
	public String getFQN() {
		return super.getFQN();
	}
	
	@Override
	protected String convertToFileName(String fqn) {
		return super.convertToFileName(fqn) + ".java";
	}
}
