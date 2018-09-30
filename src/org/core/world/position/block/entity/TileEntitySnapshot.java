package org.core.world.position.block.entity;

import org.core.world.position.BlockPosition;

public interface TileEntitySnapshot <E extends TileEntity> {

    public BlockPosition getPosition();
    public E apply();
}
