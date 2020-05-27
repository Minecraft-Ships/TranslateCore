package org.core.world.position.block.entity;

import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.Positionable;

public interface LiveTileEntity extends TileEntity, Positionable {

    @Override
    SyncBlockPosition getPosition();
}
