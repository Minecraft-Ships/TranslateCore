package org.core.platform.plugin.details.depends;

public class PluginDependsOn {

    private final String dependingId;
    private final DependsType dependsType;
    private final boolean loadBefore;

    public PluginDependsOn(String dependingId, DependsType type) {
        this(dependingId, type, false);
    }

    public PluginDependsOn(String dependingId, DependsType dependsType, boolean loadBefore) {
        this.dependingId = dependingId;
        this.dependsType = dependsType;
        this.loadBefore = loadBefore;
    }

    public String getDependingId() {
        return this.dependingId;
    }

    public DependsType getDependsType() {
        return this.dependsType;
    }

    public boolean isLoadBefore() {
        return this.loadBefore;
    }
}
