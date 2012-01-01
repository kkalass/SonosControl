package de.kalass.sonoscontrol.api.generator;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.api.generator.SCDP.Action;
import de.kalass.sonoscontrol.api.generator.SCDP.ActionArgument;
import de.kalass.sonoscontrol.api.generator.SCDP.StateVariable;

public final class SCDPType {
	private final String _packageName;
	private final String _serviceName;
	private final List<SCDPType.ActionType> _actions;
	private final List<SCDPType.StateVariableType> _stateVariables;
	
	public static final class ActionArgumentType {
		private final String _name;
		private final StateVariableType _relatedStateVariable;
		public ActionArgumentType(String name, StateVariableType relatedStateVariable) {
			_name = Preconditions.checkNotNull(name);
			_relatedStateVariable = Preconditions.checkNotNull(relatedStateVariable);
		}
		public final String getParameterName() {
			final String name = _name;
			return name.substring(0,1).toLowerCase() + name.substring(1);
		}
		public StateVariableType getRelatedStateVariable() {
			return _relatedStateVariable;
		}
	}
	
	public static final class VoidActionOutputType extends ActionOutputType {
		
	}
	public static final class SimpleActionOutputType extends ActionOutputType {
		private final ActionArgumentType _type;
		public SimpleActionOutputType(ActionArgumentType type) {
			_type = Preconditions.checkNotNull(type);
		}
		public ActionArgumentType getType() {
			return _type;
		}
	}
	public static abstract class ActionOutputType {
		
		public static ActionOutputType getInstance(
				String packageName, String actionName, List<ActionArgumentType> properties
		) {
			if (properties.isEmpty()) {
				return new VoidActionOutputType();
			}
			if (properties.size() == 1) {
				return new SimpleActionOutputType(properties.get(0));
			}
			return new CompoundActionOutputType(packageName, actionName, properties);
		}
	}

	public static final class CompoundActionOutputType extends ActionOutputType {
		private final List<ActionArgumentType> _properties;
		private final String _actionName;
		private final String _packageName;
		
		public CompoundActionOutputType(String packageName, String actionName, List<ActionArgumentType> properties) {
			_packageName = packageName;
			_actionName = actionName.trim();
			Preconditions.checkArgument(properties.size() > 1);
			_properties = properties;
		}
		
		public String getJavaTypeName() {
			if (_actionName.startsWith("Get") || _actionName.startsWith("get")) {
				return _actionName.substring("get".length());
			}
			return _actionName.substring(0, 1).toUpperCase() + _actionName.substring(1) + "Result";
		}
		
