package org.core.world.position.block.grouptype.versions;

import org.core.world.position.block.blocktypes.CommonBlockTypes;

public interface CommonBlockGroups {

    CoreBlockGroup OAK_SIGN = new CoreBlockGroup("Oak Sign",
            CommonBlockTypes.OAK_SIGN,
            CommonBlockTypes.OAK_WALL_SIGN);
    CoreBlockGroup FENCE_GATE = new CoreBlockGroup("Fence Gate",
            CommonBlockTypes.ACACIA_FENCE_GATE,
            CommonBlockTypes.BIRCH_FENCE_GATE,
            CommonBlockTypes.DARK_OAK_FENCE_GATE,
            CommonBlockTypes.JUNGLE_FENCE_GATE,
            CommonBlockTypes.OAK_FENCE_GATE,
            CommonBlockTypes.SPRUCE_FENCE_GATE);
    CoreBlockGroup FENCE = new CoreBlockGroup("Fence",
            CommonBlockTypes.ACACIA_FENCE,
            CommonBlockTypes.BIRCH_FENCE,
            CommonBlockTypes.DARK_OAK_FENCE,
            CommonBlockTypes.JUNGLE_FENCE,
            CommonBlockTypes.NETHER_BRICK_FENCE,
            CommonBlockTypes.OAK_FENCE,
            CommonBlockTypes.SPRUCE_FENCE);
    CoreBlockGroup SHULKER_BOX = new CoreBlockGroup("Shulker Box",
            CommonBlockTypes.BLACK_SHULKER_BOX,
            CommonBlockTypes.BLUE_SHULKER_BOX,
            CommonBlockTypes.BROWN_SHULKER_BOX,
            CommonBlockTypes.CYAN_SHULKER_BOX,
            CommonBlockTypes.GRAY_SHULKER_BOX,
            CommonBlockTypes.GREEN_SHULKER_BOX,
            CommonBlockTypes.LIGHT_BLUE_SHULKER_BOX,
            CommonBlockTypes.LIME_SHULKER_BOX,
            CommonBlockTypes.MAGENTA_SHULKER_BOX,
            CommonBlockTypes.ORANGE_SHULKER_BOX,
            CommonBlockTypes.PINK_SHULKER_BOX,
            CommonBlockTypes.PURPLE_SHULKER_BOX,
            CommonBlockTypes.RED_SHULKER_BOX,
            CommonBlockTypes.WHITE_SHULKER_BOX,
            CommonBlockTypes.YELLOW_SHULKER_BOX);
    CoreBlockGroup WEIGHTED_PRESSURE_PLATE = new CoreBlockGroup("Wood Pressure Plate",
            CommonBlockTypes.HEAVY_WEIGHTED_PRESSURE_PLATE,
            CommonBlockTypes.LIGHT_WEIGHTED_PRESSURE_PLATE);
    CoreBlockGroup PISTON = new CoreBlockGroup("Piston",
            CommonBlockTypes.STICKY_PISTON,
            CommonBlockTypes.PISTON_HEAD,
            CommonBlockTypes.STICKY_PISTON,
            CommonBlockTypes.MOVING_PISTON);
    CoreBlockGroup DOOR = new CoreBlockGroup("Door",
            CommonBlockTypes.IRON_DOOR,
            CommonBlockTypes.DARK_OAK_DOOR,
            CommonBlockTypes.OAK_DOOR,
            CommonBlockTypes.ACACIA_DOOR,
            CommonBlockTypes.BIRCH_DOOR,
            CommonBlockTypes.JUNGLE_DOOR,
            CommonBlockTypes.SPRUCE_DOOR);
    CoreBlockGroup WOOD_DOOR = new CoreBlockGroup("Wood Door",
            CommonBlockTypes.DARK_OAK_DOOR,
            CommonBlockTypes.OAK_DOOR,
            CommonBlockTypes.ACACIA_DOOR,
            CommonBlockTypes.BIRCH_DOOR,
            CommonBlockTypes.JUNGLE_DOOR,
            CommonBlockTypes.SPRUCE_DOOR);
    CoreBlockGroup PISTON_BLOCK = new CoreBlockGroup("Piston Block",
            CommonBlockTypes.PISTON,
            CommonBlockTypes.STICKY_PISTON);
    CoreBlockGroup WOOD_STAIRS = new CoreBlockGroup("Wood Stairs",
            CommonBlockTypes.ACACIA_STAIRS,
            CommonBlockTypes.BIRCH_STAIRS,
            CommonBlockTypes.DARK_OAK_STAIRS,
            CommonBlockTypes.JUNGLE_STAIRS,
            CommonBlockTypes.OAK_STAIRS,
            CommonBlockTypes.SPRUCE_STAIRS);
}
