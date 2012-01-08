package de.kalass.sonoscontrol.generator.model;

import java.util.List;

import de.kalass.sonoscontrol.generator.model.action.Action;

public interface IService {

    String getUpnpName();

    List<Action> getActions();

    List<StateVariable> getStateVariables();

    JavaClassName getJavaClassName();

    List<JavaClassName> getNeededImports();

    boolean isCustomSerializationNeeded();
}