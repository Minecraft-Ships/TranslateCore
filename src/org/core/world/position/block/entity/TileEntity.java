package org.core.world.position.block.entity;

import org.core.world.position.BlockPosition;
import org.core.world.position.Positionable;

public interface TileEntity extends Positionable {

    @Override
    public BlockPosition getPosition();

    public TileEntitySnapshot<? extends TileEntity> createSnapshot();
}
