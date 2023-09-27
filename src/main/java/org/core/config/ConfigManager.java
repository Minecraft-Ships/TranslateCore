package org.core.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Collection;

public interface ConfigManager {

    ConfigurationFormat getDefaultFormat();

    Collection<ConfigurationFormat> getSupportedFormats();

    ConfigurationStream.ConfigurationFile read(@NotNull File file, @Nullable ConfigurationFormat format);

    default ConfigurationStream.ConfigurationFile read(@NotNull File file) {
        return read(file, ConfigurationFormat
                .forFile(file.getName())
                .orElseThrow(() -> new IllegalArgumentException("Unknown file extension for " + file.getName())));
    }
}
