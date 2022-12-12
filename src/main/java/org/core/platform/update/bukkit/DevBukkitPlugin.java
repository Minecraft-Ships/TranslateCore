package org.core.platform.update.bukkit;

import org.core.platform.update.PluginUpdate;

import java.net.URL;

public class DevBukkitPlugin implements PluginUpdate {

    private final String name;
    private final String version;
    private final URL download;

    public DevBukkitPlugin(String name, String version, URL download) {
        this.name = name;
        this.version = version;
        this.download = download;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public URL getDownloadURL() {
        return this.download;
    }

    @Override
    public String getVersion() {
        return this.version;
    }
}
