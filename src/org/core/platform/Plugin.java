package org.core.platform;

import java.util.Optional;

public interface Plugin {

    String getPluginName();
    String getPluginVersion();
    Optional<String> checkForUpdates();

    public Object getBukkitLauncher();

    public Object getSpongeLauncher();

}
