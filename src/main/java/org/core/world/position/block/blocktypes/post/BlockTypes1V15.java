package org.core.world.position.block.blocktypes.post;

import org.core.TranslateCore;
import org.core.world.position.block.BlockType;

public class BlockTypes1V15 {
    public static final BlockType BEEHIVE = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:beehive")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));
    ;
    public static final BlockType BEE_NEST = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:bee_nest")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));
    public static final BlockType HONEY = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:honey_block")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));

    public static final BlockType HONEYCOMB_BLOCK = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:honeycomb_block")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));

}
