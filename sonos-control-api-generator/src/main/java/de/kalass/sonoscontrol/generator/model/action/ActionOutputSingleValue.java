package de.kalass.sonoscontrol.generator.model.action;

import com.google.common.base.Preconditions;


public final class ActionOutputSingleValue extends ActionOutput {
    private final ActionArgument _argument;
    public ActionOutputSingleValue(ActionArgument type) {
        super(type.getRelatedStateVariable().getType());
        _argument = Preconditions.checkNotNull(type);
    }
    public ActionArgument getArgument() {
        return _argument;
    }
    public boolean isSingleValue() {
        return true;
    }
}