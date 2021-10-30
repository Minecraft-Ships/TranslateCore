package org.core.platform.plugin.details;

import org.jetbrains.annotations.NotNull;

/**
 * Gets the plugin version in the form of major.minor.patch
 */
public class CorePluginVersion implements PluginVersion {

    final int major;
    final int minor;
    final int patch;

    public CorePluginVersion(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int getPatch() {
        return this.patch;
    }

    @Override
    public @NotNull String asString() {
        return this.getMajor() + "." + this.getMinor() + "." + this.getPatch();
    }

}
