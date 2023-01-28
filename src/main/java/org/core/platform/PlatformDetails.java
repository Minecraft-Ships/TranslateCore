package org.core.platform;

import org.core.platform.plugin.details.CorePluginVersion;
import org.jetbrains.annotations.NotNull;

public interface PlatformDetails {

    String BUKKIT_ID = "bukkit";
    String SPONGE_ID = "sponge";

    @NotNull String getName();

    @NotNull String getIdName();

    @NotNull CorePluginVersion getVersion();
}
