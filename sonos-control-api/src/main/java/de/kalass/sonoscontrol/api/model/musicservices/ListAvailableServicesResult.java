/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.musicservices;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class ListAvailableServicesResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ServiceDescriptorList _availableServiceDescriptorList;
    private final ServiceTypeList _availableServiceTypeList;
    private final ServiceListVersion _availableServiceListVersion;

    public ListAvailableServicesResult(
        final ServiceDescriptorList availableServiceDescriptorList,
        final ServiceTypeList availableServiceTypeList,
        final ServiceListVersion availableServiceListVersion
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

    public String toString() {
        return Objects.toStringHelper(this)
        .add("availableServiceDescriptorList", _availableServiceDescriptorList)
        .add("availableServiceTypeList", _availableServiceTypeList)
        .add("availableServiceListVersion", _availableServiceListVersion)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _availableServiceDescriptorList,
            _availableServiceTypeList,
            _availableServiceListVersion
        );
    }

    public boolean equals(Object other) {
        if (other instanceof ListAvailableServicesResult) {
            ListAvailableServicesResult obj = (ListAvailableServicesResult)other;
            return 
                    Objects.equal(_availableServiceDescriptorList, obj._availableServiceDescriptorList) &&
                    Objects.equal(_availableServiceTypeList, obj._availableServiceTypeList) &&
                    Objects.equal(_availableServiceListVersion, obj._availableServiceListVersion) 
            ;
        }
        return false;
    }

}
