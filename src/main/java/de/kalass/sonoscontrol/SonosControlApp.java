package de.kalass.sonoscontrol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosControl.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.core.Callback2;
import de.kalass.sonoscontrol.api.core.LoggingErrorStrategy;
import de.kalass.sonoscontrol.api.core.ZoneIcon;
import de.kalass.sonoscontrol.api.core.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.RenderingControlService;
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
				propsService.retrieveZoneAttributes(new Callback2<ZoneName, ZoneIcon>() {

					@Override
					public void success(ZoneName currentZoneName, ZoneIcon currentIcon) {
						LOG.info("Retrieved Zone Attributes: " + currentZoneName + " ZoneIcon " + currentIcon);
						
					}
				});

				final RenderingControlService renderingControlService = device.getRenderingControlService();
				renderingControlService.retrieveVolume(new Callback1<Long>() {
					
					@Override
					public void success(Long volume) {
						LOG.info("THE VOLUME IS: " + volume);
					}
				});
				renderingControlService.retrieveMute(new Callback1<Boolean>() {

					@Override
					public void success(Boolean mute) {
						LOG.info("Mute IS: " + mute);
					}
				});
				renderingControlService.setMute(false, new Callback0() {
					
					@Override
					public void success() {
						LOG.info("SUCCESS");
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