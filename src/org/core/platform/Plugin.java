package org.core.platform;

import java.util.Optional;

public interface Plugin {

    String getPluginName();
    String getPluginId();
    String getPluginVersion();
    Optional<Object> getBukkitLauncher();
    Optional<Object> getSpongeLauncher();

}
