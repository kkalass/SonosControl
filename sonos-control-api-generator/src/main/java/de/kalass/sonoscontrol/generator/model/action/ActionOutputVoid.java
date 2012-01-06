package de.kalass.sonoscontrol.generator.model.action;

import de.kalass.sonoscontrol.generator.model.JavaClassName;


public final class ActionOutputVoid extends ActionOutput {
    @Override
    public JavaClassName getJavaClassName() {
        return JavaClassName.JAVA_LANG_VOID;
    }
}