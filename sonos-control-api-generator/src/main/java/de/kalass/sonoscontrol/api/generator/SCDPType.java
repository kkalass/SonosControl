package de.kalass.sonoscontrol.api.generator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.api.generator.SCDP.Action;
import de.kalass.sonoscontrol.api.generator.SCDP.ActionArgument;
import de.kalass.sonoscontrol.api.generator.SCDP.AllowedValueRange;
import de.kalass.sonoscontrol.api.generator.SCDP.StateVariable;

public final class SCDPType {
	private final JavaClassName _serviceName;
	private final List<SCDPType.ActionType> _actions;
	private final List<SCDPType.StateVariableType> _stateVariables;
	private final JavaPackageName _corePackageName;
	
	public static final class ActionArgumentType {
		public static final Function<ActionArgumentType, StateVariableType> GET_STATE_VARIABLE = new Function<ActionArgumentType, StateVariableType>() {
			@Override
			public StateVariableType apply(ActionArgumentType input) {
				return input.getRelatedStateVariable();
			}
		};
		public static final Function<ActionArgumentType, String> GET_PARAMETER_NAME = new Function<ActionArgumentType, String>() {
			@Override
			public String apply(ActionArgumentType input) {
				return input.getParameterName();
			}
		};
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
		@Override
		public JavaClassName getJavaClassName() {
			return JavaClassName.JAVA_LANG_VOID;
		}
	}
	
	public static final class SimpleActionOutputType extends ActionOutputType {
		private final ActionArgumentType _type;
		public SimpleActionOutputType(ActionArgumentType type) {
			_type = Preconditions.checkNotNull(type);
		}
		public ActionArgumentType getType() {
			return _type;
		}
		
		@Override
		public JavaClassName getJavaClassName() {
			return _type.getRelatedStateVariable().getJavaClassName();
		}
	}
	
	public static abstract class ActionOutputType {
		public static final Function<ActionOutputType, JavaClassName> GET_JAVA_CLASS_NAME = new Function<SCDPType.ActionOutputType, JavaClassName>() {
			@Override
			public JavaClassName apply(ActionOutputType input) {
				return input.getJavaClassName();
			}
		};
		public abstract JavaClassName getJavaClassName();
		
		public static ActionOutputType getInstance(
				ServiceNameFactory serviceNameFactory, UpnpActionName actionName, List<ActionArgumentType> properties
		) {
			if (properties.isEmpty()) {
				return new VoidActionOutputType();
			}
			if (properties.size() == 1) {
				return new SimpleActionOutputType(properties.get(0));
			}
			return new CompoundActionOutputType(serviceNameFactory, actionName, properties);
		}
	}

	public static final class CompoundActionOutputType extends ActionOutputType {
		private final List<ActionArgumentType> _properties;
		private final JavaClassName _className;
		
		public CompoundActionOutputType(ServiceNameFactory serviceNameFactory, UpnpActionName actionName, List<ActionArgumentType> properties) {
			_className = serviceNameFactory.getModelClassName(toJavaTypeName(actionName.asString()));
			Preconditions.checkArgument(properties.size() > 1);
			_properties = properties;
		}
		
		private static String toJavaTypeName(String actionName) {
			if (actionName.startsWith("Get") || actionName.startsWith("get")) {
				return actionName.substring("get".length());
			}
			return actionName.substring(0, 1).toUpperCase() + actionName.substring(1) + "Result";
		}
		
		@Override
		public JavaClassName getJavaClassName() {
			return _className;
		}
		
