package de.kalass.sonoscontrol.clingimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.teleal.cling.UpnpService;
import org.teleal.cling.controlpoint.ActionCallback;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.message.UpnpResponse;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.meta.Service;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.ServiceId;
import org.teleal.cling.model.types.UDAServiceId;

import de.kalass.sonoscontrol.api.core.Callback;
import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.core.Callback2;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;

@SuppressWarnings("rawtypes")
public abstract class AbstractServiceImpl {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractServiceImpl.class);
	
	private final ServiceId _serviceId;
	
	private final UpnpService _upnpService;
	private final Device _device;

	private final ErrorStrategy _errorStrategy;

	public abstract class Call<C extends Callback> {
		private final C _successHandler;
		private final String _actionName;
		
		Call(String actionName, C successHandler) {
			this._actionName = actionName;
			this._successHandler = successHandler;
		}
		public String getActionName() {
			return _actionName;
		}
		public C getSuccessHandler() {
			return _successHandler;
		}
		public void prepareArguments(ActionInvocation invocation) throws InvalidValueException{}
		public abstract void success(C handler, ActionInvocation invocation);
	}
	
	public abstract class Call0 extends Call<Callback0> {
		Call0(String actionName, Callback0 successHandler) {
			super(actionName, successHandler);
		}
		@Override
		public void success(Callback0 handler, ActionInvocation invocation) {
			handler.success();
		}
	}
	public abstract class Call1<T> extends Call<Callback1<T>> {

		Call1(String actionName, Callback1<T> successHandler) {
			super(actionName, successHandler);
		}
		@Override
		public final void success(Callback1<T> handler, ActionInvocation invocation) {
			assert invocation.getOutput().length == 1;
			final ActionArgumentValue[] output = invocation.getOutput();
			success(handler, output[0]);
		}
		public abstract void success(Callback1<T> handler, ActionArgumentValue p1);
	}
	
	public abstract class Call2<T, V> extends Call<Callback2<T, V>> {

		Call2(String actionName, Callback2<T, V> successHandler) {
			super(actionName, successHandler);
		}
		@Override
		public final void success(Callback2<T, V> handler, ActionInvocation invocation) {
			assert invocation.getOutput().length == 2;
			final ActionArgumentValue[] output = invocation.getOutput();
			success(handler, output[0], output[1]);
		}
		public abstract void success(Callback2<T, V> handler, ActionArgumentValue p1, ActionArgumentValue p2);
	}
	public AbstractServiceImpl(String serviceIdName, UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
		this._serviceId =  new UDAServiceId(serviceIdName);
		this._upnpService = upnpService;
		this._device = device;
		this._errorStrategy = errorStrategy;
	}

	public <C extends Callback> void execute(final Call<C> handler) {
		Service service;
		if ((service = this._device.findService(_serviceId)) != null) {

			// Executes asynchronous in the background
			@SuppressWarnings("unchecked")
			final ActionInvocation actionInvocation = new ActionInvocation(service.getAction(handler.getActionName()));
			try {
				handler.prepareArguments(actionInvocation);
			} catch (InvalidValueException ex) {
                System.err.println(ex.getMessage());
                System.exit(1);
			}
			this._upnpService.getControlPoint().execute(
					new ActionCallback(actionInvocation) {

						@Override
						public void success(ActionInvocation invocation) {
							handler.success(handler.getSuccessHandler(), invocation);
						}

						@Override
						public void failure(ActionInvocation invocation, UpnpResponse operation, String defaultMsg) {
							_errorStrategy.onFailure(handler.getSuccessHandler(), defaultMsg);
						}
					}
					);
		} else {
			LOG.warn("Cannot find the Service " + _serviceId + " for device "+ _device);
		}
	}
}
