/**
 * AUTOMATICALLY GENERATED - DO NOT MODIFY
 */
package de.kalass.sonoscontrol.api.model.renderingcontrol;

import com.google.common.base.Objects;
import java.io.Serializable;


public final class ResetBasicEQResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Bass _bass;
    private final Treble _treble;
    private final Loudness _loudness;
    private final LeftVolume _leftVolume;
    private final RightVolume _rightVolume;

    public ResetBasicEQResult(
        final Bass bass,
        final Treble treble,
        final Loudness loudness,
        final LeftVolume leftVolume,
        final RightVolume rightVolume
    ) {
        _bass = bass;
        _treble = treble;
        _loudness = loudness;
        _leftVolume = leftVolume;
        _rightVolume = rightVolume;
    } 

    public Bass getBass() {
        return _bass;
    }
    public Treble getTreble() {
        return _treble;
    }
    public Loudness getLoudness() {
        return _loudness;
    }
    public LeftVolume getLeftVolume() {
        return _leftVolume;
    }
    public RightVolume getRightVolume() {
        return _rightVolume;
    }

    public String toString() {
        return Objects.toStringHelper(this)
        .add("bass", _bass)
        .add("treble", _treble)
        .add("loudness", _loudness)
        .add("leftVolume", _leftVolume)
        .add("rightVolume", _rightVolume)
        .toString();
    }

    public int hashCode() {
        return Objects.hashCode(
            _bass,
            _treble,
            _loudness,
            _leftVolume,
            _rightVolume
        );
    }

    public boolean equals(Object other) {
        if (other instanceof ResetBasicEQResult) {
            ResetBasicEQResult obj = (ResetBasicEQResult)other;
            return 
                    Objects.equal(_bass, obj._bass) &&
                    Objects.equal(_treble, obj._treble) &&
                    Objects.equal(_loudness, obj._loudness) &&
                    Objects.equal(_leftVolume, obj._leftVolume) &&
                    Objects.equal(_rightVolume, obj._rightVolume) 
            ;
        }
        return false;
    }

}
