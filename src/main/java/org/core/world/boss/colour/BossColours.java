package org.core.world.boss.colour;

import org.core.CorePlugin;
import org.core.utils.Guaranteed;

public class BossColours implements Guaranteed<BossColour> {

    public static final BossColour BLUE = CorePlugin.getPlatform().get(new BossColours("Blue"));
    public static final BossColour GREEN = CorePlugin.getPlatform().get(new BossColours("Green"));
    public static final BossColour PINK = CorePlugin.getPlatform().get(new BossColours("Pink"));
    public static final BossColour PURPLE = CorePlugin.getPlatform().get(new BossColours("Purple"));
    public static final BossColour RED = CorePlugin.getPlatform().get(new BossColours("Red"));
    public static final BossColour WHITE = CorePlugin.getPlatform().get(new BossColours("White"));
    public static final BossColour YELLOW = CorePlugin.getPlatform().get(new BossColours("Yellow"));



    private String name;

    public BossColours(String name){
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
