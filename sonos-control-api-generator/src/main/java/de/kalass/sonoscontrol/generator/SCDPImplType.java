package de.kalass.sonoscontrol.generator;

public class SCDPImplType extends SCDPType {

    private final JavaClassName _javaClassName;

    public SCDPImplType(SCDP scdp, NameFactory nameFactory, JavaPackageName implDirName) {
        super(scdp, nameFactory);
        _javaClassName = implDirName.childClass(scdp.getName() + "ClingImpl");
    }

    @Override
    public JavaClassName getJavaClassName() {
        return _javaClassName;
    }

}
