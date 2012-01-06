package de.kalass.sonoscontrol.generator.model;

public interface ServiceNameFactory {
    JavaClassName getServiceClassName();
    JavaClassName getModelClassName(String name);
}