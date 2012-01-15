package de.kalass.sonoscontrol.cli.arguments;

import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;

public class GroupZoneSpec extends ZoneSpec {

    @Nonnull
    private final ZoneName _groupCoordinator;

    @Nonnull
    private final Set<ZoneName> _groupMembers;

    private GroupZoneSpec(@Nonnull ZoneName groupCoordinator, @Nonnull Set<ZoneName> groupMembers) {
        super();
        _groupCoordinator = Preconditions.checkNotNull(groupCoordinator);
        _groupMembers = Preconditions.checkNotNull(ImmutableSet.copyOf(groupMembers));
        Preconditions.checkArgument(!groupMembers.contains(groupCoordinator));
    }

    public static final ZoneSpec ofGroup(ZoneName primaryZone, Set<ZoneName> additionalZones) {
        return new GroupZoneSpec(primaryZone, additionalZones);
    }

    @Nonnull
    public ZoneName getGroupCoordinator() {
        return _groupCoordinator;
    }

    @Nonnull
    public Iterable<ZoneName> getGroupMembers() {
        return _groupMembers;
    }

    @Override
    public <T> T invite(@Nonnull ZoneSpecVisitor<T> visitor) {
        return visitor.visitGroup(this);
    }

    public boolean isGroupMember(ZoneName zoneName) {
        //return _groupMembers.contains(zoneName);
        // FIXME (KK): implement wildcard vs. specified zone names
        boolean contains = _groupMembers.contains(zoneName);
        if (!contains) {
            System.out.println("Disregarded candidate zone " + zoneName + " as member of " + _groupCoordinator);
        }
        return contains;
    }
}
