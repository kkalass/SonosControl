package de.kalass.sonoscontrol.clingimpl.services;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getAttr;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getBooleanVal;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getChildNotNull;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getChildren;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getLongVal;
import static de.kalass.sonoscontrol.clingimpl.services.XMLUtil.getRoot;

import java.util.Map;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.Device;
import org.w3c.dom.Node;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.api.core.ErrorStrategy;
import de.kalass.sonoscontrol.api.model.InstanceID;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Bass;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Channel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.HeadphoneConnected;
import de.kalass.sonoscontrol.api.model.renderingcontrol.LastChange;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Loudness;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Mute;
import de.kalass.sonoscontrol.api.model.renderingcontrol.MuteChannel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.OutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.PresetNameList;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Treble;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Volume;

public final class RenderingControlServiceClingImpl extends
AbstractRenderingControlServiceClingImpl {
    public RenderingControlServiceClingImpl(UpnpService upnpService,
            @SuppressWarnings("rawtypes") Device device, ErrorStrategy errorStrategy) {
        super(upnpService, device, errorStrategy);
    }

    @Override
    protected LastChange convertLastChange(
            String rawValue) {

        /*
     <Event xmlns="urn:schemas-upnp-org:metadata-1-0/RCS/">
        <InstanceID val="0">
            <Volume channel="Master" val="75" />
            <Volume channel="LF" val="100" />
            <Volume channel="RF" val="100" />
            <Mute channel="Master" val="0" />
            <Mute channel="LF" val="0" />
            <Mute channel="RF" val="0" />
            <Bass val="0" />
            <Treble val="0" />
            <Loudness channel="Master" val="0" />
            <OutputFixed val="0" />
            <HeadphoneConnected val="0" />
            <PresetNameList>FactoryDefaults</PresetNameList>
        </InstanceID>
    </Event>
         */
        final Node instanceNode = getChildNotNull(getRoot(rawValue), "InstanceID");
        final XMLUtil.Children children = getChildren(instanceNode);
        final InstanceID instanceId = InstanceID.getInstance(getLongVal(instanceNode));
        final Map<Channel, Volume> volumes = ImmutableMap.copyOf(Maps.transformValues(Maps.uniqueIndex(children.get("Volume"), new Function<Node, Channel>() {
            @Override
            public Channel apply(Node input) {
                return Channel.getInstance(getAttr(input, "channel"));
            }
        }), new Function<Node, Volume>() {
            @Override
            public Volume apply(Node input) {
                return Volume.getInstance(getLongVal(input));
            }
        }));
        final Map<MuteChannel, Mute> mutes = ImmutableMap.copyOf(Maps.transformValues(Maps.uniqueIndex(children.get("Mute"), new Function<Node, MuteChannel>() {
            @Override
            public MuteChannel apply(Node input) {
                return MuteChannel.getInstance(getAttr(input, "channel"));
            }
        }), new Function<Node, Mute>() {
            @Override
            public Mute apply(Node input) {
                return Mute.getInstance(getBooleanVal(input));
            }
        }));
        final Map<Channel, Loudness> loudness = ImmutableMap.copyOf(Maps.transformValues(Maps.uniqueIndex(children.get("Loudness"), new Function<Node, Channel>() {
            @Override
            public Channel apply(Node input) {
                return Channel.getInstance(getAttr(input, "channel"));
            }
        }), new Function<Node, Loudness>() {
            @Override
            public Loudness apply(Node input) {
                return Loudness.getInstance(getBooleanVal(input));
            }
        }));
        final Bass bass = Bass.getInstance(getLongVal(children.getSingleItem("Bass")));
        final Treble treble = Treble.getInstance(getLongVal(children.getSingleItem("Treble")));
        final OutputFixed outputFixed = OutputFixed.getInstance(getBooleanVal(children.getSingleItem("OutputFixed")));
        final HeadphoneConnected headphoneConnected = HeadphoneConnected.getInstance(getBooleanVal(children.getSingleItem("HeadphoneConnected")));
        final Node singleItem = children.getSingleItem("PresetNameList");
        final PresetNameList presetNameList = PresetNameList.getInstance(singleItem == null ? null : singleItem.getTextContent());

        return new LastChange(
                instanceId, volumes, mutes,
                bass, treble, loudness.get(Channel.MASTER), outputFixed,
                headphoneConnected, presetNameList
                );
    }
}