package org.core.world.structure;

import org.core.collection.BlockSetSnapshot;
import org.core.entity.Entity;
import org.core.platform.plugin.Plugin;

import java.util.Collection;
import java.util.HashSet;

public class StructureBuilder {

    private String id;
    private String name;
    private Plugin plugin;

    private Collection<? extends Entity<?>> entities = new HashSet<>();
    private Collection<BlockSetSnapshot> blocks = new HashSet<>();

    public String getId() {
        return this.id;
    }

    public StructureBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public StructureBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Plugin getPlugin() {
        return this.plugin;
    }

    public StructureBuilder setPlugin(Plugin plugin) {
        this.plugin = plugin;
        return this;
    }

    public Collection<? extends Entity<?>> getEntities() {
        return this.entities;
    }

    public StructureBuilder setEntities(Collection<? extends Entity<?>> entities) {
        this.entities = entities;
        return this;
    }

    public Collection<BlockSetSnapshot> getBlocks() {
        return this.blocks;
    }

    public StructureBuilder addBlocks(BlockSetSnapshot blocks) {
        this.blocks.add(blocks);
        return this;
    }

    public StructureBuilder setBlocks(Collection<BlockSetSnapshot> blocks) {
        this.blocks = blocks;
        return this;
    }
}
