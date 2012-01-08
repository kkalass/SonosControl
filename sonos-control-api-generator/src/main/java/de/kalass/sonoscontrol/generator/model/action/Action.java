package de.kalass.sonoscontrol.generator.model.action;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

import de.kalass.sonoscontrol.generator.upnp.UpnpActionName;

public final class Action {
    public static final Function<Action, ActionOutput> GET_OUT = new Function<Action, ActionOutput>() {
        @Override
        public ActionOutput apply(Action input) {
            return input.getOut();
        }
    };
    private final UpnpActionName _name;
    private final List<ActionArgument> _in;
    private final ActionOutput _out;

    public Action(UpnpActionName name, List<ActionArgument> in, ActionOutput out) {
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

    public Collection<ActionArgument> getIn() {
        return Collections2.filter(_in, Predicates.not(ActionArgument.IS_VALUE_HARDCODED));
    }
    public boolean isNoArguments() {
        return getIn().isEmpty();
    }
    public List<ActionArgument> getAllIn() {
        return _in;
    }
    public ActionOutput getOut() {
        return _out;
    }

    public boolean isAnyInputArgumentHardcoded() {
        return Iterables.any(getAllIn(), ActionArgument.IS_VALUE_HARDCODED);
    }
}