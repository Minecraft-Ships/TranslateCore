package org.core.world.position.flags.physics;

import org.core.CorePlugin;
import org.core.utils.Guaranteed;
import org.core.utils.Singleton;

public class ApplyPhysicsFlags implements Guaranteed<ApplyPhysicsFlag> {

    public static final Singleton<ApplyPhysicsFlag> DEFAULT = CorePlugin.getPlatform().get(new ApplyPhysicsFlags("Default"));
    public static final Singleton<ApplyPhysicsFlag> NONE = CorePlugin.getPlatform().get(new ApplyPhysicsFlags("None"));

    private final String name;

    private ApplyPhysicsFlags(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return this.name.toLowerCase().replaceAll(" ", "_");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
