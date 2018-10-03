package org.core.world.position.block.entity;

import org.core.exceptions.BlockNotSupported;
import org.core.world.position.BlockPosition;
import org.core.world.position.Positionable;

public interface TileEntitySnapshot <E extends TileEntity> extends Positionable {

    public E apply() throws BlockNotSupported;

    @Override
    public BlockPosition getPosition();
}
