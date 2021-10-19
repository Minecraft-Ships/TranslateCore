package org.core.entity.living.animal.parrot;

import org.core.TranslateCore;
import org.core.utils.Guaranteed;
import org.core.utils.Singleton;

public class ParrotTypes implements Guaranteed<ParrotType> {

    public static final Singleton<ParrotType> RED = TranslateCore.getPlatform().get(new ParrotTypes("Red"));

    private final String name;

    public ParrotTypes(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return "minecraft:" + this.name.toLowerCase();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
