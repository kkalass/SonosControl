package de.kalass.sonoscontrol;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import de.kalass.sonoscontrol.api.control.SonosControl;
import de.kalass.sonoscontrol.api.control.SonosControl.SonosDeviceCallback;
import de.kalass.sonoscontrol.api.control.SonosDevice;
import de.kalass.sonoscontrol.api.core.EventListener;
import de.kalass.sonoscontrol.api.core.LoggingErrorStrategy;
import de.kalass.sonoscontrol.api.core.VoidCallback;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.avtransport.AVTransportURI;
import de.kalass.sonoscontrol.api.model.avtransport.GroupID;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroup;
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
    private static final Logger LOG = LoggerFactory.getLogger(SonosControlApp.class);

    static Void execute(final SonosDeviceCommand command) {
        final SonosControl sonosControl = new SonosControlClingImpl();
        Runtime.getRuntime().addShutdownHook(new Thread("shutdown-hook") {
            @Override
            public void run() {
                LOG.debug("Stopping Sonos Control...");
                sonosControl.shutdown();
            }
        });

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
            sonosControl.executeOnAllZones(new SonosDeviceCallback() {

                @Override
                public void success(SonosDevice device) {
                    try {
                        command.call(device, multipleDevicesCommandResultCallback);
                    } catch(Throwable t) {
                        multipleDevicesCommandResultCallback.fail(t);
                    }
                }
            });
            return null;
        }
        zoneSpec.invite(new ZoneSpecVisitor<Void>() {
            @Override
            public Void visitGroup(final GroupZoneSpec spec) {
                sonosControl.executeOnAllZones(new SonosDeviceCallback() {
                    Map<MemberID, SonosDevice> _devices = Maps.newHashMap();
                    SonosDevice _groupCoordinator;
                    Set<MemberID> _pendingMembers = Sets.newHashSet();

                    private void setGroupOwningDevice(SonosDevice device,
                            ZoneGroup ownedGroup) {
                        synchronized(this) {
                            _devices.put(device.getDeviceId(), device);
                            _groupCoordinator = device;
                            if (!_pendingMembers.isEmpty()) {
                                final Iterator<MemberID> members = _pendingMembers.iterator();
                                while (members.hasNext()) {
                                    MemberID next = members.next();
                                    members.remove();
                                    doAddToGroup(next);
                                }
                            }
                        }
                    }

                    private void addToGroup(SonosDevice device) {
                        synchronized(this) {
                            MemberID memberId = device.getDeviceId();
                            _devices.put(memberId, device);
                            if (_groupCoordinator != null) {
                                doAddToGroup(memberId);
                            } else {
                                _pendingMembers.add(memberId);
                            }
                        }
                    }

                    private void doAddToGroup(MemberID memberId) {
                        synchronized(this) {
                            System.out.println("Try to add group member: " + memberId );
                            final ZoneGroupTopologyService topologyService = _groupCoordinator.getZoneGroupTopologyService();
                            final  MemberID coordinatorDeviceID = _groupCoordinator.getDeviceId();
                            final ZoneGroup ownedGroup = topologyService.getLastValueForZoneGroupState().getOwnedGroup(coordinatorDeviceID);
                            final EventListener<ZoneGroupState> listener = new EventListener<ZoneGroupState>() {
                                @Override
                                public void valueChanged(
                                        ZoneGroupState oldValue,
                                        ZoneGroupState newValue) {
                                    System.out.println("Zone now contains: " + newValue.getOwnedGroup(coordinatorDeviceID).getMemberZoneNames());
                                    topologyService.removeZoneGroupStateListener(this);
                                }
                            };
                            topologyService.addZoneGroupStateListener(listener);
                            final Set<MemberID> currentMembers = ownedGroup.getMemberIds();
                            if (!currentMembers.contains(memberId)) {
                                SonosDevice sonosDevice = _devices.get(memberId);
                                sonosDevice.getAVTransportService().setAVTransportURI(AVTransportURI.playFromDevice(coordinatorDeviceID), null, new VoidCallback()).waitForSuccess();
                            }
                        }

                    }

                    @Override
                    public void success(SonosDevice device) {
                        LOG.debug("Found  Sonos device " + device.getZoneName().getValue() + " => "+ device.getZoneName());
                        if (spec.getGroupCoordinator().equals(device.getZoneName())) {
                            final ZoneGroupTopologyService topologyService = device.getZoneGroupTopologyService();

                            final ZoneGroup ownedGroup = topologyService.getLastValueForZoneGroupState().getOwnedGroup(device.getDeviceId());
                            if (ownedGroup != null) {
                                GroupID groupId = ownedGroup.getGroupId();
                                System.out.println("found owned group: " + groupId + " " + ownedGroup.getMemberZoneNames());
                                setGroupOwningDevice(device, ownedGroup);
                            } else {
                                throw new UnsupportedOperationException();
                            }
                            try {
                                command.call(device, multipleDevicesCommandResultCallback);
                            } catch(Throwable t) {
                                multipleDevicesCommandResultCallback.fail(t);
                            }
                        } else {
                            addToGroup(device);
                        }
                    }

                });
                return null;
            }
            @Override
            public Void visitSingleZone(final SingleZoneSpec spec) {
                sonosControl.executeOnZone(spec.getZoneName(), new SonosDeviceCallback() {

                    @Override
                    public void success(SonosDevice device) {
                        LOG.debug("Found  Sonos device " + device.getZoneName());
                        Preconditions.checkState(device.getZoneName().equals(spec.getZoneName()));
                        try {
                            command.call(device, singleDeviceCommandResultCallback);
                        } catch(Throwable t) {
                            singleDeviceCommandResultCallback.fail(t);
                        }
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