		public String getJavaFQN() {
			return _packageName + "." + getJavaTypeName();
		}
		public String getPackageName() {
			return _packageName;
		}
		public File getPackageDir(File baseDir) {
			return new File(baseDir, convertPackageToDirName(getPackageName()));
		}
		public File getJavaFile(File outputDir) {
			return new File(getPackageDir(outputDir), ".java");
		}
		public String generateSourceCode() {
			final StringBuilder sb = new StringBuilder();

			sb.append("package ").append(getPackageName()).append(";\n");
			sb.append("\n");
			sb.append("import com.google.common.base.Objects;\n");
			sb.append("\n");
			sb.append("public class ").append(getJavaTypeName()).append(" {\n");
			for (ActionArgumentType prop : _properties) {
				sb.append("    private final ").append(prop.getRelatedStateVariable().getJavaTypeName())
				.append(" _").append(prop.getParameterName()).append(";\n");
			}
			sb.append("\n");
			sb.append("    public ").append(getJavaTypeName()).append("(");
			final Iterator<ActionArgumentType> pIt = _properties.iterator();
			while (pIt.hasNext()) {
				final ActionArgumentType prop = pIt.next();
				sb.append("\n        ").append(prop.getRelatedStateVariable().getJavaTypeName())
				.append(" ").append(prop.getParameterName());
				if (pIt.hasNext()) {
					sb.append(",");
				}
			}
			sb.append("\n    ) {\n");
			for (ActionArgumentType prop : _properties) {
				sb.append("        _").append(prop.getParameterName())
				.append(" = ").append(prop.getParameterName()).append(";\n");
			}
			sb.append("    }\n");
			sb.append("\n");
			for (ActionArgumentType prop : _properties) {
				sb.append("\n");
				sb.append("    public ").append(prop.getRelatedStateVariable().getJavaTypeName()).append(" get").append(prop.getRelatedStateVariable().getJavaTypeName()).append("() {\n")
				.append("        return _").append(prop.getParameterName()).append(";\n");
				sb.append("    }\n");
			}
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public boolean hashCode() {\n");
			sb.append("        return Objects.hashCode(\n");
			final Iterator<ActionArgumentType> hashIterator = _properties.iterator();
			while (hashIterator.hasNext()) {
				ActionArgumentType prop = hashIterator.next();
				sb.append("             _").append(prop.getParameterName());
				if (hashIterator.hasNext()) {
					sb.append(",\n");
				} else {
					sb.append("\n");
				}
			}
			
			sb.append("        );\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public boolean equals(Object other) {\n");
			sb.append("        if (other instanceof ").append(getJavaTypeName()).append(") {\n");
			sb.append("            ").append(getJavaTypeName()).append(" obj = (").append(getJavaTypeName()).append(")other;\n");
			sb.append("            return \n");
			final Iterator<ActionArgumentType> equalsIterator = _properties.iterator();
			while (equalsIterator.hasNext()) {
				ActionArgumentType prop = equalsIterator.next();
				sb.append("             Objects.equal(_").append(prop.getParameterName()).append(", obj._").append(prop.getParameterName()).append(")");
				if (equalsIterator.hasNext()) {
					sb.append(" &&\n");
				} else {
					sb.append(";\n");
				}
			}
			sb.append("        }\n");
			sb.append("        return false;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public boolean toString() {\n");
			sb.append("        return Objects.toStringHelper(this)\n");
			final Iterator<ActionArgumentType> toStringIterator = _properties.iterator();
			while (toStringIterator.hasNext()) {
				ActionArgumentType prop = toStringIterator.next();
				sb.append("             .append(\"").append(prop.getParameterName()).append("\",_").append(prop.getParameterName()).append(")\n");
			}
			sb.append("             .toString();\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("}\n");
			return sb.toString();
		}
	}
	
	public static final class ActionType {
		private final String _name;
		private final List<ActionArgumentType> _in;
		private final ActionOutputType _out;
		
		public ActionType(String name, List<ActionArgumentType> in, ActionOutputType out) {
			_in = in;
			_out = out;
			_name = name;
		}
		
		public final String getMethodName() {
			final String name = _name;
			return name.substring(0,1).toLowerCase() + name.substring(1);
		}
		
		public List<ActionArgumentType> getIn() {
			return _in;
		}
		
		public ActionOutputType getOut() {
			return _out;
		}
	}
	
	public static final class StateVariableType {
		private final StateVariable _stateVariable;
		private final String _javaTypeName;
		private final String _packageName;
		private final String _dataType;
		private final List<String> _allowedValueList;
		
		public StateVariableType(StateVariable stateVariable, String packageName) {
			_stateVariable = stateVariable;
			_javaTypeName = createJavaTypeName(_stateVariable);
			_dataType = stateVariable.getDataType();
			_allowedValueList = stateVariable.getAllowedValueList();
			_packageName = packageName;
		}
		private String createJavaTypeName(StateVariable stateVariable) {
			final String name = stateVariable.getName();
			return name.startsWith("A_ARG_TYPE_") ? name.substring("A_ARG_TYPE_".length()) : name ;
		}
		public String getJavaTypeName() {
			return _javaTypeName;
		}
		public String getJavaFQN() {
			return _packageName + "." + getJavaTypeName();
		}
		public String getPackageName() {
			return _packageName;
		}
		public File getPackageDir(File baseDir) {
			return new File(baseDir, convertPackageToDirName(getPackageName()));
		}
		public File getJavaFile(File outputDir) {
			return new File(getPackageDir(outputDir), ".java");
		}
		
		private static final String toEnumValue(String input) {
			final StringBuilder sb = new StringBuilder();
			boolean wasLower = false;
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				boolean isLower = Character.isLowerCase(c);
				if (wasLower && ! isLower) {
					sb.append("_");
				}
				sb.append(Character.toUpperCase(c));
				wasLower = isLower;
			}
			return sb.toString();
		}
		

