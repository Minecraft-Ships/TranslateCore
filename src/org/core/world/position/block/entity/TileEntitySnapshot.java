package org.core.world.position.block.entity;

import org.core.exceptions.BlockNotSupported;
import org.core.world.position.BlockPosition;
import org.core.world.position.block.BlockType;

import java.util.Collection;

public interface TileEntitySnapshot <E extends TileEntity> extends TileEntity {

    E apply(BlockPosition position) throws BlockNotSupported;
    Collection<BlockType> getSupportedBlocks();
}
