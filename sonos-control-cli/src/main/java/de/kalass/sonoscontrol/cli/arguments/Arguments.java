package de.kalass.sonoscontrol.cli.arguments;

import com.google.common.collect.ImmutableSet;

import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

/**
 * A Command that can be specified on the command line.
 * @author klas
 */
public abstract class Arguments {

    public abstract <T> T invite(ArgumentsVisitor<T> visitor);

    private static final ZoneSpec getZoneSpec(String[] args) {
        if (args.length < 2) {
            return null;
        }
        final String spec = args[1];
        if (spec.startsWith("group:")) {
            final String groupMembersString=spec.substring("group:".length());
            final String[] groupMembers = groupMembersString.split(" *, *");
            if (groupMembers.length < 2) {
                throw new IllegalArgumentException("Too few parameters for zone group spec. Example: 'group:Esszimmer,Wohnzimmer'");
            }
            final ZoneName coordinator = ZoneName.getInstance(groupMembers[0]);
            final ImmutableSet.Builder<ZoneName> otherMembers = ImmutableSet.builder();
            for (int i = 1 ; i <  groupMembers.length; i++) {
                final ZoneName name = ZoneName.getInstance(groupMembers[i]);
                if (!coordinator.equals(name)) {
                    otherMembers.add(name);
                }
            }
            return GroupZoneSpec.ofGroup(coordinator, otherMembers.build());
        } else {
            return SingleZoneSpec.ofZone(ZoneName.getInstance(spec));
        }
    }

    public static final Arguments parse(String[] args) {
        if (args.length == 0) {
            return new HelpArgs();
        }
        final String cmd = args[0];
        final ZoneSpec zoneSpec = getZoneSpec(args);
        if (zoneSpec == null || HelpArgs.CMD.equals(cmd)) {
            return new HelpArgs();
        }
        if (ShowArgs.CMD.equals(cmd)) {
            return new ShowArgs(zoneSpec);
        }
        if (StartArgs.CMD.equals(cmd)) {
            final String trackUri = args.length < 3 ? null : args[2];
            return new StartArgs(zoneSpec, trackUri);
        }
        if (StopArgs.CMD.equals(cmd)) {
            return new StopArgs(zoneSpec);
        }
        if (MuteArgs.CMD.equals(cmd)) {
            if (args.length < 3) {
                return new HelpArgs();
            }
            final String onOff = args[2];
            return new MuteArgs(zoneSpec, "on".equalsIgnoreCase(onOff));
        }
        return new HelpArgs();
    }
}
