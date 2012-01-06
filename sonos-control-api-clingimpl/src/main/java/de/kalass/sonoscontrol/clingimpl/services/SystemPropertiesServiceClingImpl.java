

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.SystemPropertiesService;
import de.kalass.sonoscontrol.api.core.EventListener;

import org.teleal.cling.model.gena.GENASubscription;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.state.StateVariableValue;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.systemproperties.VariableStringValue;
import de.kalass.sonoscontrol.api.model.systemproperties.IsExpired;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountID;
import de.kalass.sonoscontrol.api.model.systemproperties.VariableName;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountMd;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountType;
import de.kalass.sonoscontrol.api.model.systemproperties.StubsCreated;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountPassword;

@SuppressWarnings("rawtypes")
public final class SystemPropertiesServiceClingImpl extends AbstractServiceImpl implements SystemPropertiesService {
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();

    public SystemPropertiesServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("SystemProperties", upnpService, device, errorStrategy);
    }


    public <C extends Callback0> C setString(final VariableName variableName, final VariableStringValue stringValue, final C successHandler) {
        return execute(successHandler, new Call<C>("SetString") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "VariableName", variableName.getValue());
                setInput(invocation,"string", "StringValue", stringValue.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<VariableStringValue>> C retrieveString(final VariableName variableName, final C successHandler) {
        return execute(successHandler, new Call<C>("GetString") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "VariableName", variableName.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final VariableStringValue value = VariableStringValue.getInstance((String)getValue("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C remove(final VariableName variableName, final C successHandler) {
        return execute(successHandler, new Call<C>("Remove") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "VariableName", variableName.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<VariableStringValue>> C retrieveWebCode(final AccountType accountType, final C successHandler) {
        return execute(successHandler, new Call<C>("GetWebCode") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "AccountType", accountType.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final VariableStringValue value = VariableStringValue.getInstance((String)getValue("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C provisionTrialAccount(final AccountType accountType, final C successHandler) {
        return execute(successHandler, new Call<C>("ProvisionTrialAccount") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "AccountType", accountType.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback1<IsExpired>> C provisionCredentialedTrialAccount(final AccountType accountType, final AccountID accountID, final AccountPassword accountPassword, final C successHandler) {
        return execute(successHandler, new Call<C>("ProvisionCredentialedTrialAccount") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "AccountType", accountType.getValue());
                setInput(invocation,"string", "AccountID", accountID.getValue());
                setInput(invocation,"string", "AccountPassword", accountPassword.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final IsExpired value = IsExpired.getInstance((Boolean)getValue("boolean",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C migrateTrialAccount(final AccountType targetAccountType, final AccountID targetAccountID, final AccountPassword targetAccountPassword, final C successHandler) {
        return execute(successHandler, new Call<C>("MigrateTrialAccount") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "TargetAccountType", targetAccountType.getValue());
                setInput(invocation,"string", "TargetAccountID", targetAccountID.getValue());
                setInput(invocation,"string", "TargetAccountPassword", targetAccountPassword.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C addAccount(final AccountType accountType, final AccountID accountID, final AccountPassword accountPassword, final C successHandler) {
        return execute(successHandler, new Call<C>("AddAccount") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "AccountType", accountType.getValue());
                setInput(invocation,"string", "AccountID", accountID.getValue());
                setInput(invocation,"string", "AccountPassword", accountPassword.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C removeAccount(final AccountType accountType, final AccountID accountID, final C successHandler) {
        return execute(successHandler, new Call<C>("RemoveAccount") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "AccountType", accountType.getValue());
                setInput(invocation,"string", "AccountID", accountID.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C editAccountPassword(final AccountType accountType, final AccountID accountID, final AccountPassword newAccountPassword, final C successHandler) {
        return execute(successHandler, new Call<C>("EditAccountPassword") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "AccountType", accountType.getValue());
                setInput(invocation,"string", "AccountID", accountID.getValue());
                setInput(invocation,"string", "NewAccountPassword", newAccountPassword.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C editAccountMd(final AccountType accountType, final AccountID accountID, final AccountMd newAccountMd, final C successHandler) {
        return execute(successHandler, new Call<C>("EditAccountMd") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"ui4", "AccountType", accountType.getValue());
                setInput(invocation,"string", "AccountID", accountID.getValue());
                setInput(invocation,"string", "NewAccountMd", newAccountMd.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C doPostUpdateTasks(final C successHandler) {
        return execute(successHandler, new Call<C>("DoPostUpdateTasks") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C resetThirdPartyCredentials(final C successHandler) {
        return execute(successHandler, new Call<C>("ResetThirdPartyCredentials") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        // after the values were updated, send the change notifications

    }

}
