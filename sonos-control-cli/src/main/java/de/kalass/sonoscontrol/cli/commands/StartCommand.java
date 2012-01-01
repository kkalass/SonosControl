package de.kalass.sonoscontrol.cli.commands;

import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.model.avtransport.AVTransportURI;
import de.kalass.sonoscontrol.api.services.AVTransportService;
import de.kalass.sonoscontrol.cli.arguments.StartArgs;

public final class StartCommand extends SonosDeviceCommand {

	private final String _trackUri;

	public StartCommand(StartArgs args) {
		super(args);
		_trackUri = args.getTrackUri();
	}

	@Override
	public void call(final SonosDevice device, final CliCommandResultCallback callback) {
		final AVTransportService avTransportService = device.getAVTransportService();
		
		// FIXME (KK): replace Hack with proper radio favourites lookup
		final Callback0 playCallback = new CallbackWrapper(callback, "Started playing ");
		final AVTransportURI trackUri = _trackUri != null ? ("radio:favourites:NDR2".equals(_trackUri) ? AVTransportURI.valueOf("x-rincon-mp3radio://ndrstream.ic.llnwd.net/stream/ndrstream_ndr2_hi_mp3") : AVTransportURI.valueOf(_trackUri)) : null;
		if (trackUri != null) {
			avTransportService.setAVTransportURI(trackUri, null, new Callback0() {
				
				@Override
				public void success() {
					avTransportService.play(playCallback);
				}
			});
		} else {
			avTransportService.play(playCallback);
		}
	}
}