package de.kalass.sonoscontrol.api.services;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;

public interface RenderingControlService {
	<C extends Callback1<Long>> C retrieveVolume(@Nonnull C successHandler);
	<C extends Callback1<Boolean>> C retrieveMute(@Nonnull C successHandler);
	<C extends Callback0> C setMute(boolean mute, @Nullable C successHandler);
}
