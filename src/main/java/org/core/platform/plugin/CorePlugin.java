package org.core.platform.plugin;

import org.core.command.CommandRegister;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.platform.plugin.details.depends.PluginDependsOn;
import org.jetbrains.annotations.NotNull;

public interface CorePlugin extends Plugin, Comparable<CorePlugin> {

    void onConstruct(@NotNull Object pluginLauncher);

    void onRegisterCommands(@NotNull CommandRegister register);

    @NotNull String getLicence();


    @Override
    @NotNull
    CorePluginVersion getPluginVersion();

    @Override
    default int compareTo(@NotNull CorePlugin o) {
        for (PluginDependsOn dependsOn : this.getDependingOn()) {
            if (dependsOn.isLoadBefore()) {
                continue;
            }
            if (dependsOn.getDependingId().equals(this.getPluginId())) {
                return 1;
            }
        }
        for (PluginDependsOn dependsOn : o.getDependingOn()) {
            if (!dependsOn.isLoadBefore()) {
                continue;
            }
            if (dependsOn.getDependingId().equals(this.getPluginId())) {
                return -1;
            }
        }
        return 0;
    }

    default PluginDependsOn[] getDependingOn() {
        return new PluginDependsOn[0];
    }
}
