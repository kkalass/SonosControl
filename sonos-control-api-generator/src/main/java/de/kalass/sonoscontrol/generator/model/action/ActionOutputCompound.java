package de.kalass.sonoscontrol.generator.model.action;

import java.util.List;

import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.model.ServiceNameFactory;
import de.kalass.sonoscontrol.generator.model.StateVariable;
import de.kalass.sonoscontrol.generator.model.Util;
import de.kalass.sonoscontrol.generator.model.types.Type;
import de.kalass.sonoscontrol.generator.upnp.UpnpActionName;

public final class ActionOutputCompound extends ActionOutput {
    private final List<ActionArgument> _properties;
    private final JavaClassName _className;

    public ActionOutputCompound(ServiceNameFactory serviceNameFactory, UpnpActionName actionName, List<ActionArgument> properties) {
        _className = serviceNameFactory.getModelClassName(toJavaTypeName(actionName.asString()));
        Preconditions.checkArgument(properties.size() > 1);
        _properties = properties;
    }

    private static String toJavaTypeName(String actionName) {
        /*if (actionName.startsWith("Get") || actionName.startsWith("get")) {
            return actionName.substring("get".length());
        }*/
        return actionName.substring(0, 1).toUpperCase() + actionName.substring(1) + "Result";
    }

    @Override
    public JavaClassName getJavaClassName() {
        return _className;
    }

    public List<ActionArgument> getProperties() {
        return _properties;
    }

    public List<JavaClassName> getNeededImports() {
        final Iterable<JavaClassName> classNames = Iterables.transform(_properties, Functions.compose(Functions.compose(Type.GET_JAVA_TYPE_NAME, StateVariable.GET_TYPE), ActionArgument.GET_STATE_VARIABLE));
        return Util.getNeededImports(getJavaClassName().getPackage(), classNames);
    }

}