		public String generateSourceCode() {
			final StringBuilder sb = new StringBuilder();

			final JavaPackageName packageName = getJavaClassName().getPackage();
			sb.append("package ").append(packageName.getFQN()).append(";\n");
			sb.append("\n");
			sb.append("import com.google.common.base.Objects;\n");
			Iterable<JavaClassName> classNames = Iterables.transform(_properties, Functions.compose(StateVariableType.GET_JAVA_TYPE_NAME, ActionArgumentType.GET_STATE_VARIABLE));
			appendImports(sb, packageName, classNames);
			sb.append("\n");
			sb.append("public class ").append(getJavaClassName().getName()).append(" {\n");
			for (ActionArgumentType prop : _properties) {
				sb.append("    private final ").append(prop.getRelatedStateVariable().getJavaClassName().getName())
				.append(" _").append(prop.getParameterName()).append(";\n");
			}
			sb.append("\n");
			sb.append("    public ").append(getJavaClassName().getName()).append("(");
			final Iterator<ActionArgumentType> pIt = _properties.iterator();
			while (pIt.hasNext()) {
				final ActionArgumentType prop = pIt.next();
				sb.append("\n        ").append(prop.getRelatedStateVariable().getJavaClassName().getName())
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
				String parameterName = prop.getParameterName();
				String getterName = "get" + parameterName.substring(0, 1).toUpperCase() + parameterName.substring(1);
				sb.append("    public ").append(prop.getRelatedStateVariable().getJavaClassName().getName()).append(" ").append(getterName).append("() {\n")
				.append("        return _").append(prop.getParameterName()).append(";\n");
				sb.append("    }\n");
			}
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public int hashCode() {\n");
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
			sb.append("        if (other instanceof ").append(getJavaClassName().getName()).append(") {\n");
			sb.append("            ").append(getJavaClassName().getName()).append(" obj = (").append(getJavaClassName().getName()).append(")other;\n");
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
			sb.append("    public String toString() {\n");
			sb.append("        return Objects.toStringHelper(this)\n");
			final Iterator<ActionArgumentType> toStringIterator = _properties.iterator();
			while (toStringIterator.hasNext()) {
				ActionArgumentType prop = toStringIterator.next();
				sb.append("             .add(\"").append(prop.getParameterName()).append("\",_").append(prop.getParameterName()).append(")\n");
			}
			sb.append("             .toString();\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("}\n");
			return sb.toString();
		}

		
	}
	
	public static final class ActionType {
		public static final Function<ActionType, ActionOutputType> GET_OUT = new Function<ActionType, ActionOutputType>() {
			@Override
			public ActionOutputType apply(ActionType input) {
				return input.getOut();
			}
		};
		private final UpnpActionName _name;
		private final List<ActionArgumentType> _in;
		private final ActionOutputType _out;
		
		public ActionType(UpnpActionName name, List<ActionArgumentType> in, ActionOutputType out) {
			_in = in;
			_out = out;
			_name = name;
		}
		
