package de.kalass.sonoscontrol;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.api.control.ExecutionMode;
import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.control.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.core.EventListener;
import de.kalass.sonoscontrol.api.core.LoggingErrorStrategy;
import de.kalass.sonoscontrol.api.core.VoidCallback;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.avtransport.AVTransportURI;
import de.kalass.sonoscontrol.api.model.avtransport.GroupID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroup;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroupMember;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroupState;
import de.kalass.sonoscontrol.api.services.ZoneGroupTopologyService;
import de.kalass.sonoscontrol.cli.arguments.Arguments;
import de.kalass.sonoscontrol.cli.arguments.ArgumentsVisitor;
import de.kalass.sonoscontrol.cli.arguments.GroupZoneSpec;
import de.kalass.sonoscontrol.cli.arguments.HelpArgs;
import de.kalass.sonoscontrol.cli.arguments.ListZones;
import de.kalass.sonoscontrol.cli.arguments.MuteArgs;
import de.kalass.sonoscontrol.cli.arguments.ShowArgs;
import de.kalass.sonoscontrol.cli.arguments.SingleZoneSpec;
import de.kalass.sonoscontrol.cli.arguments.StartArgs;
import de.kalass.sonoscontrol.cli.arguments.StopArgs;
import de.kalass.sonoscontrol.cli.arguments.ZoneSpec;
import de.kalass.sonoscontrol.cli.arguments.ZoneSpecVisitor;
import de.kalass.sonoscontrol.cli.commands.CliCommandResultCallback;
import de.kalass.sonoscontrol.cli.commands.MuteCommand;
import de.kalass.sonoscontrol.cli.commands.ShowCommand;
import de.kalass.sonoscontrol.cli.commands.SonosDeviceCommand;
import de.kalass.sonoscontrol.cli.commands.StartCommand;
import de.kalass.sonoscontrol.cli.commands.StopCommand;
import de.kalass.sonoscontrol.clingimpl.core.SonosControlClingImpl;

public class SonosControlApp {
    private static final class BindZones {
        private final GroupZoneSpec _spec;
        private final CliCommandResultCallback _multipleDevicesCommandResultCallback;
        private final SonosDeviceCommand _command;
        private final SonosControl _sonosControl;
        SonosDevice _groupCoordinator;
        Map<MemberID, SonosDevice> _pendingMembers = Maps.newHashMap();

        private BindZones(GroupZoneSpec spec,
                CliCommandResultCallback multipleDevicesCommandResultCallback,
                SonosDeviceCommand command, SonosControl sonosControl) {
            _spec = spec;
            _multipleDevicesCommandResultCallback = multipleDevicesCommandResultCallback;
            _command = command;
            _sonosControl = sonosControl;
        }

        private void setGroupOwningDevice(SonosDevice device,
                ZoneGroup ownedGroup) {
            synchronized(this) {
                _groupCoordinator = device;
                if (!_pendingMembers.isEmpty()) {
                    final Iterator<Map.Entry<MemberID, SonosDevice>> members = _pendingMembers.entrySet().iterator();
                    while (members.hasNext()) {
                        Map.Entry<MemberID, SonosDevice> next = members.next();
                        members.remove();
                        doAddToGroup(next.getValue(), next.getKey());
                    }
                }
            }
        }

        private void addToGroup(SonosDevice device) {
            synchronized(this) {
                MemberID memberId = device.getDeviceId();
                if (_groupCoordinator != null) {
                    doAddToGroup(device, memberId);
                } else {
                    _pendingMembers.put(memberId, device);
                }
            }
        }

        private void doAddToGroup(SonosDevice sonosDevice, MemberID memberId) {
            synchronized(this) {
                System.out.println("Try to add group member: " + memberId );
                final ZoneGroupTopologyService topologyService = _groupCoordinator.getZoneGroupTopologyService();
                final  MemberID coordinatorDeviceID = _groupCoordinator.getDeviceId();
                final ZoneGroup ownedGroup = topologyService.getLastValueForZoneGroupState().getOwnedGroup(coordinatorDeviceID);
                topologyService.addZoneGroupStateListener( new EventListener<ZoneGroupState>() {
                    @Override
                    public void valueChanged(
                            ZoneGroupState oldValue,
                            ZoneGroupState newValue) {
                        /**
                         * Device discovery is a little bit buggy on cling/android as of 15.01.2012.
                         * I was not able to trace that down, but if the master is running already,
                         * I can at least use its ZoneGroupState request to connect the new Sonos
                         */
                        System.out.println("Zone now contains: " + newValue.getOwnedGroup(coordinatorDeviceID).getMemberZoneNames());
                        topologyService.removeZoneGroupStateListener(this);
                    }
                });
                topologyService.addZoneGroupStateListener(new NewZoneListener(_sonosControl, _spec, coordinatorDeviceID));
                final Set<MemberID> currentMembers = ownedGroup.getMemberIds();
                if (!currentMembers.contains(memberId)) {
                    sonosDevice.getAVTransportService().setAVTransportURI(AVTransportURI.playFromDevice(coordinatorDeviceID), null, new VoidCallback()).waitForSuccess();
                }
            }

        }

