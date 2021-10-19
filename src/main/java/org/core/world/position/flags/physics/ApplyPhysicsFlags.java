package org.core.world.position.flags.physics;

import org.core.TranslateCore;
import org.core.utils.Guaranteed;
import org.core.utils.Singleton;

public class ApplyPhysicsFlags implements Guaranteed<ApplyPhysicsFlag> {

    public static final Singleton<ApplyPhysicsFlag> DEFAULT = TranslateCore.getPlatform().get(new ApplyPhysicsFlags("Default"));
    public static final Singleton<ApplyPhysicsFlag> NONE = TranslateCore.getPlatform().get(new ApplyPhysicsFlags("None"));

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
