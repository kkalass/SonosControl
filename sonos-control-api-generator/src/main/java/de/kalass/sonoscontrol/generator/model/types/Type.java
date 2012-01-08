package de.kalass.sonoscontrol.generator.model.types;

import javax.annotation.Nonnull;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

import de.kalass.sonoscontrol.generator.model.JavaClassName;

public class Type {
    public static final Function<Type, JavaClassName> GET_JAVA_TYPE_NAME = new Function<Type, JavaClassName>() {
        @Override
        public JavaClassName apply(Type input) {
            return input.getJavaClassName();
        }
    };

    public static final Predicate<Type> IS_CUSTOM_SERIAlIZATION_NEEDED = new Predicate<Type>() {
        @Override
        public boolean apply(Type input) {
            return input.isCustomSerializationNeeded();
        }
    };


    private final JavaClassName _clsName;

    public Type(@Nonnull JavaClassName clsName) {
        _clsName = Preconditions.checkNotNull(clsName);
    }

    @Nonnull
    public JavaClassName getJavaClassName() {
        return _clsName;
    }
    public boolean isSingleInstanceType() {
        return false;
    }
    public boolean isCustomSerializationNeeded() {
        return false;
    }
}
