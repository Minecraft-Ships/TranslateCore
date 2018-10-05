package org.core.world.position.block.entity;

import org.core.exceptions.BlockNotSupported;

public interface TileEntitySnapshot <E extends TileEntity> extends TileEntity {

    public E apply() throws BlockNotSupported;

}
