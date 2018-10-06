package org.core.world.position.block.entity;

public interface TileEntity {

    public TileEntitySnapshot<? extends TileEntity> getSnapshot();
}
