package org.core.platform.plugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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

/**
 * A plugin on the server
 */
public interface Plugin {

    /**
     * Gets the display name of the plugin
     *
     * @return The display name of the plugin
     */
    @NotNull String getPluginName();

    /**
     * Gets the plugin id.
     * The plugin id is what is used when the plugin namespace is used.
     * It must follow the following rules
     * <p>
     * - no uppercase
     * - no spaces
     * - no special characters
     *
     * @return The plugin id
     */
    @NotNull String getPluginId();

    /**
     * Gets the plugin version information
     *
     * @return The plugin version information
     */
    @NotNull PluginVersion getPluginVersion();

    /**
     * Runs when the boot order of every plugin has been found.
     * Note that this is typically on a async thread
     */
    default void onCoreInit() {
        //not implemented
    }

    /**
     * Runs when TranslateCore has setup its own environment.
     * This maybe before the server, however may also while the server finishes
     */
    default void onCoreReady() {
        //not implemented
    }

    /**
     * Runs when the server is in the "Done" state
     */
    default void onCoreFinishedInit() {
        //not implemented
    }

    /**
     * Gets the native boot plugin object. Depending on implementation, this maybe a wrapper or the TranslateCore
     * boot plugin object
     *
     * @return The native plugin
     */
    @NotNull Object getPlatformLauncher();

    /**
     * Copies a internal YAML file to the provided file object.
     *
     * @param configName the config name
     * @param file       The location to copy to
     * @return the ConfigurationFile for the copied file
     */
    default @NotNull Optional<ConfigurationStream.ConfigurationFile> createConfig(@NotNull String configName,
                                                                                  @NotNull File file) {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(configName);
        if (stream == null) {
            TranslateCore
                    .getConsole()
                    .sendMessage(Component
                                         .text("Request for '" + configName + "' could not be found")
                                         .color(NamedTextColor.RED));
            return Optional.empty();
        }
        try {
            //noinspection ResultOfMethodCallIgnored
            file.getParentFile().mkdirs();
            Files.copy(stream, file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        return Optional.of(TranslateCore.getConfigManager().read(file, ConfigurationFormat.FORMAT_YAML));
    }

    /**
     * Gets the folder for this plugins configs
     *
     * @return The folder for configs
     */
    default @NotNull File getConfigFolder() {
        return new File(TranslateCore.getPlatform().getTranslateConfigFolder(), this.getPluginId());
    }

    /**
     * Gets a internal file
     *
     * @param name The name of the file
     * @return A InputStream if found {@link Optional#empty()} if not
     */
    default @NotNull Optional<InputStream> getResource(String name) {
        return Optional.ofNullable(this.getClass().getClassLoader().getResourceAsStream(name));
    }
}
