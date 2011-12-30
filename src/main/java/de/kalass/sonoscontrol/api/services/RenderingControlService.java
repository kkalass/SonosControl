package de.kalass.sonoscontrol.api.services;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;

public interface RenderingControlService {
	
	
	void retrieveVolume(@Nonnull Callback1<Long> successHandler);
	void retrieveMute(@Nonnull Callback1<Boolean> successHandler);
	void setMute(boolean mute, @Nullable Callback0 successHandler);
}
