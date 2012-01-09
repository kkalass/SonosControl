package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.avtransport.GroupID;

public class ZoneGroup {
    public static Function<ZoneGroup, MemberID> GET_COORDINATOR = new Function<ZoneGroup, MemberID>() {
        @Override
        public MemberID apply(ZoneGroup input) {
            return input.getCoordinator();
        }
    };
    public static Function<ZoneGroup, GroupID> GET_GROUP_ID = new Function<ZoneGroup, GroupID>() {
        @Override
        public GroupID apply(ZoneGroup input) {
            return input.getGroupId();
        }
    };
    public static Function<ZoneGroup, List<ZoneGroupMember>> GET_MEMBERS = new Function<ZoneGroup, List<ZoneGroupMember>>() {
        @Override
        public List<ZoneGroupMember> apply(ZoneGroup input) {
            return input.getMembers();
        }
    };

    private final MemberID _coordinator;
    private final GroupID _groupId;
    private final List<ZoneGroupMember> _members;

    private ZoneGroup(MemberID coordinator, GroupID groupId,
            List<ZoneGroupMember> members) {
        super();
        _coordinator = coordinator;
        _groupId = groupId;
        _members = members;
    }

    public MemberID getCoordinator() {
        return _coordinator;
    }

    public GroupID getGroupId() {
        return _groupId;
    }

    public List<ZoneGroupMember> getMembers() {
        return _members;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("coordinator", _coordinator)
                .add("groupId", _groupId)
                .add("members", _members)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_coordinator, _groupId, _members);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ZoneGroup) {
            final ZoneGroup obj = (ZoneGroup)other;
            return Objects.equal(_coordinator, obj._coordinator) &&
                    Objects.equal(_groupId, obj._groupId) &&
                    Objects.equal(_members, obj._members);
        }
        return false;
    }

    public static ZoneGroup getInstance(
            MemberID coordinator, GroupID groupId,
            List<ZoneGroupMember> members
            ) {
        return new ZoneGroup(coordinator, groupId, members);
    }
}
