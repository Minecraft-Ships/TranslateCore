package org.core.platform;

import org.core.CorePlugin;
import org.core.config.ConfigurationStream;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Stream;

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
