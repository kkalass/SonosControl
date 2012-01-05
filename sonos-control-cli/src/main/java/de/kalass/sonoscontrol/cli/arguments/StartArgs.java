package de.kalass.sonoscontrol.cli.arguments;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StartArgs extends ZoneCommandArgs {
    public static final String CMD = "start";
    @CheckForNull private final String _trackUri;

    public StartArgs(@Nonnull ZoneSpec zoneSpec, @Nullable String trackUri) {
        super(zoneSpec);
        _trackUri = trackUri;
    }

    @CheckForNull
    public String getTrackUri() {
        return _trackUri;
    }

    @Override
    public <T> T invite(ArgumentsVisitor<T> visitor) {
        return visitor.visitStart(this);
    }
}
