package de.kalass.sonoscontrol.generator.model.action;

import java.util.List;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.generator.model.ServiceNameFactory;
import de.kalass.sonoscontrol.generator.model.types.CompoundType;
import de.kalass.sonoscontrol.generator.upnp.UpnpActionName;

public final class ActionOutputCompound extends ActionOutput {
    private final List<ActionArgument> _properties;

    public ActionOutputCompound(
            ServiceNameFactory serviceNameFactory, UpnpActionName actionName, List<ActionArgument> properties,
            CompoundType type
            ) {
        super(type);

        Preconditions.checkArgument(properties.size() > 1);
        _properties = properties;
    }

    public List<ActionArgument> getProperties() {
        return _properties;
    }

}