package de.kalass.sonoscontrol.generator.model;

import java.util.List;

import de.kalass.sonoscontrol.generator.model.action.Action;


public class ServiceImpl implements IService {

    private final JavaClassName _javaClassName;
    private final IService _service;

    public ServiceImpl(IService service, JavaPackageName implDirName) {
        super();
        _service = service;
        _javaClassName = implDirName.childClass(service.getUpnpName() + "ServiceClingImpl");
    }

    @Override
    public String getUpnpName() {
        return _service.getUpnpName();
    }

    @Override
    public boolean isCustomSerializationNeeded() {
        return _service.isCustomSerializationNeeded();
    }

    @Override
    public List<Action> getActions() {
        return _service.getActions();
    }

    @Override
    public List<StateVariable> getStateVariables() {
        return _service.getStateVariables();
    }

    @Override
    public JavaClassName getJavaClassName() {
        return _service.getJavaClassName();
    }

    @Override
    public List<JavaClassName> getNeededImports() {
        return _service.getNeededImports();
    }


    public JavaClassName getJavaImplClassName() {
        return _javaClassName;
    }

}
