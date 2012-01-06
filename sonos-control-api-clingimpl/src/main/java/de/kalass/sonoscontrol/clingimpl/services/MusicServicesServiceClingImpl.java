

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.MusicServicesService;
import de.kalass.sonoscontrol.api.core.EventListener;

import org.teleal.cling.model.gena.GENASubscription;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.state.StateVariableValue;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.musicservices.ListAvailableServicesResult;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceListVersion;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceTypeList;
import de.kalass.sonoscontrol.api.model.musicservices.ServiceDescriptorList;

@SuppressWarnings("rawtypes")
public final class MusicServicesServiceClingImpl extends AbstractServiceImpl implements MusicServicesService {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(MusicServicesServiceClingImpl.class);
    private final Map<String, Object> _eventedValues = new ConcurrentHashMap<String, Object>();
    private final CountDownLatch _eventsReceivedLatch = new CountDownLatch(1);
    private final List<EventListener<ServiceListVersion>> _changeServiceListVersionListeners = new ArrayList<EventListener<ServiceListVersion>>();

    public MusicServicesServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("MusicServices", upnpService, device, errorStrategy);
    }


    public <C extends Callback1<ListAvailableServicesResult>> C listAvailableServices(final C successHandler) {
        return execute(successHandler, new Call<C>("ListAvailableServices") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                final ActionArgumentValue[] output = invocation.getOutput();
                final ServiceDescriptorList value0 = ServiceDescriptorList.getInstance((String)getValue("string",output[0].getValue()));
                final ServiceTypeList value1 = ServiceTypeList.getInstance((String)getValue("string",output[1].getValue()));
                final ServiceListVersion value2 = ServiceListVersion.getInstance((String)getValue("string",output[2].getValue()));
                final ListAvailableServicesResult value = ListAvailableServicesResult.getInstance(value0,value1,value2);
                handler.success(value);
            }
        });
    }

    public <C extends Callback0> C updateAvailableServices(final C successHandler) {
        return execute(successHandler, new Call<C>("UpdateAvailableServices") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    protected void eventReceived(GENASubscription subscription) {
        final Map values = subscription.getCurrentValues();
        final Map<String, Object> stored = new HashMap<String, Object>(_eventedValues);


        final ServiceListVersion newServiceListVersion = convertServiceListVersion((String)getValue("string", ((StateVariableValue)values.get("ServiceListVersion")).getValue()));
        final ServiceListVersion oldServiceListVersion = (ServiceListVersion)stored.get("ServiceListVersion");
        if (!Objects.equal(oldServiceListVersion, newServiceListVersion)) {
            _eventedValues.put("ServiceListVersion", newServiceListVersion);
        }

        // after the values were updated, send the change notifications

        if (!Objects.equal(oldServiceListVersion, newServiceListVersion)) {
            notifyServiceListVersionChanged(oldServiceListVersion, newServiceListVersion);
        }
        _eventsReceivedLatch.countDown();
    }

    protected Object getEventedValueOrWait(String key) {
        try {
            _eventsReceivedLatch.await();
        } catch (InterruptedException e) {
            LOG.warn("waiting for evented value countdown latch was interrupted, will continue");
        }
        return _eventedValues.get(key);
    }


    public ServiceListVersion getServiceListVersion() {
        return (ServiceListVersion)getEventedValueOrWait("ServiceListVersion");
    }

    public void addServiceListVersionListener(EventListener<ServiceListVersion> listener) {
        synchronized(_changeServiceListVersionListeners) {
            _changeServiceListVersionListeners.add(listener);
        }
    }

    public void removeServiceListVersionListener(EventListener<ServiceListVersion> listener) {
        synchronized(_changeServiceListVersionListeners) {
            _changeServiceListVersionListeners.remove(listener);
        }
    }

    protected void notifyServiceListVersionChanged(ServiceListVersion oldValue, ServiceListVersion newValue) {
        final Iterable<EventListener<ServiceListVersion>> listeners;
        synchronized(_changeServiceListVersionListeners) {
            listeners = new ArrayList<EventListener<ServiceListVersion>>(_changeServiceListVersionListeners);            
        }
        for(EventListener<ServiceListVersion> listener: listeners) {
            listener.valueChanged(oldValue, newValue);
        }
    }

    protected ServiceListVersion convertServiceListVersion(String rawValue) {
        return ServiceListVersion.getInstance(rawValue);
    }
}
