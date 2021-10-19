package org.core.platform;

import org.core.platform.plugin.details.CorePluginVersion;

public interface PlatformDetails {

    String BUKKIT_ID = "bukkit";
    String SPONGE_ID = "sponge";

    String getName();

    String getIdName();

    CorePluginVersion getVersion();
}
