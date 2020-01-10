package org.core.world.position.block.entity;

public interface TileEntity {

    TileEntitySnapshot<? extends TileEntity> getSnapshot();
}
