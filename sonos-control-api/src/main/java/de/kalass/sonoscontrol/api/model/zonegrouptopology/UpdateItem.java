package de.kalass.sonoscontrol.api.model.zonegrouptopology;

import java.io.Serializable;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;


public final class UpdateItem implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
 <UpdateItem xmlns="urn:schemas-rinconnetworks-com:update-1-0"
    Type="Software" Version="16.5-48010"
    UpdateURL="http://update.sonos.com/firmware/Gold/v3.6Tosh_QFE1_AudioPatch/^16.5-48010"
    DownloadSize="0" />
     */

    private final UpdateType _updateType;
    private final UpdateURL _updateUrl;
    private final Version _version;
    private final DownloadSize _downloadSize;

    private UpdateItem(UpdateType updateType, UpdateURL updateUrl, Version version, DownloadSize downloadSize) {
        _updateType = Preconditions.checkNotNull(updateType);
        _updateUrl = Preconditions.checkNotNull(updateUrl);
        _version = Preconditions.checkNotNull(version);
        _downloadSize = downloadSize;
    }

    public DownloadSize getDownloadSize() {
        return _downloadSize;
    }

    public UpdateType getUpdateType() {
        return _updateType;
    }

    public UpdateURL getUpdateUrl() {
        return _updateUrl;
    }

    public Version getVersion() {
        return _version;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("updateType", _updateType)
                .add("updateUrl", _updateUrl)
                .add("version", _version)
                .add("downloadSize", _downloadSize)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_updateType, _updateUrl, _version, _downloadSize);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof UpdateItem) {
            UpdateItem obj = (UpdateItem)other;
            return Objects.equal(_updateType, obj._updateType) &&
                    Objects.equal(_updateUrl, obj._updateUrl) &&
                    Objects.equal(_version, obj._version) &&
                    Objects.equal(_downloadSize, obj._downloadSize);
        }
        return false;
    }

    public static UpdateItem getInstance(UpdateType updateType, UpdateURL updateUrl, Version version, DownloadSize downloadSize) {
        return new UpdateItem(updateType, updateUrl, version, downloadSize);
    }
}
