package org.core.world.position.block.grouptype.versions;

import org.core.world.position.block.blocktypes.CommonBlockTypes;

public interface CommonBlockGroups {

    CoreBlockGroup OAK_SIGN = new CoreBlockGroup("Oak Sign",
            CommonBlockTypes.OAK_SIGN.get(),
            CommonBlockTypes.OAK_WALL_SIGN.get());
    CoreBlockGroup FENCE_GATE = new CoreBlockGroup("Fence Gate",
            CommonBlockTypes.ACACIA_FENCE_GATE.get(),
            CommonBlockTypes.BIRCH_FENCE_GATE.get(),
            CommonBlockTypes.DARK_OAK_FENCE_GATE.get(),
            CommonBlockTypes.JUNGLE_FENCE_GATE.get(),
            CommonBlockTypes.OAK_FENCE_GATE.get(),
            CommonBlockTypes.SPRUCE_FENCE_GATE.get());
    CoreBlockGroup FENCE = new CoreBlockGroup("Fence",
            CommonBlockTypes.ACACIA_FENCE.get(),
            CommonBlockTypes.BIRCH_FENCE.get(),
            CommonBlockTypes.DARK_OAK_FENCE.get(),
            CommonBlockTypes.JUNGLE_FENCE.get(),
            CommonBlockTypes.NETHER_BRICK_FENCE.get(),
            CommonBlockTypes.OAK_FENCE.get(),
            CommonBlockTypes.SPRUCE_FENCE.get());
    CoreBlockGroup SHULKER_BOX = new CoreBlockGroup("Shulker Box",
            CommonBlockTypes.BLACK_SHULKER_BOX.get(),
            CommonBlockTypes.BLUE_SHULKER_BOX.get(),
            CommonBlockTypes.BROWN_SHULKER_BOX.get(),
            CommonBlockTypes.CYAN_SHULKER_BOX.get(),
            CommonBlockTypes.GRAY_SHULKER_BOX.get(),
            CommonBlockTypes.GREEN_SHULKER_BOX.get(),
            CommonBlockTypes.LIGHT_BLUE_SHULKER_BOX.get(),
            CommonBlockTypes.LIME_SHULKER_BOX.get(),
            CommonBlockTypes.MAGENTA_SHULKER_BOX.get(),
            CommonBlockTypes.ORANGE_SHULKER_BOX.get(),
            CommonBlockTypes.PINK_SHULKER_BOX.get(),
            CommonBlockTypes.PURPLE_SHULKER_BOX.get(),
            CommonBlockTypes.RED_SHULKER_BOX.get(),
            CommonBlockTypes.WHITE_SHULKER_BOX.get(),
            CommonBlockTypes.YELLOW_SHULKER_BOX.get());
    CoreBlockGroup WEIGHTED_PRESSURE_PLATE = new CoreBlockGroup("Wood Pressure Plate",
            CommonBlockTypes.HEAVY_WEIGHTED_PRESSURE_PLATE.get(),
            CommonBlockTypes.LIGHT_WEIGHTED_PRESSURE_PLATE.get());
    CoreBlockGroup PISTON = new CoreBlockGroup("Piston",
            CommonBlockTypes.STICKY_PISTON.get(),
            CommonBlockTypes.PISTON_HEAD.get(),
            CommonBlockTypes.STICKY_PISTON.get(),
            CommonBlockTypes.MOVING_PISTON.get());
    CoreBlockGroup DOOR = new CoreBlockGroup("Door",
            CommonBlockTypes.IRON_DOOR.get(),
            CommonBlockTypes.DARK_OAK_DOOR.get(),
            CommonBlockTypes.OAK_DOOR.get(),
            CommonBlockTypes.ACACIA_DOOR.get(),
            CommonBlockTypes.BIRCH_DOOR.get(),
            CommonBlockTypes.JUNGLE_DOOR.get(),
            CommonBlockTypes.SPRUCE_DOOR.get());
    CoreBlockGroup WOOD_DOOR = new CoreBlockGroup("Wood Door",
            CommonBlockTypes.DARK_OAK_DOOR.get(),
            CommonBlockTypes.OAK_DOOR.get(),
            CommonBlockTypes.ACACIA_DOOR.get(),
            CommonBlockTypes.BIRCH_DOOR.get(),
            CommonBlockTypes.JUNGLE_DOOR.get(),
            CommonBlockTypes.SPRUCE_DOOR.get());
    CoreBlockGroup PISTON_BLOCK = new CoreBlockGroup("Piston Block",
            CommonBlockTypes.PISTON.get(),
            CommonBlockTypes.STICKY_PISTON.get());
    CoreBlockGroup WOOD_STAIRS = new CoreBlockGroup("Wood Stairs",
            CommonBlockTypes.ACACIA_STAIRS.get(),
            CommonBlockTypes.BIRCH_STAIRS.get(),
            CommonBlockTypes.DARK_OAK_STAIRS.get(),
            CommonBlockTypes.JUNGLE_STAIRS.get(),
            CommonBlockTypes.OAK_STAIRS.get(),
            CommonBlockTypes.SPRUCE_STAIRS.get());
}