        public void execute() {
            _sonosControl.executeOnAnyZone(new SonosDeviceCallback() {

                @Override
                public ExecutionMode execute(SonosDevice device) {
                    LOG.debug("Found  Sonos device " + device.getZoneName().getValue() + " => "+ device.getZoneName());
                    if (_spec.isGroupMember(device.getZoneName()) && !_spec.getGroupCoordinator().equals(device.getZoneName())) {
                        addToGroup(device);
                    }
                    return ExecutionMode.EACH_DEVICE_DETECTION;
                }
            });
            _sonosControl.executeOnZone(_spec.getGroupCoordinator(), new SonosDeviceCallback() {

                @Override
                public ExecutionMode execute(final SonosDevice device) {
                    final ZoneGroupTopologyService topologyService = Preconditions.checkNotNull(device.getZoneGroupTopologyService(), "topologyService must not be null!");
                    final ZoneGroupState zoneGroupState = topologyService.getLastValueForZoneGroupState();
                    if (zoneGroupState == null) {
                        topologyService.addZoneGroupStateListener(new EventListener<ZoneGroupState>() {
                            @Override
                            public void valueChanged(
                                    ZoneGroupState oldValue,
                                    ZoneGroupState newValue) {
                                registerOwnedGroup(device, newValue);
                                topologyService.removeZoneGroupStateListener(this);
                            }
                        });
                    } else {
                        registerOwnedGroup(device, zoneGroupState);
                    }
                    try {
                        _command.call(device, _multipleDevicesCommandResultCallback);
                    } catch(Throwable t) {
                        _multipleDevicesCommandResultCallback.fail(t);
                    }
                    //topologyService.addZoneGroupStateListener(new NewZoneListener(spec, device));
                    return ExecutionMode.FINISH;
                }
            });
        }

