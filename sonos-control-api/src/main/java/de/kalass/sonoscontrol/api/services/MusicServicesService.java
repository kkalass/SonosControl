// AUTOGENERATED: 0f8b6b6edb53679b9a3c867622cd7596
// AUTOGENERATED: 09.01.2012 12:49:21
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;
import javax.annotation.CheckForNull;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.musicservices.ListAvailableServicesResult;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceListVersion;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceTypeList;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceDescriptorList;

public interface MusicServicesService {


    @CheckForNull
    ServiceListVersion getLastValueForServiceListVersion();

    void addServiceListVersionListener(EventListener<ServiceListVersion> listener);

    void removeServiceListVersionListener(EventListener<ServiceListVersion> listener);


    <C extends Callback1<ListAvailableServicesResult>> C listAvailableServices(C callback);

    <C extends Callback0> C updateAvailableServices(C callback);

}
