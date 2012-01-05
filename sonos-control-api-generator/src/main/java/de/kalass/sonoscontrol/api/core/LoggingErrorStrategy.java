package de.kalass.sonoscontrol.api.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingErrorStrategy implements ErrorStrategy {
	private static final Logger LOG = LoggerFactory.getLogger(LoggingErrorStrategy.class);
	
	@Override
	public void onFailure(Callback callback, String message) {
		LOG.error(callback + ": " + message);
	}
}
