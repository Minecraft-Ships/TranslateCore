package org.core.world.position.block.entity;

import org.core.world.position.Positionable;
import org.core.world.position.impl.sync.SyncBlockPosition;

public interface LiveTileEntity extends TileEntity, Positionable {

    @Override
    SyncBlockPosition getPosition();
}
