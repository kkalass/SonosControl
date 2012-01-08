/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.eventmodels.avtransport;

import java.io.Serializable;

import com.google.common.base.Objects;

import de.kalass.sonoscontrol.api.model.InstanceID;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentCrossfadeMode;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentPlayMode;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentSection;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTrack;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTrackDuration;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTrackMetaData;
import de.kalass.sonoscontrol.api.model.avtransport.CurrentTrackURI;
import de.kalass.sonoscontrol.api.model.avtransport.NumberOfTracks;
import de.kalass.sonoscontrol.api.model.avtransport.TransportState;

public final class LastAVTransportChange implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
 <Event xmlns="urn:schemas-upnp-org:metadata-1-0/AVT/" xmlns:r="urn:schemas-rinconnetworks-com:metadata-1-0/">
    <InstanceID val="0">
        <TransportState val="PLAYING" />
        <CurrentPlayMode val="NORMAL" />
        <CurrentCrossfadeMode val="0" />
        <NumberOfTracks val="8" />
        <CurrentTrack val="4" />
        <CurrentSection val="0" />
        <CurrentTrackURI
            val="lfmtrack:http%3a%2f%2fx7.last.fm%2fuser%2f19525822%2f3d5effb15115f662d23b00755d076c04%2f10028%2f0071794748%2f1200d37eb3ed1596e0826b37b352f3c8%2f1325863958%2f11%2f840389155%2f49f9477923cc3ab8ed90029f6e7e1d9f%2f1%2f0%2f128.mp3?a=http%3a%2f%2fuserserve-ak.last.fm%2fserve%2f174s%2f50324675.png&amp;r=bff24" />
        <CurrentTrackDuration val="0:03:00" />
        <CurrentTrackMetaData
            val="&lt;DIDL-Lite xmlns:dc=&quot;http://purl.org/dc/elements/1.1/&quot; xmlns:upnp=&quot;urn:schemas-upnp-org:metadata-1-0/upnp/&quot; xmlns:r=&quot;urn:schemas-rinconnetworks-com:metadata-1-0/&quot; xmlns=&quot;urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/&quot;&gt;&lt;item id=&quot;-1&quot; parentID=&quot;-1&quot; restricted=&quot;true&quot;&gt;&lt;res protocolInfo=&quot;last.fm-radio-http:*:audio/mpeg:*&quot; duration=&quot;0:03:00&quot;&gt;lfmtrack:http%3a%2f%2fx7.last.fm%2fuser%2f19525822%2f3d5effb15115f662d23b00755d076c04%2f10028%2f0071794748%2f1200d37eb3ed1596e0826b37b352f3c8%2f1325863958%2f11%2f840389155%2f49f9477923cc3ab8ed90029f6e7e1d9f%2f1%2f0%2f128.mp3?a=http%3a%2f%2fuserserve-ak.last.fm%2fserve%2f174s%2f50324675.png&amp;amp;r=bff24&lt;/res&gt;&lt;r:streamContent&gt;&lt;/r:streamContent&gt;&lt;r:radioShowMd&gt;&lt;/r:radioShowMd&gt;&lt;upnp:albumArtURI&gt;http://userserve-ak.last.fm/serve/174s/50324675.png&lt;/upnp:albumArtURI&gt;&lt;dc:title&gt;Hurt&lt;/dc:title&gt;&lt;upnp:class&gt;object.item.audioItem.musicTrack&lt;/upnp:class&gt;&lt;dc:creator&gt;Parov Stelar&lt;/dc:creator&gt;&lt;upnp:album&gt;Coco Part 1&lt;/upnp:album&gt;&lt;/item&gt;&lt;/DIDL-Lite&gt;" />
        <r:NextTrackURI
            val="lfmtrack:http%3a%2f%2fplay.last.fm%2fuser%2f329a145c36b6cee04f971ac8c15d24b8.mp3?a=http%3a%2f%2fuserserve-ak.last.fm%2fserve%2f174s%2f71277966.png&amp;r=cf828&amp;p=000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" />
        <r:NextTrackMetaData
            val="&lt;DIDL-Lite xmlns:dc=&quot;http://purl.org/dc/elements/1.1/&quot; xmlns:upnp=&quot;urn:schemas-upnp-org:metadata-1-0/upnp/&quot; xmlns:r=&quot;urn:schemas-rinconnetworks-com:metadata-1-0/&quot; xmlns=&quot;urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/&quot;&gt;&lt;item id=&quot;-1&quot; parentID=&quot;-1&quot; restricted=&quot;true&quot;&gt;&lt;res protocolInfo=&quot;last.fm-radio-http:*:audio/mpeg:*&quot; duration=&quot;0:14:01&quot;&gt;lfmtrack:http%3a%2f%2fplay.last.fm%2fuser%2f329a145c36b6cee04f971ac8c15d24b8.mp3?a=http%3a%2f%2fuserserve-ak.last.fm%2fserve%2f174s%2f71277966.png&amp;amp;r=cf828&amp;amp;p=000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000&lt;/res&gt;&lt;upnp:albumArtURI&gt;http://userserve-ak.last.fm/serve/174s/71277966.png&lt;/upnp:albumArtURI&gt;&lt;dc:title&gt;Miles Runs The Voodoo Down&lt;/dc:title&gt;&lt;upnp:class&gt;object.item.audioItem.musicTrack&lt;/upnp:class&gt;&lt;dc:creator&gt;Miles Davis&lt;/dc:creator&gt;&lt;upnp:album&gt;Bitches Brew&lt;/upnp:album&gt;&lt;/item&gt;&lt;/DIDL-Lite&gt;" />
        <r:EnqueuedTransportURI val="lastfm://globaltags/jazz" />
        <r:EnqueuedTransportURIMetaData
            val="&lt;DIDL-Lite xmlns:dc=&quot;http://purl.org/dc/elements/1.1/&quot; xmlns:upnp=&quot;urn:schemas-upnp-org:metadata-1-0/upnp/&quot; xmlns:r=&quot;urn:schemas-rinconnetworks-com:metadata-1-0/&quot; xmlns=&quot;urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/&quot;&gt;&lt;item id=&quot;RP:SA_RINCON11_kkalass:2:LFM%3aTAG%3ajazz&quot; parentID=&quot;RECENT&quot; restricted=&quot;true&quot;&gt;&lt;dc:title&gt;jazz Tag-Radio&lt;/dc:title&gt;&lt;upnp:class&gt;object.item.audioItem.audioBroadcast&lt;/upnp:class&gt;&lt;desc id=&quot;cdudn&quot; nameSpace=&quot;urn:schemas-rinconnetworks-com:metadata-1-0/&quot;&gt;SA_RINCON11_kkalass&lt;/desc&gt;&lt;/item&gt;&lt;/DIDL-Lite&gt;" />
    </InstanceID>
