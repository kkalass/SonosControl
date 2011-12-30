package de.kalass.sonoscontrol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosControl.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.LoggingErrorStrategy;
import de.kalass.sonoscontrol.api.core.ZoneIcon;
import de.kalass.sonoscontrol.api.core.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService.RetrieveZoneAttributes;
import de.kalass.sonoscontrol.clingimpl.SonosControlClingImpl;

public class SonosControlApp {
	private static final Logger LOG = LoggerFactory.getLogger(SonosControlApp.class);

    public static final ZoneName WOHNZIMMER = ZoneName.getInstance("Wohnzimmer");
    public static final ZoneName ESSZIMMER = ZoneName.getInstance("Esszimmer");
    
    public static void main(String[] args) throws Exception {

    	final SonosControl sonosControl = new SonosControlClingImpl();
    	sonosControl.setErrorStrategy(new LoggingErrorStrategy());
    	sonosControl.setTimeout(10000);
    	
    	sonosControl.executeOnZone(ESSZIMMER, new SonosDeviceCallback() {
			
			@Override
			public void success(SonosDevice device) {
				LOG.info("Found  Sonos device " + device.getZoneName());
				Preconditions.checkState(device.getZoneName().equals(ESSZIMMER));

				final DevicePropertiesService propsService = device.getDevicePropertiesService();
				propsService.retrieveZoneAttributes(new RetrieveZoneAttributes() {

					@Override
					public void success(ZoneName currentZoneName, ZoneIcon currentIcon) {
						LOG.info("Retrieved Zone Attributes: " + currentZoneName + " ZoneIcon " + currentIcon);
						
					}
				});

			}
		});
    	
        Runtime.getRuntime().addShutdownHook(new Thread() {
        	@Override
        	public void run() {
        		System.out.println("Stopping Sonos Control...");
        		sonosControl.shutdown();
        	}
        });
        
    }
}