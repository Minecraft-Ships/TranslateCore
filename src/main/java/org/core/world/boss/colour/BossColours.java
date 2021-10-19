package org.core.world.boss.colour;

import org.core.TranslateCore;
import org.core.utils.Guaranteed;
import org.core.utils.Singleton;

public class BossColours implements Guaranteed<BossColour> {

    public static final Singleton<BossColour> BLUE = TranslateCore.getPlatform().get(new BossColours("Blue"));
    public static final Singleton<BossColour> GREEN = TranslateCore.getPlatform().get(new BossColours("Green"));
    public static final Singleton<BossColour> PINK = TranslateCore.getPlatform().get(new BossColours("Pink"));
    public static final Singleton<BossColour> PURPLE = TranslateCore.getPlatform().get(new BossColours("Purple"));
    public static final Singleton<BossColour> RED = TranslateCore.getPlatform().get(new BossColours("Red"));
    public static final Singleton<BossColour> WHITE = TranslateCore.getPlatform().get(new BossColours("White"));
    public static final Singleton<BossColour> YELLOW = TranslateCore.getPlatform().get(new BossColours("Yellow"));


    private final String name;

    public BossColours(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return "minecraft." + getName().toLowerCase().replaceAll(" ", "_");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
