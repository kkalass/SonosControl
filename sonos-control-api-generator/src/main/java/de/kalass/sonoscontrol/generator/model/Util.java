package de.kalass.sonoscontrol.generator.model;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;


public class Util {

    public static List<JavaClassName> getNeededImports(
            final JavaPackageName packageName,
            Iterable<JavaClassName> classNames
            ) {
        return ImmutableList.copyOf(Iterables.filter(classNames, new Predicate<JavaClassName>() {
            @Override
            public boolean apply(JavaClassName className) {
                JavaPackageName pkgName = className.getPackage();
                return !packageName.equals(pkgName) && !"java.lang".equals(pkgName.getFQN());
            }
        }));
    }

}