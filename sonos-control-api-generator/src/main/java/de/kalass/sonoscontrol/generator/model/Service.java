package de.kalass.sonoscontrol.generator.model;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.generator.model.action.Action;
import de.kalass.sonoscontrol.generator.model.action.ActionArgument;
import de.kalass.sonoscontrol.generator.model.action.ActionOutput;
import de.kalass.sonoscontrol.generator.model.types.Type;
import de.kalass.sonoscontrol.generator.upnp.UpnpAction;
import de.kalass.sonoscontrol.generator.upnp.UpnpActionArgument;
import de.kalass.sonoscontrol.generator.upnp.UpnpService;
import de.kalass.sonoscontrol.generator.upnp.UpnpStateVariable;

public class Service implements IService {
    private final JavaClassName _serviceName;
    private final List<Action> _actions;
    private final List<StateVariable> _stateVariables;
    private final JavaPackageName _corePackageName;
    private String _upnpName;

    public interface TypeFactory {
        Type getType(String serviceName, UpnpStateVariable stateVariable, Map<String, JavaClassName> javaClassesByStateVariableName);
    }

    public Service(
            UpnpService scdp,
            final NameFactory nameFactory,
            final TypeFactory typeFactory
            ) {
        _upnpName = scdp.getName();
        _corePackageName = nameFactory.getCorePackageName();
        final ServiceNameFactory serviceNameFactory = nameFactory.getServiceNameFactory(scdp.getName());
        _serviceName = serviceNameFactory.getServiceClassName();
        final ImmutableMap<String, UpnpStateVariable> upnpStateVariablesByName = Maps.uniqueIndex(scdp.getStateVariables(), UpnpStateVariable.GET_NAME);
        final Map<String, JavaClassName> stateVariableJavaClassNames = Maps.transformValues(
                upnpStateVariablesByName,
                new Function<UpnpStateVariable, JavaClassName>() {
                    @Override
                    public JavaClassName apply(UpnpStateVariable input) {
                        return serviceNameFactory.getModelClassName(createStateVariableJavaTypeName(input.getName()));
                    }
                }
                );

        final Map<String, StateVariable> m = Maps.transformValues(
                upnpStateVariablesByName,
                new Function<UpnpStateVariable, StateVariable>() {
                    @Override
                    public StateVariable apply(UpnpStateVariable input) {
                        return new StateVariable(input, Preconditions.checkNotNull(typeFactory.getType(_upnpName, input, stateVariableJavaClassNames)));
                    }
                }
                );
        _stateVariables = ImmutableList.copyOf(Lists.transform(scdp.getStateVariables(), new Function<UpnpStateVariable, StateVariable>() {
            @Override
            public StateVariable apply(UpnpStateVariable input) {
                return Preconditions.checkNotNull(m.get(input.getName()), "No value for " + input.getName() + " in " + m);
            }
        }));
        _actions = ImmutableList.copyOf(Lists.transform(scdp.getActions(), new Function<UpnpAction, Action>() {
            @Override
            public Action apply(UpnpAction input) {
                final Function<UpnpActionArgument, ActionArgument> converter = new Function<UpnpActionArgument, ActionArgument>() {
                    @Override
                    public ActionArgument apply(UpnpActionArgument input) {
                        final UpnpStateVariable sv = input.getRelatedStateVariable();
                        return new ActionArgument(input.getName(), m.get(sv.getName()));
                    }
                };
                final ActionOutput out = ActionOutput.getInstance(serviceNameFactory, input.getName(), ImmutableList.copyOf(Iterables.transform(input.getOutputParameters(), converter)));
                return new Action(input.getName(),
                        ImmutableList.copyOf(Iterables.transform(input.getInputParameters(), converter)),
                        out
                        );
            }
        }));
    }

    private static String createStateVariableJavaTypeName(String name) {
        return name.startsWith("A_ARG_TYPE_") ? name.substring("A_ARG_TYPE_".length()) : name ;
    }

    @Override
    public boolean isCustomSerializationNeeded() {
        return Iterables.any(_stateVariables, Predicates.compose(Type.IS_CUSTOM_SERIAlIZATION_NEEDED, StateVariable.GET_TYPE));
    }

    /* (non-Javadoc)
     * @see de.kalass.sonoscontrol.generator.model.IService#getUpnpName()
     */
    @Override
    public String getUpnpName() {
        return _upnpName;
    }

    /* (non-Javadoc)
     * @see de.kalass.sonoscontrol.generator.model.IService#getActions()
     */
    @Override
    public List<Action> getActions() {
        return _actions;
    }

    /* (non-Javadoc)
     * @see de.kalass.sonoscontrol.generator.model.IService#getStateVariables()
     */
    @Override
    public List<StateVariable> getStateVariables() {
        return _stateVariables;
    }

    /* (non-Javadoc)
     * @see de.kalass.sonoscontrol.generator.model.IService#getJavaClassName()
     */
    @Override
    public JavaClassName getJavaClassName() {
        return _serviceName;
    }

    /* (non-Javadoc)
     * @see de.kalass.sonoscontrol.generator.model.IService#getNeededImports()
     */
    @Override
    public List<JavaClassName> getNeededImports() {
        final Iterable<JavaClassName> classNames = ImmutableSet.copyOf(
                Iterables.<JavaClassName>concat(
                        ImmutableList.of(
                                _corePackageName.childClass("Callback0"),
                                _corePackageName.childClass("Callback1")
                                ),
                                Iterables.transform(getActions(), Functions.compose(ActionOutput.GET_JAVA_CLASS_NAME, Action.GET_OUT)),
                                Iterables.transform(getStateVariables(), Functions.compose(Type.GET_JAVA_TYPE_NAME, StateVariable.GET_TYPE)))
                );

        return Util.getNeededImports(getJavaClassName().getPackage(), classNames);
    }


}