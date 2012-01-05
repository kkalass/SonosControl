

/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.clingimpl.services;

import de.kalass.sonoscontrol.api.services.ZoneGroupTopologyService;
import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.types.InvalidValueException;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;

import de.kalass.sonoscontrol.clingimpl.services.AbstractServiceImpl;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateItem;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.DiagnosticID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.CachedOnly;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.AvailableSoftwareUpdate;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateFlags;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroupState;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateURL;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.Version;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UnresponsiveDeviceActionType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ThirdPartyMediaServers;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.AlarmRunSequence;

@SuppressWarnings("rawtypes")
public final class ZoneGroupTopologyServiceClingImpl extends AbstractServiceImpl implements ZoneGroupTopologyService {

    public ZoneGroupTopologyServiceClingImpl(UpnpService upnpService, Device device, ErrorStrategy errorStrategy) {
        super("ZoneGroupTopology", upnpService, device, errorStrategy);
    }


    public AvailableSoftwareUpdate getAvailableSoftwareUpdate() {
        throw new UnsupportedOperationException();
    }

    public ZoneGroupState getZoneGroupState() {
        throw new UnsupportedOperationException();
    }

    public ThirdPartyMediaServers getThirdPartyMediaServers() {
        throw new UnsupportedOperationException();
    }

    public AlarmRunSequence getAlarmRunSequence() {
        throw new UnsupportedOperationException();
    }


    public <C extends Callback1<UpdateItem>> C checkForUpdate(final UpdateType updateType, final CachedOnly cachedOnly, final Version version, final C successHandler) {
        return execute(successHandler, new Call<C>("CheckForUpdate") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "UpdateType", updateType.getValue());
                setInput(invocation,"boolean", "CachedOnly", cachedOnly.getValue());
                setInput(invocation,"string", "Version", version.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final UpdateItem value = UpdateItem.getInstance(getString("string",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

    public <C extends Callback0> C beginSoftwareUpdate(final UpdateURL updateURL, final UpdateFlags flags, final C successHandler) {
        return execute(successHandler, new Call<C>("BeginSoftwareUpdate") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "UpdateURL", updateURL.getValue());
                setInput(invocation,"ui4", "Flags", flags.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C reportUnresponsiveDevice(final MemberID deviceUUID, final UnresponsiveDeviceActionType desiredAction, final C successHandler) {
        return execute(successHandler, new Call<C>("ReportUnresponsiveDevice") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
                setInput(invocation,"string", "DeviceUUID", deviceUUID.getValue());
                setInput(invocation,"string", "DesiredAction", desiredAction.getValue());
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                // no return values
                handler.success();
            }
        });
    }

    public <C extends Callback0> C reportAlarmStartedRunning(final C successHandler) {
        return execute(successHandler, new Call<C>("ReportAlarmStartedRunning") {
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

    public <C extends Callback1<DiagnosticID>> C submitDiagnostics(final C successHandler) {
        return execute(successHandler, new Call<C>("SubmitDiagnostics") {
            @Override
            public void prepareArguments(ActionInvocation invocation)
                    throws InvalidValueException {
                // Throws InvalidValueException if the value is of wrong type
            }
            @Override
            public void success(C handler, ActionInvocation invocation) {
                 assert invocation.getOutput().length == 1;
                 final ActionArgumentValue[] output = invocation.getOutput();
                 final DiagnosticID value = DiagnosticID.getInstance(getLong("ui4",output[0].getValue()));
                 handler.success(value);
            }
        });
    }

}
