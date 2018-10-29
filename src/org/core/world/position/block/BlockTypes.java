package org.core.world.position.block;

import org.core.CorePlugin;
import org.core.utils.Guaranteed;

public class BlockTypes implements Guaranteed<BlockType> {

    public static final BlockType AIR = CorePlugin.getPlatform().get(new BlockTypes("minecraft:air"));
    public static final BlockType VOID_AIR = CorePlugin.getPlatform().get(new BlockTypes("minecraft:void_air"));
    public static final BlockType CAVE_AIR = CorePlugin.getPlatform().get(new BlockTypes("minecraft:cave_air"));
    public static final BlockType STONE = CorePlugin.getPlatform().get(new BlockTypes("minecraft:stone"));
    public static final BlockType GRANTIE = CorePlugin.getPlatform().get(new BlockTypes("minecraft:granite"));
    public static final BlockType POLISHED_GRANITE = CorePlugin.getPlatform().get(new BlockTypes("minecraft:polished_granite"));
    public static final BlockType DIORITE = CorePlugin.getPlatform().get(new BlockTypes("minecraft:diorite"));
    public static final BlockType POLISHED_DIORITE = CorePlugin.getPlatform().get(new BlockTypes("minecraft:polished_diorite"));
    public static final BlockType OAK_WOOD = CorePlugin.getPlatform().get(new BlockTypes("minecraft:oak_wood"));


    public static final BlockType WALL_SIGN = CorePlugin.getPlatform().get(new BlockTypes("minecraft:wall_sign"));
    public static final BlockType WATER = CorePlugin.getPlatform().get(new BlockTypes("minecraft:water"));


    private String id;

    private BlockTypes(String id) {
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
        return first + nameLowercase.substring(1, nameLowercase.length());
    }
}
