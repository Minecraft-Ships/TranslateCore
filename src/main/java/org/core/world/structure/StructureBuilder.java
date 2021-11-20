package org.core.world.structure;

import org.core.platform.plugin.Plugin;
import org.core.utils.Bounds;
import org.core.vector.type.Vector3;
import org.core.world.WorldExtent;
import org.core.world.position.impl.Position;

public class StructureBuilder {

    private String id;
    private String name;
    private Plugin plugin;

    private Vector3<Integer> min;
    private Vector3<Integer> max;
    private WorldExtent world;

    private boolean includeEntities;

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

    public boolean isIncludeEntities() {
        return this.includeEntities;
    }

    public StructureBuilder setIncludeEntities(boolean includeEntities) {
        this.includeEntities = includeEntities;
        return this;
    }

    public Plugin getPlugin() {
        return this.plugin;
    }

    public StructureBuilder setPlugin(Plugin plugin) {
        this.plugin = plugin;
        return this;
    }

    public Vector3<Integer> getMin() {
        return this.min;
    }

    public StructureBuilder setBounds(Bounds<Integer> bounds) {
        this.max = bounds.getIntMax();
        this.min = bounds.getIntMin();
        return this;
    }

    public StructureBuilder setMin(Vector3<Integer> min) {
        this.min = min;
        return this;
    }

    public StructureBuilder setMin(Position<Integer> position) {
        this.world = position.getWorld();
        this.min = position.getPosition();
        return this;
    }

    public Vector3<Integer> getMax() {
        return this.max;
    }

    public StructureBuilder setMax(Vector3<Integer> max) {
        this.max = max;
        return this;
    }

    public StructureBuilder setMax(Position<Integer> position) {
        this.world = position.getWorld();
        this.max = position.getPosition();
        return this;
    }

    public WorldExtent getWorld() {
        return this.world;
    }

    public StructureBuilder setWorld(WorldExtent world) {
        this.world = world;
        return this;
    }
}