		public final String getMethodName() {
			final String name = _name.asString();
			if (name.startsWith("Get") || name.startsWith("get")) {
				return "retrieve"+name.substring("Get".length());
			}
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
		public static final Function<StateVariableType, JavaClassName> GET_JAVA_TYPE_NAME = new Function<StateVariableType, JavaClassName>() {
			@Override
			public JavaClassName apply(StateVariableType input) {
				return input.getJavaClassName();
			}
		};
		public static final Function<StateVariableType, UpnpDatatype> GET_DATATYPE = new Function<StateVariableType, UpnpDatatype>() {
			@Override
			public UpnpDatatype apply(StateVariableType input) {
				return input._dataType;
			}
		};
		
		@Nonnull
		private final JavaClassName _javaTypeName;
		@Nonnull
		private final UpnpDatatype _dataType;
		@Nonnull
		private final List<String> _allowedValueList;
		@CheckForNull
		private final AllowedValueRange _allowedValueRange;
		
		public StateVariableType(StateVariable stateVariable, ServiceNameFactory serviceNameFactory) {
			_javaTypeName = serviceNameFactory.getModelClassName(createJavaTypeName(stateVariable));
			_dataType = stateVariable.getDataType();
			_allowedValueList = stateVariable.getAllowedValueList();
			_allowedValueRange = stateVariable.getAllowedValueRange();
			if (_allowedValueRange != null) {
				if (!_dataType.asJavaClass().equals(Long.class)) {
					throw new IllegalArgumentException("don't know how to implement ranges for " + _dataType.asJavaClass() + ": " + _javaTypeName);
				}
			}
		}
		
		private String createJavaTypeName(StateVariable stateVariable) {
			final String name = stateVariable.getName();
			return name.startsWith("A_ARG_TYPE_") ? name.substring("A_ARG_TYPE_".length()) : name ;
		}
		
		public JavaClassName getJavaClassName() {
			return _javaTypeName;
		}
		
		
		public boolean isSingleValueType() {
			// the type is restricted, but there is only one valid value...
			// one example of this currently (1.1.2012) is TransportPlaySpeed
			return _allowedValueList.size() == 1;
		}
		
		private static final String toEnumValue(String input) {
			if ("1".equals(input)) {
				// special case needed for TransportPlaySpeed
				return "ONE";
			}
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
			
			sb.append("public enum " + getJavaClassName().getName() + " {\n");
			final Iterator<String> it = allowedValues.iterator();
			while (it.hasNext()) {
				final String sonosName = it.next();
				
				sb.append("    ").append(toEnumValue(sonosName))
				.append("(\"").append(sonosName).append("\")").append(it.hasNext() ? ",\n" : ";\n");
			}
			sb.append("\n");
			sb.append("    private final String _sonosValue;\n");
			sb.append("\n");
			sb.append("    ").append(getJavaClassName().getName()).append("(final String sonosValue) {\n");
			sb.append("        _sonosValue = sonosValue;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    public String getSonosValue() {\n");
			sb.append("        return _sonosValue;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    public static ").append(getJavaClassName().getName()).append(" valueOfBySonosValue(String sonosValue) {\n");
			sb.append("        	for (").append(getJavaClassName().getName()).append(" v : values()) {\n");
			sb.append("    		if (v._sonosValue.equals(sonosValue)) {\n");
			sb.append("    			return v;\n");
			sb.append("    		}\n");
			sb.append("    	}\n");
			sb.append("    	throw new IllegalArgumentException(\"Unknown sonos name: \" + sonosValue);\n");
			sb.append("    }\n");
			sb.append("}\n");
		}
		
		private void generateBooleanSourceCode(StringBuilder sb) {
			sb.append("public enum ").append(getJavaClassName().getName()).append(" {\n");
			sb.append("    ON(true),\n");
			sb.append("    OFF(false);\n");
			sb.append("");
			sb.append("    private final boolean _b;\n");
			sb.append("");
			sb.append("    ").append(getJavaClassName().getName()).append("(final boolean value) {\n");
			sb.append("        _b = value;\n");
			sb.append("    }\n");
			sb.append("");
			sb.append("    public boolean asBoolean() {\n");
			sb.append("        return _b;\n");
			sb.append("    }\n");
			sb.append("    public static ").append(getJavaClassName().getName()).append(" valueOf(boolean b) {\n");
			sb.append("        return b?ON:OFF;\n");
			sb.append("    }\n");
			sb.append("}\n");
		}
		
		private void generateValueTypeSourceCode(StringBuilder sb, Class<?> javaType) {
			sb.append("import com.google.common.base.Objects;\n");
			sb.append("import com.google.common.base.Preconditions;\n");
			sb.append("\n");
			sb.append("public final class ").append(getJavaClassName().getName()).append(" {\n");
			if (_allowedValueRange != null && javaType.equals(Long.class)) {
				long min = Long.parseLong(_allowedValueRange.getMinimum(), 10);
				long max = Long.parseLong(_allowedValueRange.getMaximum(), 10);
				sb.append("\n");
				sb.append("    public static final long MIN = ").append(min).append(";\n");
				sb.append("    public static final long MAX = ").append(max).append(";\n");
				if (_allowedValueRange.getStep() != null) {
					long step = Long.parseLong(_allowedValueRange.getStep(), 10);
					sb.append("    public static final long STEP = ").append(step).append(";\n");	
				}
				sb.append("\n");
			}
			sb.append("    private final ").append(javaType.getSimpleName()).append(" _value;\n");
			sb.append("\n");
			sb.append("    private ").append(getJavaClassName().getName()).append("(final ").append(javaType.getSimpleName()).append(" value) {\n");
			sb.append("        _value = Preconditions.checkNotNull(value);\n");
			if (_allowedValueRange != null && javaType.equals(Long.class)) {
				sb.append("        Preconditions.checkArgument(value.longValue() >= MIN && value.longValue() <= MAX);\n");
				if (_allowedValueRange.getStep() != null) {
					sb.append("        Preconditions.checkArgument(((value.longValue() -  MIN) % STEP) == 0);\n");
				}
			}
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    public ").append(javaType.getSimpleName()).append(" as").append(javaType.getSimpleName()).append("() {\n");
			sb.append("        return _value;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public int hashCode() {\n");
			sb.append("        return _value.hashCode();\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public boolean equals(Object other) {\n");
			sb.append("        if (other instanceof ").append(getJavaClassName().getName()).append(") {\n");
			sb.append("            return Objects.equal(_value, ((").append(getJavaClassName().getName()).append(")other)._value);\n");
			sb.append("        }\n");
			sb.append("        return false;\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    @Override\n");
			sb.append("    public String toString() {\n");
			sb.append("        return Objects.toStringHelper(this).add(\"value\", _value).toString();\n");
			sb.append("    }\n");
			sb.append("\n");
			sb.append("    public static ").append(getJavaClassName().getName()).append(" valueOf(").append(javaType.getSimpleName()).append(" value) {\n");
			sb.append("        return value == null ? null : new ").append(getJavaClassName().getName()).append("(value);\n");
			sb.append("    }\n");
			sb.append("}\n");
		}
		
		public String generateSourceCode() {
			final StringBuilder sb = new StringBuilder();

			sb.append("package ").append(getJavaClassName().getPackage().getFQN()).append(";\n");
			sb.append("\n");
			final Class<?> valueType = _dataType.asJavaClass();
			if (Boolean.class.equals(valueType)) {
				generateBooleanSourceCode(sb);
			} else if (String.class.equals(valueType) && !_allowedValueList.isEmpty()) {
				generateEnumSourceCode(sb, _allowedValueList);
			} else {
				generateValueTypeSourceCode(sb, valueType);
			}
			return sb.toString();
		}
		
	}

	public interface ServiceNameFactory {
		JavaClassName getServiceClassName();
		JavaClassName getModelClassName(String name);
	}
	
	public interface  NameFactory {
		JavaPackageName getCorePackageName();
		ServiceNameFactory getServiceNameFactory(String serviceName);
	}
	
	
	public SCDPType(
			SCDP scdp,
			final NameFactory nameFactory
   ) {
		_corePackageName = nameFactory.getCorePackageName();
		final ServiceNameFactory serviceNameFactory = nameFactory.getServiceNameFactory(scdp.getName());
		_serviceName = serviceNameFactory.getServiceClassName();
		final Map<StateVariable, SCDPType.StateVariableType> m = Maps.transformValues(
				Maps.uniqueIndex(scdp.getStateVariables(), Functions.<StateVariable>identity()),
				new Function<StateVariable, SCDPType.StateVariableType>() {
					@Override
					public SCDPType.StateVariableType apply(StateVariable input) {
						return new StateVariableType(input, serviceNameFactory);
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
				final ActionOutputType out = ActionOutputType.getInstance(serviceNameFactory, input.getName(), ImmutableList.copyOf(Iterables.transform(input.getOutputParameters(), converter)));
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
	
	public JavaClassName getServiceName() {
		return _serviceName;
	}
	
	public String generateServiceInterfaceSourceCode() {
		final StringBuilder sb = new StringBuilder();
		final JavaPackageName packageName = getServiceName().getPackage();
		
		sb.append("package ").append(packageName.getFQN()).append(";\n");
		sb.append("\n");
		
		appendImports(sb, packageName, 
				ImmutableSet.copyOf(
						Iterables.<JavaClassName>concat(
						    ImmutableList.of(
						    		_corePackageName.childClass("Callback0"),
						    		_corePackageName.childClass("Callback1")
						    ),
							Iterables.transform(getActions(), Functions.compose(ActionOutputType.GET_JAVA_CLASS_NAME, ActionType.GET_OUT)),
							Iterables.transform(getStateVariables(), StateVariableType.GET_JAVA_TYPE_NAME))
						)
				);

		sb.append("\n");
		sb.append("public interface " + getServiceName().getName() + " {\n");
		// each action is a service method 
		for (final SCDPType.ActionType action : getActions()) {
			final String methodName = action.getMethodName();
			
			final boolean needsDocumentation = Iterables.any(action.getIn(), new Predicate<ActionArgumentType>() {
				@Override
				public boolean apply(ActionArgumentType input) {
					return isValueHardcoded(input);
				}
			});
			sb.append("\n");
			if (needsDocumentation) {
				sb.append("    /**\n");
				sb.append("     *\n");
				final Iterator<ActionArgumentType> inputArgsDocIt = action.getIn().iterator();
				while (inputArgsDocIt.hasNext()) {
					final ActionArgumentType argumentType = inputArgsDocIt.next();
					if (isValueHardcoded(argumentType)) {
						sb.append("     * <p><b>NOTE:</b> Sonos UPnP-Parameter {@link ").append(argumentType.getRelatedStateVariable().getJavaClassName().getName()).append(" ").append(argumentType.getParameterName()).append("} is set to an appropriate default value automatically.</p> \n");
					}
				}
				sb.append("     */\n");
			} 

			final ActionOutputType outputArgs = action.getOut();
			sb.append("    public <C extends ");
			final JavaClassName javaClassName = outputArgs.getJavaClassName();
			if (JavaClassName.JAVA_LANG_VOID.equals(javaClassName)) {
				sb.append("Callback0");
			} else {
				sb.append("Callback1<").append(javaClassName.getName()).append(">");
			}
			sb.append("> C ").append(methodName).append("(");
			final Iterator<ActionArgumentType> inputArgsIt = action.getIn().iterator();
			while (inputArgsIt.hasNext()) {
				final ActionArgumentType argumentType = inputArgsIt.next();
				if (!isValueHardcoded(argumentType)) {
					JavaClassName className = argumentType.getRelatedStateVariable().getJavaClassName();
					sb.append(className.getName()).append(" ").append(argumentType.getParameterName()).append(", ");
				}
			}
			sb.append("C callback);\n");
		}
		sb.append("}\n");
		return sb.toString();
	}
	
	private boolean isValueHardcoded(ActionArgumentType argumentType) {
		// TODO: find out if there is any other possible value besides "0" for InstanceID, which would 
		//       make sense to be exposed in the service interface
		//
		//      Also: types like TransportPlaySpeed that have only one valid value by definition are not exposed in the API either
		//
		final String javaTypeName = argumentType.getRelatedStateVariable().getJavaClassName().getName();
		return "InstanceID".equals(javaTypeName) || argumentType.getRelatedStateVariable().isSingleValueType();
	}
	
	private  static void appendImports(final StringBuilder sb,
			final JavaPackageName packageName,
			Iterable<JavaClassName> classNames) {
		
		for (JavaClassName className : classNames) {
			JavaPackageName pkgName = className.getPackage();
			if (!packageName.equals(pkgName) && !"java.lang".equals(pkgName.getFQN())) {
				sb.append("import ").append(className.getFQN()).append(";\n");
			}
		}
	}
}