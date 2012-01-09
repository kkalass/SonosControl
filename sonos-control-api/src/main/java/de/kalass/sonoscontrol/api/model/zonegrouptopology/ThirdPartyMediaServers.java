package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import java.io.Serializable;
import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public final class ThirdPartyMediaServers implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
     * <MediaServers>
    <Service UDN="SA_RINCON11_<username>" Md="1" Password="<pwd>"
        NumAccounts="1" Username0="<username>" Md0="1" Password0="<pwd>" />
    <Service UDN="SA_RINCON519_<username>" Md="" Password="<pwd>"
        NumAccounts="1" Username0="<username>" Md0="" Password0="<pwd>" />
    <Service UDN="SA_RINCON2055_<username>" Md="" Password="<pwd>"
        NumAccounts="1" Username0="<username>" Md0="" Password0="<pwd>" />
</MediaServers>
     */

    public static final class AccountData {
        private final String _udn;
        private final String _md;
        private final int _numAccounts;
        private final Username _username;
        private final Password _password;
        private final String _md0;
        private final Password _password0;

        public AccountData(
                String udn, String md,
                int numAccounts,
                Username username, Password password, String md0, Password password0
                ) {
            _udn = udn;
            _md = md;
            _numAccounts = numAccounts;
            _username = username;
            _password = password;
            _md0 = md0;
            _password0 = password0;
        }

        public String getMd() {
            return _md;
        }

        public String getMd0() {
            return _md0;
        }

        public int getNumAccounts() {
            return _numAccounts;
        }
        public Password getPassword() {
            return _password;
        }
        public Password getPassword0() {
            return _password0;
        }
        public String getUdn() {
            return _udn;
        }
        public Username getUsername() {
            return _username;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(
                    _md, _md0, _password, _password0, _udn, _username, Integer.valueOf(_numAccounts)
                    );
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof AccountData) {
                final AccountData other = (AccountData)obj;
                return Objects.equal(_password, other._password) &&
                        Objects.equal(_password0, other._password0) &&
                        Objects.equal(_md, other._md) &&
                        Objects.equal(_md0, other._md0) &&
                        Objects.equal(_udn, other._udn) &&
                        Objects.equal(_username, other._username) &&
                        _numAccounts == other._numAccounts;
            }
            return false;
        }
    }

    private final List<AccountData> _value;

    private ThirdPartyMediaServers(List<AccountData> value) {
        _value = Preconditions.checkNotNull(value);
    }

    public List<AccountData> getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("value", _value).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_value);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ThirdPartyMediaServers) {
            ThirdPartyMediaServers obj = (ThirdPartyMediaServers)other;
            return Objects.equal(_value, obj._value);
        }
        return false;
    }


    public static ThirdPartyMediaServers getInstance(List<AccountData> mediaServers) {
        return new ThirdPartyMediaServers(mediaServers);
    }
}
