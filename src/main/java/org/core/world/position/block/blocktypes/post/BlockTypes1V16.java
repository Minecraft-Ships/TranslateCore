package org.core.world.position.block.blocktypes.post;

import org.core.TranslateCore;
import org.core.world.position.block.BlockType;

public class BlockTypes1V16 {

    public static final BlockType ANCIENT_DEBRIS = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:ancient_debris")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));

    public static final BlockType BASALT = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:basalt")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));

    public static final BlockType BLACKSTONE = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:blackstone")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));
    public static final BlockType NETHERITE_BLOCK = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:netherite_block")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));

    public static final BlockType CHAIN = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:chain")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));

    public static final BlockType CHISELED_NETHERRI = TranslateCore
            .getPlatform()
            .getBlockType("minecraft:basalt")
            .orElseThrow(() -> new IllegalStateException("Failed to find blocktype"));

}
