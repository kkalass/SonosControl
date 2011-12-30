package de.kalass.sonoscontrol.api.core;

/**
 * Implements the Behavior when calls fail.
 * 
 * @author klas
 *
 */
public interface ErrorStrategy {
	
	void onFailure(Callback callback, String message);
}
