package org.core.platform.plugin;

import org.core.TranslateCore;
import org.core.config.ConfigurationFormat;
import org.core.config.ConfigurationStream;
import org.core.platform.plugin.details.PluginVersion;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Optional;

public interface Plugin {

    @NotNull String getPluginName();

    @NotNull String getPluginId();

    @NotNull PluginVersion getPluginVersion();

    default void onCoreInit() {
        //not implemented
    }

    default void onCoreReady() {
        //not implemented
    }

    @NotNull Object getPlatformLauncher();


    default @NotNull Optional<ConfigurationStream.ConfigurationFile> createConfig(String configName, File file) {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(configName);
        if (stream==null) {
            System.err.println("Request for '" + configName + "' could not be found");
            return Optional.empty();
        }
        try {
            file.getParentFile().mkdirs();
            Files.copy(stream, file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        return Optional.of(TranslateCore.createConfigurationFile(file, ConfigurationFormat.FORMAT_YAML));
    }

    default @NotNull File getConfigFolder() {
        return new File(TranslateCore.getPlatform().getTranslateConfigFolder(), this.getPluginId());
    }

    default @NotNull Optional<InputStream> getResource(String name) {
        return Optional.ofNullable(this.getClass().getClassLoader().getResourceAsStream(name));
    }
}
