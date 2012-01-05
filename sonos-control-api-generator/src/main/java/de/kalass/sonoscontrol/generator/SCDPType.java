package de.kalass.sonoscontrol.generator;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.generator.SCDP.Action;
import de.kalass.sonoscontrol.generator.SCDP.ActionArgument;
import de.kalass.sonoscontrol.generator.SCDP.AllowedValueRange;
import de.kalass.sonoscontrol.generator.SCDP.StateVariable;

public class SCDPType {
    private final JavaClassName _serviceName;
    private final List<SCDPType.ActionType> _actions;
    private final List<SCDPType.StateVariableType> _stateVariables;
    private final JavaPackageName _corePackageName;
    private String _upnpName;

    public static final class ActionArgumentType {
        public static final Predicate<ActionArgumentType> IS_VALUE_HARDCODED = new Predicate<ActionArgumentType>() {
            @Override
            public boolean apply(ActionArgumentType input) {
                return input.isValueHardcoded();
            }
        };
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

        public String getUpnpName() {
            return _name;
        }

        public final String getParameterName() {
            final String name = _name;
            return name.substring(0,1).toLowerCase() + name.substring(1);
        }

        public final String getGetterName() {
            return "get" + _name;
        }

        public StateVariableType getRelatedStateVariable() {
            return _relatedStateVariable;
        }

        public boolean isValueHardcoded() {
            // TODO: find out if there is any other possible value besides "0" for InstanceID, which would
            //       make sense to be exposed in the service interface
            //
            //      Also: types like TransportPlaySpeed that have only one valid value by definition are not exposed in the API either
            //
            final String javaTypeName = getRelatedStateVariable().getJavaClassName().getName();
            return "InstanceID".equals(javaTypeName) || getRelatedStateVariable().isSingleValueType();
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

        public List<ActionArgumentType> getProperties() {
            return _properties;
        }

        public List<JavaClassName> getNeededImports() {
            final Iterable<JavaClassName> classNames = Iterables.transform(_properties, Functions.compose(StateVariableType.GET_JAVA_TYPE_NAME, ActionArgumentType.GET_STATE_VARIABLE));
            return SCDPType.getNeededImports(getJavaClassName().getPackage(), classNames);
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

        public String getUpnpName() {
            return _name.asString();
        }

        public final String getMethodName() {
            final String name = _name.asString();
            if (name.startsWith("Get") || name.startsWith("get")) {
                return "retrieve"+name.substring("Get".length());
            }
            return name.substring(0,1).toLowerCase() + name.substring(1);
        }

        public Collection<ActionArgumentType> getIn() {
            return Collections2.filter(_in, Predicates.not(ActionArgumentType.IS_VALUE_HARDCODED));
        }
        public List<ActionArgumentType> getAllIn() {
            return _in;
        }
        public ActionOutputType getOut() {
            return _out;
        }

        public boolean isAnyInputArgumentHardcoded() {
            return Iterables.any(getAllIn(), ActionArgumentType.IS_VALUE_HARDCODED);
        }
    }

    public static final class AllowedValue {
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
        private final List<AllowedValue> _allowedValueList;
        @CheckForNull
        private final AllowedValueRange _allowedValueRange;
        private boolean _sendEvents;

        public StateVariableType(StateVariable stateVariable, ServiceNameFactory serviceNameFactory) {
            _sendEvents = stateVariable.isSendEvents();
            _javaTypeName = serviceNameFactory.getModelClassName(createJavaTypeName(stateVariable));
            _dataType = stateVariable.getDataType();
            _allowedValueList = Lists.transform(stateVariable.getAllowedValueList(), new Function<String, AllowedValue>() {
                @Override
                public AllowedValue apply(String input) {
                    return new AllowedValue(input);
                }
            });
            _allowedValueRange = stateVariable.getAllowedValueRange();
            if (_allowedValueRange != null) {
                if (!_dataType.getJavaClass().equals(Long.class)) {
                    throw new IllegalArgumentException("don't know how to implement ranges for " + _dataType.getJavaClass() + ": " + _javaTypeName);
                }
            }
        }

        private String createJavaTypeName(StateVariable stateVariable) {
            final String name = stateVariable.getName();
            return name.startsWith("A_ARG_TYPE_") ? name.substring("A_ARG_TYPE_".length()) : name ;
        }

        public boolean isSendEvents() {
            return _sendEvents;
        }

        public String getStateVariableName() {
            return _javaTypeName.getName();
        }

        public JavaClassName getJavaClassName() {
            return _javaTypeName;
        }


        public boolean isSingleValueType() {
            // the type is restricted, but there is only one valid value...
            // one example of this currently (1.1.2012) is TransportPlaySpeed
            return _allowedValueList.size() == 1;
        }

        public UpnpDatatype getDataType() {
            return _dataType;
        }

        public AllowedValueRange getAllowedValueRange() {
            return _allowedValueRange;
        }

        public List<AllowedValue> getAllowedValues() {
            return _allowedValueList;
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
        _upnpName = scdp.getName();
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

    public String getUpnpName() {
        return _upnpName;
    }

    public List<SCDPType.ActionType> getActions() {
        return _actions;
    }

    public List<SCDPType.StateVariableType> getStateVariables() {
        return _stateVariables;
    }

    public JavaClassName getJavaClassName() {
        return _serviceName;
    }

    public List<JavaClassName> getNeededImports() {
        final Iterable<JavaClassName> classNames = ImmutableSet.copyOf(
                Iterables.<JavaClassName>concat(
                        ImmutableList.of(
                                _corePackageName.childClass("Callback0"),
                                _corePackageName.childClass("Callback1")
                                ),
                                Iterables.transform(getActions(), Functions.compose(ActionOutputType.GET_JAVA_CLASS_NAME, ActionType.GET_OUT)),
                                Iterables.transform(getStateVariables(), StateVariableType.GET_JAVA_TYPE_NAME))
                );

        return SCDPType.getNeededImports(getJavaClassName().getPackage(), classNames);
    }

    private  static List<JavaClassName> getNeededImports(
            final JavaPackageName packageName,
            Iterable<JavaClassName> classNames
            ) {
        return ImmutableList.copyOf(Iterables.filter(classNames, new Predicate<JavaClassName>() {
            @Override
            public boolean apply(JavaClassName className) {
                JavaPackageName pkgName = className.getPackage();
                return !packageName.equals(pkgName) && !"java.lang".equals(pkgName.getFQN());
            }
        }));
    }

}