package org.core.platform;

import org.core.CorePlugin;
import org.core.configuration.ConfigurationFile;
import org.core.configuration.type.ConfigurationLoaderType;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Stream;

public interface Plugin {

    String getPluginName();
    String getPluginId();
    String getPluginVersion();
    Object getLauncher();

    default Optional<InputStream> getResource(String name){
        return Optional.ofNullable(this.getClass().getClassLoader().getResourceAsStream(name));
    }

    default Optional<ConfigurationFile> createConfig(String configName, File file){
        Optional<InputStream> opStream = this.getResource(configName);
        if(!opStream.isPresent()){
            return Optional.empty();
        }
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }
        String[] split = file.getName().split(".");
        String fileType = split[split.length - 1];

        try {
            Files.copy(opStream.get(), file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        Optional<ConfigurationLoaderType> opType = CorePlugin.getPlatform().getConfigurationLoaderTypes().stream().filter(c -> Stream.of(c.acceptedFileExtensions()).anyMatch(e -> e.equalsIgnoreCase(fileType))).findAny();
        if(!opType.isPresent()){
            return Optional.empty();
        }
        return Optional.of(CorePlugin.createConfigurationFile(file, opType.get()));
    }

}
