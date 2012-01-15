package de.kalass.sonoscontrol.clingimpl.services;

import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getAttr;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getChildren;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getLongAttr;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getRoot;

import java.net.URI;
import java.util.List;

import org.fourthline.cling.UpnpService;
import org.fourthline.cling.model.meta.Device;
import org.w3c.dom.Node;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.MemberID;
import de.kalass.sonoscontrol.api.model.avtransport.GroupID;
import de.kalass.sonoscontrol.api.model.deviceproperties.Icon;
import de.kalass.sonoscontrol.api.model.deviceproperties.SoftwareVersion;
import de.kalass.sonoscontrol.api.model.deviceproperties.ZoneName;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.AvailableSoftwareUpdate;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.BootSeq;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.DownloadSize;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.Password;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ThirdPartyMediaServers;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ThirdPartyMediaServers.AccountData;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateItem;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateType;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.UpdateURL;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.Username;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.Version;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroup;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroupMember;
import de.kalass.sonoscontrol.api.model.zonegrouptopology.ZoneGroupState;


public final class ZoneGroupTopologyServiceClingImpl extends
AbstractZoneGroupTopologyServiceClingImpl {
    public ZoneGroupTopologyServiceClingImpl(UpnpService upnpService,
            @SuppressWarnings("rawtypes") Device device, ErrorStrategy errorStrategy) {
        super(upnpService, device, errorStrategy);
    }

    @Override
    protected ZoneGroupState convertZoneGroupState(String rawValue) {
        /*
        <ZoneGroups>
           <ZoneGroup Coordinator="RINCON_000E58354D7A01400" ID="RINCON_000E58354D7A01400:45">
               <ZoneGroupMember UUID="RINCON_000E58354D7A01400"
                   Location="http://192.168.0.161:1400/xml/device_description.xml"
                   ZoneName="Wohnzimmer" Icon="x-rincon-roomicon:living"
                   SoftwareVersion="16.5-48010a" MinCompatibleVersion="15.0-00000"
                   BootSeq="238" />
           </ZoneGroup>
           <ZoneGroup Coordinator="RINCON_000E5827600401400" ID="RINCON_000E5827600401400:52">
               <ZoneGroupMember UUID="RINCON_000E5827600401400"
                   Location="http://192.168.0.100:1400/xml/device_description.xml"
                   ZoneName="Esszimmer" Icon="x-rincon-roomicon:dining"
                   SoftwareVersion="16.5-48010a" MinCompatibleVersion="15.0-00000"
                   BootSeq="200" />
           </ZoneGroup>
       </ZoneGroups>
         */
        final Node root = getRoot(rawValue);
        XMLUtil.Children children = getChildren(root);
        final List<ZoneGroup> zoneGroups = ImmutableList.copyOf(
                Iterables.transform(children.get("ZoneGroup"), new Function<Node, ZoneGroup>() {
                    @Override
                    public ZoneGroup apply(Node zoneGroupNode) {
                        final MemberID coordinator = MemberID.getInstance(getAttr(zoneGroupNode, "Coordinator"));
                        final GroupID id = GroupID.getInstance(getAttr(zoneGroupNode, "ID"));
                        XMLUtil.Children zoneGroupNodeChildren = getChildren(zoneGroupNode);
                        final List<ZoneGroupMember> members = ImmutableList.copyOf(Iterables.transform(zoneGroupNodeChildren.get("ZoneGroupMember"), new Function<Node, ZoneGroupMember>() {
                            @Override
                            public ZoneGroupMember apply(Node zoneGroupMemberNode) {
                                final MemberID uuid = MemberID.getInstance(getAttr(zoneGroupMemberNode, "UUID"));
                                URI location = URI.create(getAttr(zoneGroupMemberNode, "Location"));
                                ZoneName zoneName = ZoneName.getInstance(getAttr(zoneGroupMemberNode, "ZoneName"));
                                Icon icon = Icon.getInstance(getAttr(zoneGroupMemberNode, "Icon"));
                                SoftwareVersion softwareVersion = SoftwareVersion.getInstance(getAttr(zoneGroupMemberNode, "SoftwareVersion"));
                                SoftwareVersion minCompatibleVersion = SoftwareVersion.getInstance(getAttr(zoneGroupMemberNode, "MinCompatibleVersion"));
                                BootSeq bootSeq = BootSeq.getInstance(getLongAttr(zoneGroupMemberNode, "BootSeq"));
                                return ZoneGroupMember.getInstance(uuid, location, zoneName, icon, softwareVersion, minCompatibleVersion, bootSeq);
                            }
                        }));

                        return ZoneGroup.getInstance(coordinator, id, members);
                    }
                }));
        return ZoneGroupState.getInstance(zoneGroups);
    }

    @Override
    protected UpdateItem convertUpdateItem(String rawValue) {
        /*
        <UpdateItem xmlns="urn:schemas-rinconnetworks-com:update-1-0"
           Type="Software" Version="16.5-48010"
           UpdateURL="http://update.sonos.com/firmware/Gold/v3.6Tosh_QFE1_AudioPatch/^16.5-48010"
           DownloadSize="0" />
         */
        if (Strings.isNullOrEmpty(rawValue)) {
            return null;
        }
        final Node updateItem = getRoot(rawValue);
        final UpdateType updateType = UpdateType.getInstance(getAttr(updateItem, "Type"));
        final UpdateURL updateUrl = UpdateURL.getInstance(getAttr(updateItem, "UpdateURL"));
        final Version version = Version.getInstance(getAttr(updateItem, "Version"));
        final DownloadSize downloadSize = DownloadSize.getInstance(getLongAttr(updateItem, "DownloadSize"));
        return UpdateItem.getInstance(updateType, updateUrl, version, downloadSize);
    }

    @Override
    protected ThirdPartyMediaServers convertThirdPartyMediaServers(
            String rawValue) {
        /*
         * <MediaServers>
        <Service UDN="SA_RINCON11_<username>" Md="1" Password="<pwd>"
            NumAccounts="1" Username0="<username>" Md0="1" Password0="<pwd>" />
        <Service UDN="SA_RINCON519_<username>" Md="" Password="<pwd>"
            NumAccounts="1" Username0="<username>" Md0="" Password0="<pwd>" />
        <Service UDN="SA_RINCON2055_<username>" Md="" Password="<pwd>"
            NumAccounts="1" Username0="<username>" Md0="" Password0="<pwd>" />
    </MediaServers>
         */
        final Node root = getRoot(rawValue);
        XMLUtil.Children children = getChildren(root);
        final List<ThirdPartyMediaServers.AccountData> accountData = ImmutableList.copyOf(
                Iterables.transform(children.get("Service"), new Function<Node, ThirdPartyMediaServers.AccountData>() {
                    @Override
                    public AccountData apply(Node input) {
                        final String udn = getAttr(input, "UDN");
                        final String md = getAttr(input, "Md");
                        final int numAccounts = getLongAttr(input, "NumAccounts").intValue();
                        final Username username = Username.getInstance(getAttr(input, "Username0"));
                        final Password password = Password.getInstance(getAttr(input, "Password"));
                        final String md0 = getAttr(input, "Md0");
                        final Password password0 = Password.getInstance(getAttr(input, "Password0"));
                        return new AccountData(udn, md, numAccounts, username, password, md0, password0);
                    }
                }));
        return ThirdPartyMediaServers.getInstance(accountData);
    }

    @Override
    protected AvailableSoftwareUpdate convertAvailableSoftwareUpdate(
            String rawValue) {
        /*
        <UpdateItem xmlns="urn:schemas-rinconnetworks-com:update-1-0"
           Type="Software" Version="16.5-48010"
           UpdateURL="http://update.sonos.com/firmware/Gold/v3.6Tosh_QFE1_AudioPatch/^16.5-48010"
           DownloadSize="0" />
         */
        return AvailableSoftwareUpdate.getInstance(convertUpdateItem(rawValue));
    }
}