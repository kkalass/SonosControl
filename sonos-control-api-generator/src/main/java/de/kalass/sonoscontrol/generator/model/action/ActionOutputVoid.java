package de.kalass.sonoscontrol.generator.model.action;

import de.kalass.sonoscontrol.generator.model.JavaClassName;
import de.kalass.sonoscontrol.generator.model.types.Type;


public final class ActionOutputVoid extends ActionOutput {
    public ActionOutputVoid() {
        super(new Type(JavaClassName.JAVA_LANG_VOID));
    }
}