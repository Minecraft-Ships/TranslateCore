package org.core.world.position.block.entity;

import org.core.world.position.BlockPosition;
import org.core.world.position.Positionable;

public interface LiveTileEntity extends TileEntity, Positionable {

    @Override
    BlockPosition getPosition();
}
