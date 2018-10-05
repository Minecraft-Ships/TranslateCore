package org.core.world.position.block.details;

import org.core.world.position.block.BlockType;

public interface BlockDetails {

    BlockType getType();

    BlockDetails createCopyOf();
}
