package org.core.world.position.block.entity.container.chest;

import org.core.world.position.block.entity.TileEntitySnapshot;

public interface ChestTileEntitySnapshot extends ChestTileEntity, TileEntitySnapshot<LiveChestTileEntity> {

    @Override
    default Class<LiveChestTileEntity> getDeclaredClass(){
        return LiveChestTileEntity.class;
    }
}
