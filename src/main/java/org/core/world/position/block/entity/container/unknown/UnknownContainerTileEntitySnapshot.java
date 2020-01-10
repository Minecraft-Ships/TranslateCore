package org.core.world.position.block.entity.container.unknown;

import org.core.world.position.block.entity.TileEntitySnapshot;

public interface UnknownContainerTileEntitySnapshot extends UnknownContainerTiledEntity, TileEntitySnapshot<LiveUnknownContainerTileEntity> {

    @Override
    default Class<LiveUnknownContainerTileEntity> getDeclaredClass(){
        return LiveUnknownContainerTileEntity.class;
    }
}
