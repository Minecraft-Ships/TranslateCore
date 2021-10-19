package org.core.world.position.block.entity.banner.pattern;

import org.core.TranslateCore;
import org.core.utils.Guaranteed;
import org.core.utils.Singleton;

public class PatternLayerTypes implements Guaranteed<PatternLayerType> {

    public static final Singleton<PatternLayerType> BASE = TranslateCore.getPlatform().get(new PatternLayerTypes("minecraft:base"));

    private final String id;

    private PatternLayerTypes(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        String nameLowercase = getId().split(":")[1];
        char first = Character.toUpperCase(nameLowercase.charAt(0));
        return first + nameLowercase.substring(1);
    }
}
