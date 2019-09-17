package org.core.world.position.block.grouptype.versions;

import org.core.world.position.block.BlockType;
import org.core.world.position.block.blocktypes.legacy.BlockTypes1V12;

public interface BlockGroups1V12 {

    CoreBlockGroup LEGACY_FURNACE = new CoreBlockGroup("LegacyFurnace",
            BlockTypes1V12.FURNACE.get(),
            BlockTypes1V12.LIT_FURNACE.get());
    CoreBlockGroup LEGACY_REPEATER = new CoreBlockGroup("LegacyRepeater",
            BlockTypes1V12.POWERED_REPEATER.get(),
            BlockTypes1V12.UNPOWERED_REPEATER.get());
    CoreBlockGroup LEGACY_COMPARATOR = new CoreBlockGroup("LegacyComparator",
            BlockTypes1V12.POWERED_COMPARATOR.get(),
            BlockTypes1V12.UNPOWERED_COMPARATOR.get());
    CoreBlockGroup LEGACY_PRESSURE_PLATE = new CoreBlockGroup("LegacyPressurePlate",
            BlockTypes1V12.HEAVY_WEIGHTED_PRESSURE_PLATE.get(),
            BlockTypes1V12.LIGHT_WEIGHTED_PRESSURE_PLATE.get(),
            BlockTypes1V12.STONE_PRESSURE_PLATE.get(),
            BlockTypes1V12.WOODEN_PRESSURE_PLATE.get());
    CoreBlockGroup LEGACY_SINGLE_SLAB = new CoreBlockGroup("LegacySingleSlab",
            BlockTypes1V12.PURPUR_SLAB.get(),
            BlockTypes1V12.STONE_SLAB.get(),
            BlockTypes1V12.WOODEN_SLAB.get(),
            BlockTypes1V12.STONE_SLAB2.get());
    CoreBlockGroup LEGACY_DOUBLE_SLAB = new CoreBlockGroup("LegacyDoubleSlab",
            BlockTypes1V12.DOUBLE_STONE_SLAB.get(),
            BlockTypes1V12.DOUBLE_STONE_SLAB2.get(),
            BlockTypes1V12.DOUBLE_WOODEN_SLAB.get(),
            BlockTypes1V12.PURPUR_DOUBLE_SLAB.get());
    CoreBlockGroup LEGACY_SLAB = new CoreBlockGroup("LegacySlab",
            LEGACY_DOUBLE_SLAB.getGrouped(),
            LEGACY_SINGLE_SLAB.getGrouped());
    CoreBlockGroup LEGACY_STAIRS = new CoreBlockGroup("LegacyStairs",
            CommonBlockGroups.WOOD_STAIRS.getGrouped(),
            new BlockType[]{
                    BlockTypes1V12.SANDSTONE_STAIRS.get(),
                    BlockTypes1V12.NETHER_BRICK_STAIRS.get(),
                    BlockTypes1V12.PURPUR_STAIRS.get(),
                    BlockTypes1V12.QUARTZ_STAIRS.get(),
                    BlockTypes1V12.BRICK_STAIRS.get(),
                    BlockTypes1V12.RED_SANDSTONE_STAIRS.get(),
                    BlockTypes1V12.STONE_BRICK_STAIRS.get(),
                    BlockTypes1V12.STONE_STAIRS.get()
            });
}
