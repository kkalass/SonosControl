package de.kalass.sonoscontrol.api.generator;

import java.io.File;

import com.google.common.base.Function;
import com.google.common.base.Objects;

public abstract class JavaFQNName {
    public static final Function<JavaFQNName, String> GET_FQN = new Function<JavaFQNName, String>() {
        @Override
        public String apply(JavaFQNName input) {
            return input.getFQN();
        }
    };

    private final String _fqn;

    public JavaFQNName(String fqn) {
        _fqn = fqn;
    }

    public String getFQN() {
        return _fqn;
    }

    public File asFile(File basedir) {
        return new File(basedir, convertToFileName(_fqn));
    }

    protected String convertToFileName(String fqn) {
        return fqn.replace('.', '/');
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JavaFQNName) {
            final JavaFQNName pn = (JavaFQNName)obj;
            return _fqn.equals(pn._fqn);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return _fqn.hashCode();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("fqn", _fqn).toString();
    }

}
