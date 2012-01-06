package de.kalass.sonoscontrol.generator.model;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableList;
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

public class Service {
    private final JavaClassName _serviceName;
    private final List<Action> _actions;
    private final List<StateVariable> _stateVariables;
    private final JavaPackageName _corePackageName;
    private String _upnpName;

    public Service(
            UpnpService scdp,
            final NameFactory nameFactory
            ) {
        _upnpName = scdp.getName();
        _corePackageName = nameFactory.getCorePackageName();
        final ServiceNameFactory serviceNameFactory = nameFactory.getServiceNameFactory(scdp.getName());
        _serviceName = serviceNameFactory.getServiceClassName();
        final Map<UpnpStateVariable, StateVariable> m = Maps.transformValues(
                Maps.uniqueIndex(scdp.getStateVariables(), Functions.<UpnpStateVariable>identity()),
                new Function<UpnpStateVariable, StateVariable>() {
                    @Override
                    public StateVariable apply(UpnpStateVariable input) {
                        return new StateVariable(input, serviceNameFactory);
                    }
                }
                );
        _stateVariables = ImmutableList.copyOf(Lists.transform(scdp.getStateVariables(), Functions.forMap(m)));
        _actions = ImmutableList.copyOf(Lists.transform(scdp.getActions(), new Function<UpnpAction, Action>() {
            @Override
            public Action apply(UpnpAction input) {
                final Function<UpnpActionArgument, ActionArgument> converter = new Function<UpnpActionArgument, ActionArgument>() {
                    @Override
                    public ActionArgument apply(UpnpActionArgument input) {
                        final UpnpStateVariable sv = input.getRelatedStateVariable();
                        return new ActionArgument(input.getName(), m.get(sv));
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

    public String getUpnpName() {
        return _upnpName;
    }

    public List<Action> getActions() {
        return _actions;
    }

    public List<StateVariable> getStateVariables() {
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
                                Iterables.transform(getActions(), Functions.compose(ActionOutput.GET_JAVA_CLASS_NAME, Action.GET_OUT)),
                                Iterables.transform(getStateVariables(), Functions.compose(Type.GET_JAVA_TYPE_NAME, StateVariable.GET_TYPE)))
                );

        return Util.getNeededImports(getJavaClassName().getPackage(), classNames);
    }


}