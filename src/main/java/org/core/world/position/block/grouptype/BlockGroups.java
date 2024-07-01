package org.core.world.position.block.grouptype;

import org.core.TranslateCore;

import java.util.function.Supplier;

public final class BlockGroups {

    public static final Supplier<BlockGroup> CARPET = createGroup("minecraft:carpets");
    public static final Supplier<BlockGroup> BUTTONS = createGroup("minecraft:buttons");
    public static final Supplier<BlockGroup> SIGNS = createGroup("minecraft:signs");
    public static final Supplier<BlockGroup> FENCES = createGroup("minecraft:fences");
    public static final Supplier<BlockGroup> FENCE_GATES = createGroup("minecraft:fence_gates");
    public static final Supplier<BlockGroup> DOORS = createGroup("minecraft:doors");
    public static final Supplier<BlockGroup> SHULKER_BOXES = createGroup("minecraft:shulker_boxes");
    public static final Supplier<BlockGroup> ANVIL = createGroup("minecraft:anvil");
    public static final Supplier<BlockGroup> WOOL = createGroup("minecraft:wool");
    public static final Supplier<BlockGroup> LOGS = createGroup("minecraft:logs");
    public static final Supplier<BlockGroup> PLANKS = createGroup("minecraft:planks");
    public static final Supplier<BlockGroup> BANNERS = createGroup("minecraft:banners");
    public static final Supplier<BlockGroup> BEDS = createGroup("minecraft:beds");
    public static final Supplier<BlockGroup> PRESSURE_PLATES = createGroup("minecraft:pressure_plates");
    public static final Supplier<BlockGroup> TRAPDOOR = createGroup("minecraft:trapdoor");
    public static final Supplier<BlockGroup> SAPLINGS = createGroup("minecraft:saplings");
    public static final Supplier<BlockGroup> SLABS = createGroup("minecraft:slabs");
    public static final Supplier<BlockGroup> STAIRS = createGroup("minecraft:stairs");

    private BlockGroups() {
        throw new RuntimeException("Do not create");
    }


    private static Supplier<BlockGroup> createGroup(String id) {
        return () -> TranslateCore
                .getPlatform()
                .getBlockGroup(id)
                .orElseThrow(() -> new RuntimeException("Cannot find the Block Tag of " + id));
    }


}
