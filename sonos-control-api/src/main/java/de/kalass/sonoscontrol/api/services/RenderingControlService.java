package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Bass;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Channel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ChannelMap;
import de.kalass.sonoscontrol.api.model.renderingcontrol.EQType;
import de.kalass.sonoscontrol.api.model.renderingcontrol.EQValue;
import de.kalass.sonoscontrol.api.model.renderingcontrol.HeadphoneConnected;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Loudness;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Mute;
import de.kalass.sonoscontrol.api.model.renderingcontrol.MuteChannel;
import de.kalass.sonoscontrol.api.model.renderingcontrol.OutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ProgramURI;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RampTimeSeconds;
import de.kalass.sonoscontrol.api.model.renderingcontrol.RampType;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ResetBasicEQResult;
import de.kalass.sonoscontrol.api.model.renderingcontrol.ResetVolumeAfter;
import de.kalass.sonoscontrol.api.model.renderingcontrol.SupportsOutputFixed;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Treble;
import de.kalass.sonoscontrol.api.model.renderingcontrol.Volume;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeAdjustment;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeDB;
import de.kalass.sonoscontrol.api.model.renderingcontrol.VolumeDBRange;

public interface RenderingControlService {

    public <C extends Callback1<Mute>> C getMute(MuteChannel channel, C callback);

    public <C extends Callback0> C setMute(MuteChannel channel, Mute desiredMute, C callback);

    public <C extends Callback1<ResetBasicEQResult>> C resetBasicEQ(C callback);

    public <C extends Callback0> C resetExtEQ(EQType eQType, C callback);

    public <C extends Callback1<Volume>> C getVolume(Channel channel, C callback);

    public <C extends Callback0> C setVolume(Channel channel, Volume desiredVolume, C callback);

    public <C extends Callback1<Volume>> C setRelativeVolume(Channel channel, VolumeAdjustment adjustment, C callback);

    public <C extends Callback1<VolumeDB>> C getVolumeDB(Channel channel, C callback);

    public <C extends Callback0> C setVolumeDB(Channel channel, VolumeDB desiredVolume, C callback);

    public <C extends Callback1<VolumeDBRange>> C getVolumeDBRange(Channel channel, C callback);

    public <C extends Callback1<Bass>> C getBass(C callback);

    public <C extends Callback0> C setBass(Bass desiredBass, C callback);

    public <C extends Callback1<Treble>> C getTreble(C callback);

    public <C extends Callback0> C setTreble(Treble desiredTreble, C callback);

    public <C extends Callback1<EQValue>> C getEQ(EQType eQType, C callback);

    public <C extends Callback0> C setEQ(EQType eQType, EQValue desiredValue, C callback);

    public <C extends Callback1<Loudness>> C getLoudness(Channel channel, C callback);

    public <C extends Callback0> C setLoudness(Channel channel, Loudness desiredLoudness, C callback);

    public <C extends Callback1<SupportsOutputFixed>> C getSupportsOutputFixed(C callback);

    public <C extends Callback1<OutputFixed>> C getOutputFixed(C callback);

    public <C extends Callback0> C setOutputFixed(OutputFixed desiredFixed, C callback);

    public <C extends Callback1<HeadphoneConnected>> C getHeadphoneConnected(C callback);

    public <C extends Callback1<RampTimeSeconds>> C rampToVolume(Channel channel, RampType rampType, Volume desiredVolume, ResetVolumeAfter resetVolumeAfter, ProgramURI programURI, C callback);

    public <C extends Callback0> C restoreVolumePriorToRamp(Channel channel, C callback);

    public <C extends Callback0> C setChannelMap(ChannelMap channelMap, C callback);
}
