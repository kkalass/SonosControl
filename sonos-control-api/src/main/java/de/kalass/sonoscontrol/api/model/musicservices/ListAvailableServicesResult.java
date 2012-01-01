package de.kalass.sonoscontrol.api.model.musicservices;

import com.google.common.base.Objects;

public class ListAvailableServicesResult {
    private final ServiceDescriptorList _availableServiceDescriptorList;
    private final ServiceTypeList _availableServiceTypeList;
    private final ServiceListVersion _availableServiceListVersion;

    public ListAvailableServicesResult(
        ServiceDescriptorList availableServiceDescriptorList,
        ServiceTypeList availableServiceTypeList,
        ServiceListVersion availableServiceListVersion
    ) {
        _availableServiceDescriptorList = availableServiceDescriptorList;
        _availableServiceTypeList = availableServiceTypeList;
        _availableServiceListVersion = availableServiceListVersion;
    }


    public ServiceDescriptorList getAvailableServiceDescriptorList() {
        return _availableServiceDescriptorList;
    }

    public ServiceTypeList getAvailableServiceTypeList() {
        return _availableServiceTypeList;
    }

    public ServiceListVersion getAvailableServiceListVersion() {
        return _availableServiceListVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
             _availableServiceDescriptorList,
             _availableServiceTypeList,
             _availableServiceListVersion
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ListAvailableServicesResult) {
            ListAvailableServicesResult obj = (ListAvailableServicesResult)other;
            return 
             Objects.equal(_availableServiceDescriptorList, obj._availableServiceDescriptorList) &&
             Objects.equal(_availableServiceTypeList, obj._availableServiceTypeList) &&
             Objects.equal(_availableServiceListVersion, obj._availableServiceListVersion);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
             .add("availableServiceDescriptorList",_availableServiceDescriptorList)
             .add("availableServiceTypeList",_availableServiceTypeList)
             .add("availableServiceListVersion",_availableServiceListVersion)
             .toString();
    }

}
