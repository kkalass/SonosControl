package de.kalass.sonoscontrol.clingimpl;

import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.model.message.header.STAllHeader;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.registry.DefaultRegistryListener;
import org.teleal.cling.registry.Registry;
import org.teleal.cling.registry.RegistryListener;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.core.ZoneIcon;
import de.kalass.sonoscontrol.api.core.ZoneName;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService;
import de.kalass.sonoscontrol.api.services.DevicePropertiesService.RetrieveZoneAttributes;

/**
 * Implementation of the SonosControl service, using CLING http://teleal.org/projects/cling
 * @author klas
 */
public class SonosControlClingImpl implements SonosControl {
	//private static final Logger LOG = LoggerFactory.getLogger(SonosControlClingImpl.class);
	
	private final UpnpService _upnpService;

	private ErrorStrategy _errorStrategy;

	private int _millis;
	
    private final class ExecuteOnZoneListener extends
			DefaultRegistryListener {
		private final SonosDeviceCallback callback;
		private final ZoneName zoneName;

		private ExecuteOnZoneListener(SonosDeviceCallback callback,
				ZoneName zoneName) {
			this.callback = callback;
			this.zoneName = zoneName;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public void deviceAdded(Registry registry, final Device device) {
			final DevicePropertiesService propsService = new DevicePropertiesServiceImpl(_upnpService, device, _errorStrategy);
			propsService.retrieveZoneAttributes(new RetrieveZoneAttributes() {
				
				@Override
				public void success(ZoneName currentZoneName, ZoneIcon currentIcon) {
					if (zoneName.equals(currentZoneName)) {
						callback.success(new SonosDeviceImpl(zoneName, propsService, _upnpService, device));
						// avoid firing multiple times
						_upnpService.getRegistry().removeListener(ExecuteOnZoneListener.this);
					}
				}
			});
		}
	}

	public SonosControlClingImpl() {
		this(new UpnpServiceImpl());
	}
	
	public SonosControlClingImpl(UpnpService upnpService) {
        this._upnpService = upnpService;
	}
	
	@Override
	public void setErrorStrategy(ErrorStrategy errorStrategy) {
		this._errorStrategy = errorStrategy;
	}

	@Override
	public void setTimeout(int millis) {
		this._millis = millis;
	}
	
	@Override
	public void shutdown() {
		_upnpService.shutdown();
	}
	
	protected void execute(RegistryListener listener, int timeout) {
		// FIXME (KK): how to implement timeout?
		this._upnpService.getRegistry().addListener(listener);
		
		// Send a search message to all devices and services, they should respond soon
		this._upnpService.getControlPoint().search(new STAllHeader());
	}

	@Override
	public void executeOnZone(final ZoneName zoneName, final SonosDeviceCallback callback) {
		execute(new ExecuteOnZoneListener(callback, zoneName), _millis);
	}
}