		private void generateEnumSourceCode(StringBuilder sb, List<String> allowedValues) {
			
			sb.append("public enum " + getJavaTypeName() + " {\n");
			final Iterator<String> it = allowedValues.iterator();
			while (it.hasNext()) {
				final String sonosName = it.next();
				
				sb.append("    ").append(toEnumValue(sonosName))
				.append("(\"").append(sonosName).append("\")").append(it.hasNext() ? ",\n" : ";\n");
			}
			sb.append("\n");
			sb.append("    private final String _sonosName;\n");
			sb.append("\n");
			sb.append("    ").append(getJavaTypeName()).append("(final String sonosName) {\n");
			sb.append("        _sonosName = sonosName;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    public String getSonosName() {\n");
			sb.append("        return _sonosName;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    public static ").append(getJavaTypeName()).append(" valueOfSonosName(String b) {\n");
			sb.append("        	for (").append(getJavaTypeName()).append(" v : values()) {\n");
			sb.append("    		if (v._sonosName.equals(b)) {\n");
			sb.append("    			return v;\n");
			sb.append("    		}\n");
			sb.append("    	}\n");
			sb.append("    	throw new IllegalArgumentException(\"Unknown sonos name: \" + b);\n");
			sb.append("    }\n");
			sb.append("}\n");
		}
		
		private void generateBooleanSourceCode(StringBuilder sb) {
			sb.append("public enum ").append(getJavaTypeName()).append(" {\n");
			sb.append("    ON,\n");
			sb.append("    OFF;\n");
			sb.append("");
			sb.append("    private final boolean _b;\n");
			sb.append("");
			sb.append("    ").append(getJavaTypeName()).append("(final boolean value) {\n");
			sb.append("        _b = value;\n");
			sb.append("    }\n");
			sb.append("");
			sb.append("    public boolean toBoolean() {\n");
			sb.append("        return _b;\n");
			sb.append("    }\n");
			sb.append("    public static ").append(getJavaTypeName()).append(" valueOf(boolean b) {\n");
			sb.append("        return b?ON:OFF;\n");
			sb.append("    }\n");
			sb.append("}\n");
		}
		
		private void generateValueTypeSourceCode(StringBuilder sb, Class<?> javaType) {
			sb.append("import com.google.common.base.Objects;\n");
			sb.append("import com.google.common.base.Preconditions;\n");
			sb.append("\n");
			sb.append("public final class ").append(getJavaTypeName()).append(" {\n");
			sb.append("    private final ").append(javaType.getSimpleName()).append(" _value;\n");
			sb.append("\n");
			sb.append("    private ").append(getJavaTypeName()).append("(final ").append(javaType.getSimpleName()).append(" value) {\n");
			sb.append("        _value = Preconditions.checkNotNull(value);\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    public boolean to").append(javaType.getSimpleName()).append("() {\n");
			sb.append("        return _value;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public boolean hashCode() {\n");
			sb.append("        return _value.hashCode();\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public boolean equals(Object other) {\n");
			sb.append("        if (other instanceof ").append(getJavaTypeName()).append(") {\n");
			sb.append("            return Objects.equal(_value, ((").append(getJavaTypeName()).append(")other)._value);\n");
			sb.append("        }\n");
			sb.append("        return false;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public boolean toString() {\n");
			sb.append("        return Objects.toStringHelper(this).append(\"value\", _value).toString();\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    public static ").append(getJavaTypeName()).append(" valueOf(").append(javaType.getSimpleName()).append(" value) {\n");
			sb.append("        return value == null ? null : new ").append(getJavaTypeName()).append("(value);\n");
			sb.append("    }\n");
			sb.append("}\n");
		}
		
		public String generateSourceCode() {
			final StringBuilder sb = new StringBuilder();

			sb.append("package ").append(getPackageName()).append(";\n");
			sb.append("\n");
			if ("boolean".equals(_dataType)) {
				generateBooleanSourceCode(sb);
			} else if ("string".equals(_dataType) && !_allowedValueList.isEmpty()) {
				generateEnumSourceCode(sb, _allowedValueList);
			} else {
				final Class<?> valueType = getValueType(_dataType);
				generateValueTypeSourceCode(sb, valueType);
			}
			return sb.toString();
		}
		