        private void registerOwnedGroup(SonosDevice device,
                final ZoneGroupState zoneGroupState) {
            final ZoneGroup ownedGroup = zoneGroupState.getOwnedGroup(device.getDeviceId());
            if (ownedGroup != null) {
                GroupID groupId = ownedGroup.getGroupId();
                System.out.println("found owned group: " + groupId + " " + ownedGroup.getMemberZoneNames());
                setGroupOwningDevice(device, ownedGroup);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    private static final class NewZoneListener implements
    EventListener<ZoneGroupState> {
        private final GroupZoneSpec _spec;
        private final SonosControl _sonosControl;
        private final MemberID _coordinatorDeviceId;

        private NewZoneListener(SonosControl sonosControl, GroupZoneSpec spec, MemberID coordinatorDeviceId) {
            _sonosControl = sonosControl;
            _spec = spec;
            _coordinatorDeviceId = coordinatorDeviceId;
        }

        @Override
        public void valueChanged(
                ZoneGroupState oldValue,
                ZoneGroupState newValue) {
            System.out.println("group master detected new zones: " + newValue);
            /**
             * Device discovery is a little bit buggy on cling/android as of 15.01.2012.
             * I was not able to trace down, why cling on android often misses to inform us
             * of a new device. It works fine with normal java.
             * But if the master is running already,
             * I can at least use its ZoneGroupState request to find new Sonos devices and connect them.
             */
            final ZoneGroup targetGroup = newValue.getOwnedGroup(_coordinatorDeviceId);
            final Map<MemberID, ZoneGroupMember> candidates = new HashMap<MemberID, ZoneGroupMember>();
            for (ZoneGroup group : newValue.getValue()) {
                if (!_coordinatorDeviceId.equals(group.getCoordinator())) {
                    // a 'foreign' group - test if there is a candidate
                    // to be added to the target group
                    final Map<MemberID, ZoneGroupMember> m = Maps.uniqueIndex(group.getMembers(), ZoneGroupMember.GET_ZONE_PLAYER_ID);
                    for (Map.Entry<MemberID, ZoneGroupMember> e : m.entrySet()) {
                        MemberID memberID = e.getKey();
                        if (_spec.isGroupMember(e.getValue().getZoneName()) && !targetGroup.getMemberIds().contains(memberID)) {
                            // OK - found a new device which apparently needs to be manually added because it is not in the target group,
                            // but part of the group spec
                            candidates.put(memberID, e.getValue());
                        }
                    }
                }
            }
            if (!candidates.isEmpty()) {
                System.out.println("Possibly detected new members to be added to group, will ask the control service to search for them explicitely: " + candidates);
                for (ZoneGroupMember m : candidates.values()) {
                    // for s
                    _sonosControl.executeOnZone(m.getZoneName(), new SonosDeviceCallback() {

                        @Override
                        public ExecutionMode execute(SonosDevice device) {
                            device.getAVTransportService().setAVTransportURI(AVTransportURI.playFromDevice(_coordinatorDeviceId), null, new VoidCallback()).waitForSuccess();
                            return ExecutionMode.FINISH;
                        }
                    });
                }
            }
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(SonosControlApp.class);
    public static Void execute(final SonosDeviceCommand command) {
        final SonosControl sonosControl = new SonosControlClingImpl();
        Runtime.getRuntime().addShutdownHook(new Thread("shutdown-hook") {
            @Override
            public void run() {
                LOG.debug("Stopping Sonos Control...");
                sonosControl.shutdown();
            }
        });
        return execute(sonosControl, command);
    }
    public static Void execute(final SonosControl sonosControl, final SonosDeviceCommand command) {

        final CliCommandResultCallback singleDeviceCommandResultCallback = new CliCommandResultCallback(){
            @Override
            public void success(String message) {
                System.out.println(message);
                System.exit(0);
            }
            @Override
            public void fail(Throwable t) {
                LOG.error(t.getMessage(), t);
                System.err.println("FAILED!");
                System.exit(1);
            }
        };

        final CliCommandResultCallback multipleDevicesCommandResultCallback = new CliCommandResultCallback(){
            @Override
            public void success(String message) {
                System.out.println(message);
                //System.exit(0);
            }
            @Override
            public void fail(Throwable t) {
                LOG.error(t.getMessage(), t);
                System.err.println("FAILED!");
                System.exit(1);
            }
        };

        sonosControl.setErrorStrategy(new LoggingErrorStrategy());

        final ZoneSpec zoneSpec = command.getZoneSpec();
        if (zoneSpec == null) {
            sonosControl.executeOnAnyZone(new SonosDeviceCallback() {

                @Override
                public ExecutionMode execute(SonosDevice device) {
                    try {
                        command.call(device, multipleDevicesCommandResultCallback);
                    } catch(Throwable t) {
                        multipleDevicesCommandResultCallback.fail(t);
                    }
                    return ExecutionMode.EACH_DEVICE_DETECTION;
                }
            });
            return null;
        }
        zoneSpec.invite(new ZoneSpecVisitor<Void>() {
            @Override
            public Void visitGroup(final GroupZoneSpec spec) {
                new BindZones(spec, multipleDevicesCommandResultCallback,
                        command, sonosControl).execute();
                return null;
            }
            @Override
            public Void visitSingleZone(final SingleZoneSpec spec) {
                sonosControl.executeOnZone(spec.getZoneName(), new SonosDeviceCallback() {

                    @Override
                    public ExecutionMode execute(SonosDevice device) {
                        LOG.debug("Found  Sonos device " + device.getZoneName());
                        Preconditions.checkState(device.getZoneName().equals(spec.getZoneName()));
                        try {
                            command.call(device, singleDeviceCommandResultCallback);
                        } catch(Throwable t) {
                            singleDeviceCommandResultCallback.fail(t);
                        }
                        return ExecutionMode.FINISH;
                    }
                });
                return null;
            }
        });


        return null;
    }

    public static void main(String[] args) throws Exception {

        // Start a user thread that runs the UPnP stack
        final Arguments commandArguments = Arguments.parse(args);
        commandArguments.invite(new ArgumentsVisitor<Void>() {
            @Override
            public Void visitHelp(HelpArgs help) {
                System.out.println("");
                System.out.println("Usage:");
                System.out.println("  sonos <cmd> <cmdoptions>");
                System.out.println("where <cmd> is one of:");
                System.out.println("  help\tPrints this help");
                System.out.println("  list \t\tShow information about the available zones");
                System.out.println("  show <zone>\tShow some information about the given zone");
                System.out.println("  stop <zone>\tStop playing in the given zone");
                System.out.println("  start <zone>\tStart playing in the given zone");
                System.out.println("  mute <zone> [on|off]\tMute the given zone");
                System.out.println("");
                System.out.println("Example:");
                System.out.println("  java -jar SonosControl.jar show Wohnzimmer");
                System.out.println("");

                System.exit(-1);
                return null;
            }


            @Override
            public Void visitShow(ShowArgs args) {
                return execute(new ShowCommand(args));
            }
            @Override
            public Void visitListZones(ListZones args) {
                return execute(new SonosDeviceCommand(args) {
                    @Override
                    public void call(SonosDevice device,
                            CliCommandResultCallback callback) throws Exception {
                        callback.success(device.getZoneName().getValue());
                    }
                });
            }
            @Override
            public Void visitMute(final MuteArgs args) {
                return execute(new MuteCommand(args));
            }
            @Override
            public Void visitStart(StartArgs args) {
                return execute(new StartCommand(args));
            }
            @Override
            public Void visitStop(StopArgs args) {
                return execute(new StopCommand(args));
            }
        });
    }

}