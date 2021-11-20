package org.core.world.structure;

import org.core.platform.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class StructureFileBuilder {

    private File file;
    private @Nullable Plugin plugin;
    private @Nullable String key;
    private @Nullable String name;

    public File getFile() {
        return this.file;
    }

    public StructureFileBuilder setFile(File file) {
        this.file = file;
        return this;
    }

    public @Nullable Plugin getPlugin() {
        return this.plugin;
    }

    public StructureFileBuilder setPlugin(Plugin plugin) {
        this.plugin = plugin;
        return this;
    }

    public @Nullable String getKey() {
        return this.key;
    }

    public StructureFileBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public @Nullable String getName() {
        return this.name;
    }

    public StructureFileBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