		private Class<?> getValueType(String datatype) {
			if ("string".equals(datatype)) {
				return String.class;
			}
			if ("i4".equals(datatype)) {
				return Long.class;
			}
			if ("ui4".equals(datatype)) {
				return Long.class;
			}
			if ("ui2".equals(datatype)) {
				return Integer.class;
			}
			if ("i2".equals(datatype)) {
				return Integer.class;
			}
			throw new IllegalArgumentException("unsupported type: " + datatype);
		}
	}
	
	
	public SCDPType(SCDP scdp, final String packageName, final String serviceName) {
		_packageName = packageName;
		_serviceName = serviceName;
		final Map<StateVariable, SCDPType.StateVariableType> m = Maps.transformValues(
				Maps.uniqueIndex(scdp.getStateVariables(), Functions.<StateVariable>identity()),
				new Function<StateVariable, SCDPType.StateVariableType>() {
					@Override
					public SCDPType.StateVariableType apply(StateVariable input) {
						return new StateVariableType(input, packageName);
					}
				}
				);
		_stateVariables = ImmutableList.copyOf(Lists.transform(scdp.getStateVariables(), Functions.forMap(m)));
		_actions = ImmutableList.copyOf(Lists.transform(scdp.getActions(), new Function<Action, SCDPType.ActionType>() {
			@Override
			public SCDPType.ActionType apply(Action input) {
				final Function<ActionArgument, ActionArgumentType> converter = new Function<ActionArgument, ActionArgumentType>() {
					@Override
					public ActionArgumentType apply(ActionArgument input) {
						final StateVariable sv = input.getRelatedStateVariable();
						return new ActionArgumentType(input.getName(), m.get(sv));
					}
				};
				final ActionOutputType out = ActionOutputType.getInstance(packageName, input.getName(), ImmutableList.copyOf(Iterables.transform(input.getOutputParameters(), converter)));
				return new ActionType(input.getName(), 
						ImmutableList.copyOf(Iterables.transform(input.getInputParameters(), converter)),
						out 
				);
			}
		}));
	}
	public List<SCDPType.ActionType> getActions() {
		return _actions;
	}
	
	public List<SCDPType.StateVariableType> getStateVariables() {
		return _stateVariables;
	}
	
	public String getServiceName() {
		return _serviceName;
	}
	
	public String getServicePackageName() {
		return _packageName;
	}
	
	public File getServicePackageDir(File baseDir) {
		return new File(baseDir, convertPackageToDirName(getServicePackageName()));
	}
	
	public File getServiceInterfaceJavaFile(File baseDir) {
		return new File(getServicePackageDir(baseDir), getServiceName() + ".java");
	}
	
	public String getServiceFQN() {
		return getServicePackageName() + "." + _serviceName;
	}
	
	private static String convertPackageToDirName(String packageName) {
		return packageName.replace('.', '/');
	}
	public String generateServiceInterfaceSourceCode() {
		final StringBuilder sb = new StringBuilder();
		sb.append("package ").append(getServicePackageName()).append(";\n");
		sb.append("\n");
		sb.append("import de.kalass.sonoscontrol.api.core.Callback0;\n");
		sb.append("import de.kalass.sonoscontrol.api.core.Callback1;\n");
		sb.append("\n");
		sb.append("public interface " + getServiceName() + " {\n");
		// each action is a service method 
		for (final SCDPType.ActionType action : getActions()) {
			final String methodName = action.getMethodName();
			// TODO: multiple outputs
			final ActionOutputType outputArgs = action.getOut();
			sb.append("    public <C extends ");
			if (outputArgs instanceof VoidActionOutputType) {
				sb.append("Callback0");
			} else if (outputArgs instanceof SimpleActionOutputType) {
				final ActionArgumentType arg = ((SimpleActionOutputType)outputArgs).getType();
				final StateVariableType type = arg.getRelatedStateVariable();
				sb.append("Callback1<").append(type.getJavaTypeName()).append(">");
			} else {
				CompoundActionOutputType compoundType = (CompoundActionOutputType)outputArgs;
				sb.append("Callback1<").append(compoundType.getJavaTypeName()).append(">");
			}
			sb.append("> C ").append(methodName).append("(");
			final Iterator<ActionArgumentType> inputArgsIt = action.getIn().iterator();
			while (inputArgsIt.hasNext()) {
				final ActionArgumentType argumentType = inputArgsIt.next();
				if (!isValueHardcoded(argumentType)) {
					sb.append(argumentType.getRelatedStateVariable().getJavaTypeName()).append(" ").append(argumentType.getParameterName()).append(", ");
				}
			}
			sb.append("C callback);\n");
		}
		sb.append("}\n");
		return sb.toString();
	}
	
	private boolean isValueHardcoded(ActionArgumentType argumentType) {
		// TODO: find out if there is any other possible value besides "0", which would 
		//       make sense to be exposed in the service interface
		return "InstanceID".equals(argumentType.getRelatedStateVariable().getJavaTypeName());
	}
}