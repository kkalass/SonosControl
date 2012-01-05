package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.musicservices.ListAvailableServicesResult;

public interface MusicServicesService {


    <C extends Callback1<ListAvailableServicesResult>> C listAvailableServices(C callback);

    <C extends Callback0> C updateAvailableServices(C callback);

}
