package de.kalass.sonoscontrol.clingimpl.services;

import java.util.concurrent.CountDownLatch;

import javax.annotation.CheckForNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.teleal.cling.UpnpService;
import org.teleal.cling.controlpoint.ActionCallback;
import org.teleal.cling.controlpoint.SubscriptionCallback;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.gena.CancelReason;
import org.teleal.cling.model.gena.GENASubscription;
import org.teleal.cling.model.message.UpnpResponse;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.meta.Service;
import org.teleal.cling.model.state.StateVariableValue;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.ServiceId;
import org.teleal.cling.model.types.UDAServiceId;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.types.UnsignedIntegerTwoBytes;

import de.kalass.sonoscontrol.api.core.Callback;
import de.kalass.sonoscontrol.api.core.ErrorStrategy;

@SuppressWarnings("rawtypes")
public abstract class AbstractServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractServiceImpl.class);

    private final ServiceId _serviceId;

    private final UpnpService _upnpService;
    private final Device _device;

    private final ErrorStrategy _errorStrategy;
    protected final CountDownLatch _eventsReceivedLatch = new CountDownLatch(1);

    private boolean _available;

    public abstract class Call<C extends Callback> {
        private final String _actionName;

        Call(String actionName) {
            this._actionName = actionName;
        }
        public String getActionName() {
            return _actionName;
        }

        protected void setInput(ActionInvocation invocation, String upnpType, String name, String value) {
            invocation.setInput(name, value);
        }
        protected void setInput(ActionInvocation invocation, String upnpType, String name, boolean value) {
            invocation.setInput(name, value);
        }
        protected void setInput(ActionInvocation invocation, String upnpType, String name, Long value) {
            final Object upnpValue;
            if (value == null) {
                invocation.setInput(name, null);
                return;
            }
            if ("ui4".equals(upnpType) || "i4".equals(upnpType)) {
                upnpValue = new UnsignedIntegerFourBytes(value);
            } else if ("ui2".equals(upnpType) || "i2".equals(upnpType)) {
                upnpValue = new UnsignedIntegerTwoBytes(value);
            } else {
                throw new IllegalStateException();
            }
            invocation.setInput(name, upnpValue);
        }
        public void prepareArguments(ActionInvocation invocation) throws InvalidValueException{}
        public abstract void success(C handler, ActionInvocation invocation);
    }

    public AbstractServiceImpl(String serviceIdName, UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        this._serviceId =  new UDAServiceId(serviceIdName);
        this._upnpService = upnpService;
        this._device = device;
        this._errorStrategy = errorStrategy;
        final Service service = getService();
        if (service == null) {
            _available = false;
            return;
        }
        _available = true;
        upnpService.getControlPoint().execute(new SubscriptionCallback(service) {

            @Override
            protected void failed(GENASubscription subscription,
                    UpnpResponse responseStatus, Exception exception, String defaultMsg) {
            }

            @Override
            protected void eventsMissed(GENASubscription subscription,
                    int numberOfMissedEvents) {
            }

            @Override
            protected void eventReceived(GENASubscription subscription) {
                try {
                    AbstractServiceImpl.this.eventReceived(subscription);
                } catch(RuntimeException e) {
                    LOG.error("failed to process received event: ", e);
                }
                _eventsReceivedLatch.countDown();
            }

            @Override
            protected void established(GENASubscription subscription) {
            }

            @Override
            protected void ended(GENASubscription subscription, CancelReason reason,
                    UpnpResponse responseStatus) {
            }
        });

    }

    public boolean isAvailable() {
        return _available;
    }

    protected void eventReceived(GENASubscription subscription) {

    }
    public <C extends Callback> C execute(final C successHandler, final Call<? super C> handler) {
        Service service;
        if ((service = getService()) != null) {

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
                            handler.success(successHandler, invocation);
                        }

                        @Override
                        public void failure(ActionInvocation invocation, UpnpResponse operation, String defaultMsg) {
                            _errorStrategy.onFailure(successHandler, defaultMsg);
                        }
                    }
                    );
        } else {
            LOG.warn("Cannot find the Service " + _serviceId + " for device "+ _device);
        }
        return successHandler;
    }

    protected Object getValue(String upnpType, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof StateVariableValue) {
            return getValue(upnpType, ((StateVariableValue)value).getValue());
        }
        if ("ui4".equals(upnpType) || "i4".equals(upnpType)) {
            if (value instanceof String) {
                return Long.valueOf(Long.parseLong((String)value, 10));
            }
            if (value instanceof Integer) {
                return Long.valueOf(((Integer)value).longValue());
            }
            if (value instanceof Long) {
                return value;
            }
            return ((UnsignedIntegerFourBytes)value).getValue();
        } else if ("ui2".equals(upnpType) || "i2".equals(upnpType)) {
            if (value instanceof String) {
                return Long.valueOf(Long.parseLong((String)value, 10));
            }
            if (value instanceof Integer) {
                return Long.valueOf(((Integer)value).longValue());
            }
            if (value instanceof Long) {
                return value;
            }
            return ((UnsignedIntegerTwoBytes)value).getValue();
        } else if ("string".equals(upnpType)){
            if (!(value instanceof String)) {
                throw new IllegalArgumentException("expected value of type String, but got " + value.getClass().getName());
            }
            return String.class.cast(value);
        } else if ("boolean".equals(upnpType)){
            if (value instanceof String) {
                return Boolean.valueOf("1".equals(value) || "true".equals(((String) value).toLowerCase()));
            }
            if (!(value instanceof Boolean)) {
                throw new IllegalArgumentException("expected value of type Boolean, but got " + value.getClass().getName());
            }
            return Boolean.class.cast(value);
        } else {
            throw new IllegalStateException();
        }
    }

    private static final int MAX_RETRIES = 6;
    private static final int RETRY_MILLIS = 200;

    @CheckForNull
    protected Service getService() {
        Service service = null;
        int count = MAX_RETRIES;
        int retryMillis = RETRY_MILLIS;
        while (count > 0 && (service = this._device.findService(_serviceId)) == null) {
            count -= 1;
            LOG.warn("Could not find Service " + _serviceId + " on device " + _device + ", will wait " + retryMillis + "ms  and then retry for the " + (MAX_RETRIES - count) + ". time");
            try {
                Thread.sleep(retryMillis);
            } catch (InterruptedException e) {
                LOG.warn("Interrupted while waiting until retry to find Service");
            }
            retryMillis = (int)Math.round(retryMillis * 1.5);
        }
        return service;
    }
}
