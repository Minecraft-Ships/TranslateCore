package org.core.platform.plugin.details;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Gets the plugin version in the form of major.minor.patch
 */
public class CorePluginVersion implements PluginVersion {

    private final int major;
    private final int minor;
    private final int patch;
    private final @Nullable String versionName;
    private final @Nullable Integer version;

    public CorePluginVersion(int major, int minor, int patch) {
        this(major, minor, patch, null, null);
    }

    public CorePluginVersion(int major, int minor, int patch, @Nullable String versionName, @Nullable Integer version) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.version = version;
        this.versionName = versionName;
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

    public boolean isGreater(int major) {
        return this.isGreater(major, null, null);
    }

    public boolean isGreater(int major, int minor) {
        return this.isGreater(major, minor, null);
    }

    public boolean isGreater(int major, @Nullable Integer minor, @Nullable Integer patch) {
        if (major > this.major) {
            return true;
        }
        if (major < this.major) {
            return false;
        }
        if (minor != null) {
            if (minor > this.minor) {
                return true;
            }
            if (minor < this.minor) {
                return false;
            }
        }
        if (patch == null) {
            return true;
        }
        if (patch > this.patch) {
            return true;
        }
        return !(patch < this.patch);
    }

    @Override
    public @NotNull String asString() {
        String versionName = this.versionName;
        if (this.versionName != null) {
            versionName = "-" + this.versionName;
        }
        String versionNumber = null;
        if (this.version != null) {
            versionNumber = "." + this.version;
        }

        return this.getMajor() + "." + this.getMinor() + "." + this.getPatch() + (
                versionName == null ? "" : versionName) + (versionNumber == null ? "" : versionNumber);
    }

}
