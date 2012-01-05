package de.kalass.sonoscontrol.cli.commands;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.FailableCallback;

final class CallbackWrapper implements Callback0, FailableCallback {
    private final String _msg;
    private final CliCommandResultCallback _callback;

    public CallbackWrapper(CliCommandResultCallback callback, String msg) {
        super();
        _msg = msg;
        _callback = callback;
    }

    @Override
    public void success() {
        _callback.success(_msg);
    }

    @Override
    public void fail(String defaultMsg) {
        _callback.fail(new RuntimeException(defaultMsg));
    }
}