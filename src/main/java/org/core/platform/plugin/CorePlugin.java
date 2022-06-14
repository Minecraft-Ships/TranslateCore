package org.core.platform.plugin;

import org.core.command.CommandRegister;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.platform.plugin.details.LoadOnlyOn;
import org.core.platform.plugin.details.LoadOnlyOnPlatform;
import org.core.platform.plugin.details.depends.LoadType;
import org.jetbrains.annotations.NotNull;

/**
 * A plugin that TranslateCore can boot
 */
public interface CorePlugin extends Plugin, Comparable<CorePlugin> {

    /**
     * Runs when the core plugin is constructed.
     *
     * @param pluginLauncher The plugin launcher is its native launcher, this should be the same as what is returned in {@link Plugin#getPlatformLauncher()}
     */
    void onConstruct(@NotNull Object pluginLauncher);

    /**
     * Runs when commands should be registered
     *
     * @param register A command register for registering the plugins commands
     */
    void onRegisterCommands(@NotNull CommandRegister register);

    /**
     * Gets the licence of this plugin
     *
     * @return The licence name of the plugin
     */
    @NotNull String getLicence();

    @Override
    @NotNull
    CorePluginVersion getPluginVersion();

    default void onShutdown() {

    }

    @Override
    default int compareTo(@NotNull CorePlugin o) {
        for (LoadOnlyOnPlatform dependsOn : this.getDependingOn()) {
            if (!dependsOn.platform().equals(o.getPluginId())) {
                continue;
            }
            if (dependsOn.getLoadType()==LoadType.BEFORE) {
                return -1;
            }
            return 1;
        }
        for (LoadOnlyOnPlatform dependsOn : o.getDependingOn()) {
            if (!dependsOn.platform().equals(o.getPluginId())) {
                continue;
            }
            if (dependsOn.getLoadType()==LoadType.BEFORE) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    default LoadOnlyOnPlatform[] getDependingOn() {
        LoadOnlyOn loadOnlyOn = this.getClass().getAnnotation(LoadOnlyOn.class);
        if (loadOnlyOn==null) {
            return new LoadOnlyOnPlatform[0];
        }
        return loadOnlyOn.on();
    }
}
