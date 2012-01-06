package de.kalass.sonoscontrol.generator.model.action;

import java.util.List;

import com.google.common.base.Function;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.model.ServiceNameFactory;
import de.kalass.sonoscontrol.generator.upnp.UpnpActionName;

public abstract class ActionOutput {
    public static final Function<ActionOutput, JavaClassName> GET_JAVA_CLASS_NAME = new Function<ActionOutput, JavaClassName>() {
        @Override
        public JavaClassName apply(ActionOutput input) {
            return input.getJavaClassName();
        }
    };
    public abstract JavaClassName getJavaClassName();

    public static ActionOutput getInstance(
            ServiceNameFactory serviceNameFactory, UpnpActionName actionName, List<ActionArgument> properties
            ) {
        if (properties.isEmpty()) {
            return new ActionOutputVoid();
        }
        if (properties.size() == 1) {
            return new ActionOutputSingleValue(properties.get(0));
        }
        return new ActionOutputCompound(serviceNameFactory, actionName, properties);
    }
}