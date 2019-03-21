package org.core.platform;

public interface Plugin {

    String getPluginName();
    String getPluginVersion();

    public Object getBukkitLauncher();

    public Object getSpongeLauncher();

}
