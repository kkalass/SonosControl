package de.kalass.sonoscontrol.generator.model.action;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.model.Parameter;
import de.kalass.sonoscontrol.generator.model.ServiceNameFactory;
import de.kalass.sonoscontrol.generator.model.types.CompoundType;
import de.kalass.sonoscontrol.generator.model.types.Type;
import de.kalass.sonoscontrol.generator.upnp.UpnpActionName;

public abstract class ActionOutput {
    public static final Function<ActionOutput, JavaClassName> GET_JAVA_CLASS_NAME = new Function<ActionOutput, JavaClassName>() {
        @Override
        public JavaClassName apply(ActionOutput input) {
            return input.getJavaClassName();
        }
    };

    private final Type _type;

    public ActionOutput(Type type) {
        _type = type;
    }

    public Type getType() {
        return _type;
    }

    public  JavaClassName getJavaClassName() {
        return _type.getJavaClassName();
    }

    private static String toJavaTypeName(String actionName) {
        /*if (actionName.startsWith("Get") || actionName.startsWith("get")) {
            return actionName.substring("get".length());
        }*/
        return actionName.substring(0, 1).toUpperCase() + actionName.substring(1) + "Result";
    }

    public static ActionOutput getInstance(
            ServiceNameFactory serviceNameFactory, UpnpActionName actionName, List<ActionArgument> properties
            ) {
        if (properties.isEmpty()) {
            return new ActionOutputVoid();
        }
        if (properties.size() == 1) {
            return new ActionOutputSingleValue(properties.get(0));
        }

        final JavaClassName compoundClassName = serviceNameFactory.getModelClassName(toJavaTypeName(actionName.asString()));
        final CompoundType compoundType = new CompoundType(null, compoundClassName, Lists.transform(properties, new Function<ActionArgument, Parameter>() {

            @Override
            public Parameter apply(ActionArgument input) {
                return new Parameter(input.getParameterName(), input.getRelatedStateVariable().getJavaClassName());
            }
        }));
        return new ActionOutputCompound(serviceNameFactory, actionName, properties, compoundType);
    }
}