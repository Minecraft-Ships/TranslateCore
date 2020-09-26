package org.core.platform;

import org.core.config.ConfigurationStream;

import java.io.File;
import java.io.InputStream;
import java.util.Optional;

public interface Plugin {

    String getPluginName();
    String getPluginId();
    String getPluginVersion();
    Object getLauncher();
    Optional<ConfigurationStream.ConfigurationFile> createConfig(String configName, File file);

    default Optional<InputStream> getResource(String name){
        return Optional.ofNullable(this.getClass().getClassLoader().getResourceAsStream(name));
    }
}
