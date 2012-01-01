package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountID;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountMd;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountPassword;
import de.kalass.sonoscontrol.api.model.systemproperties.AccountType;
import de.kalass.sonoscontrol.api.model.systemproperties.IsExpired;
import de.kalass.sonoscontrol.api.model.systemproperties.VariableName;
import de.kalass.sonoscontrol.api.model.systemproperties.VariableStringValue;

public interface SystemPropertiesService {

    public <C extends Callback0> C setString(VariableName variableName, VariableStringValue stringValue, C callback);

    public <C extends Callback1<VariableStringValue>> C getString(VariableName variableName, C callback);

    public <C extends Callback0> C remove(VariableName variableName, C callback);

    public <C extends Callback1<VariableStringValue>> C getWebCode(AccountType accountType, C callback);

    public <C extends Callback0> C provisionTrialAccount(AccountType accountType, C callback);

    public <C extends Callback1<IsExpired>> C provisionCredentialedTrialAccount(AccountType accountType, AccountID accountID, AccountPassword accountPassword, C callback);

    public <C extends Callback0> C migrateTrialAccount(AccountType targetAccountType, AccountID targetAccountID, AccountPassword targetAccountPassword, C callback);

    public <C extends Callback0> C addAccount(AccountType accountType, AccountID accountID, AccountPassword accountPassword, C callback);

    public <C extends Callback0> C removeAccount(AccountType accountType, AccountID accountID, C callback);

    public <C extends Callback0> C editAccountPassword(AccountType accountType, AccountID accountID, AccountPassword newAccountPassword, C callback);

    public <C extends Callback0> C editAccountMd(AccountType accountType, AccountID accountID, AccountMd newAccountMd, C callback);

    public <C extends Callback0> C doPostUpdateTasks(C callback);

    public <C extends Callback0> C resetThirdPartyCredentials(C callback);
}