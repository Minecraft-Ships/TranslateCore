package org.core.world.position.block.entity;

import org.core.world.position.BlockPosition;

public interface TileEntity {

    public BlockPosition getPosition();
    public TileEntitySnapshot<? extends TileEntity> createSnapshot();
}
