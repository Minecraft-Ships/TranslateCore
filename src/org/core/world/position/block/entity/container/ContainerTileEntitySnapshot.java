package org.core.world.position.block.entity.container;

import org.core.world.position.block.entity.TileEntitySnapshot;

public interface ContainerTileEntitySnapshot <T extends ContainerTileEntity> extends ContainerTileEntity, TileEntitySnapshot<T> {

}
