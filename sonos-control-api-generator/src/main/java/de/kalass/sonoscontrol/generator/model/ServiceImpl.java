package de.kalass.sonoscontrol.generator.model;

import de.kalass.sonoscontrol.generator.upnp.UpnpService;

public class ServiceImpl extends Service {

    private final JavaClassName _javaClassName;

    public ServiceImpl(UpnpService scdp, NameFactory nameFactory, JavaPackageName implDirName) {
        super(scdp, nameFactory);
        _javaClassName = implDirName.childClass(scdp.getName() + "ServiceClingImpl");
    }

    public JavaClassName getJavaImplClassName() {
        return _javaClassName;
    }

}
