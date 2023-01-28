package org.core.platform;

import org.core.platform.plugin.details.CorePluginVersion;
import org.jetbrains.annotations.NotNull;

public class TranslateCorePlatformDetails implements PlatformDetails {

    @Override
    public @NotNull String getName() {
        return "Translate Core";
    }

    @Override
    public @NotNull String getIdName() {
        return "translatecore";
    }

    @Override
    public @NotNull CorePluginVersion getVersion() {
        return new CorePluginVersion(1, 0, 0);
    }
}
