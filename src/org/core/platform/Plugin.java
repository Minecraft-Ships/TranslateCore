package org.core.platform;

public interface Plugin {

    String getPluginName();
    String getPluginId();
    String getPluginVersion();
    Object getLauncher();

}
