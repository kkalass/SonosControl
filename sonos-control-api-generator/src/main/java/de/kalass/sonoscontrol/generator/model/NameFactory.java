package de.kalass.sonoscontrol.generator.model;

public interface  NameFactory {
    JavaPackageName getCorePackageName();
    ServiceNameFactory getServiceNameFactory(String serviceName);
}