</Event>
     */

    private final InstanceID _instanceId;
    private final TransportState _transportState;
    private final CurrentPlayMode _currentPlayMode;
    private final CurrentCrossfadeMode _currentCrossfadeMode;
    private final NumberOfTracks _numberOfTracks;
    private final CurrentTrack _currentTrack;
    private final CurrentSection _currentSection;
    private final CurrentTrackURI _currentTrackUri;
    private final CurrentTrackDuration _currentTrackDuration;
    private final CurrentTrackMetaData _currentTrackMetaData;

    public LastAVTransportChange(
            InstanceID instanceId, TransportState transportState,
            CurrentPlayMode currentPlayMode,
            CurrentCrossfadeMode currentCrossfadeMode,
            NumberOfTracks numberOfTracks, CurrentTrack currentTrack,
            CurrentSection currentSection, CurrentTrackURI currentTrackUri,
            CurrentTrackDuration currentTrackDuration,
            CurrentTrackMetaData currentTrackMetaData) {
        super();
        _instanceId = instanceId;
        _transportState = transportState;
        _currentPlayMode = currentPlayMode;
        _currentCrossfadeMode = currentCrossfadeMode;
        _numberOfTracks = numberOfTracks;
        _currentTrack = currentTrack;
        _currentSection = currentSection;
        _currentTrackUri = currentTrackUri;
        _currentTrackDuration = currentTrackDuration;
        _currentTrackMetaData = currentTrackMetaData;
    }


    public InstanceID getInstanceId() {
        return _instanceId;
    }

    public TransportState getTransportState() {
        return _transportState;
    }

    public CurrentPlayMode getCurrentPlayMode() {
        return _currentPlayMode;
    }

    public CurrentCrossfadeMode getCurrentCrossfadeMode() {
        return _currentCrossfadeMode;
    }

    public NumberOfTracks getNumberOfTracks() {
        return _numberOfTracks;
    }

    public CurrentTrack getCurrentTrack() {
        return _currentTrack;
    }

    public CurrentSection getCurrentSection() {
        return _currentSection;
    }

    public CurrentTrackURI getCurrentTrackUri() {
        return _currentTrackUri;
    }

    public CurrentTrackDuration getCurrentTrackDuration() {
        return _currentTrackDuration;
    }

    public CurrentTrackMetaData getCurrentTrackMetaData() {
        return _currentTrackMetaData;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("currentCrossfadeMode", _currentCrossfadeMode)
                .add("currentPlayMode", _currentPlayMode)
                .add("currentSection", _currentSection)
                .add("currentTrack", _currentTrack)
                .add("currentTrackDuration", _currentTrackDuration)
                .add("currentTrackMetaData", _currentTrackMetaData)
                .add("currentTrackUri", _currentTrackUri)
                .add("instanceId", _instanceId)
                .add("numberOfTracks", _numberOfTracks)
                .add("transportState", _transportState)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                _currentCrossfadeMode, _currentPlayMode, _currentSection,
                _currentTrack, _currentTrackDuration, _currentTrackMetaData,
                _currentTrackUri, _instanceId, _numberOfTracks, _transportState);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof LastAVTransportChange) {
            LastAVTransportChange obj = (LastAVTransportChange)other;
            return Objects.equal(_currentCrossfadeMode, obj._currentCrossfadeMode) &&
                    Objects.equal(_currentPlayMode, obj._currentPlayMode) &&
                    Objects.equal(_currentSection, obj._currentSection) &&
                    Objects.equal(_currentTrack, obj._currentTrack) &&
                    Objects.equal(_currentTrackDuration, obj._currentTrackDuration) &&
                    Objects.equal(_currentTrackMetaData, obj._currentTrackMetaData) &&
                    Objects.equal(_currentTrackUri, obj._currentTrackUri) &&
                    Objects.equal(_instanceId, obj._instanceId) &&
                    Objects.equal(_numberOfTracks, obj._numberOfTracks) &&
                    Objects.equal(_transportState, obj._transportState) ;
        }
        return false;
    }

    public static LastAVTransportChange getInstance(
            InstanceID instanceId, TransportState transportState,
            CurrentPlayMode currentPlayMode,
            CurrentCrossfadeMode currentCrossfadeMode,
            NumberOfTracks numberOfTracks, CurrentTrack currentTrack,
            CurrentSection currentSection, CurrentTrackURI currentTrackUri,
            CurrentTrackDuration currentTrackDuration,
            CurrentTrackMetaData currentTrackMetaData
            ) {
        return new LastAVTransportChange(
                instanceId, transportState, currentPlayMode,
                currentCrossfadeMode, numberOfTracks, currentTrack,
                currentSection, currentTrackUri, currentTrackDuration, currentTrackMetaData);
    }
}
