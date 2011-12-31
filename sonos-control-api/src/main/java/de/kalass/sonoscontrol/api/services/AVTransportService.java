package de.kalass.sonoscontrol.api.services;

import javax.annotation.Nullable;

import de.kalass.sonoscontrol.api.core.Callback0;

public interface AVTransportService {
	<C extends Callback0> C  stop(@Nullable C successHandler);
	<C extends Callback0> C play(@Nullable C successHandler);
}
