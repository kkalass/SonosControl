package de.kalass.sonoscontrol.generator.model.action;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.generator.model.JavaClassName;


public final class ActionOutputSingleValue extends ActionOutput {
    private final ActionArgument _type;
    public ActionOutputSingleValue(ActionArgument type) {
        _type = Preconditions.checkNotNull(type);
    }
    public ActionArgument getType() {
        return _type;
    }

    @Override
    public JavaClassName getJavaClassName() {
        return _type.getRelatedStateVariable().getType().getJavaClassName();
    }
}