/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.musicservices.ListAvailableServicesResult;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceListVersion;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceTypeList;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceDescriptorList;

public interface MusicServicesService {


    ServiceListVersion getServiceListVersion();


    <C extends Callback1<ListAvailableServicesResult>> C listAvailableServices(C callback);

    <C extends Callback0> C updateAvailableServices(C callback);

}
