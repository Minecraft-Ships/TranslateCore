package org.core.world.position.block.entity.container.furnace;

import org.core.world.position.block.entity.TileEntitySnapshot;

public interface FurnaceTileEntitySnapshot extends FurnaceTileEntity, TileEntitySnapshot<LiveFurnaceTileEntity> {

    @Override
    default Class<LiveFurnaceTileEntity> getDeclaredClass(){
        return LiveFurnaceTileEntity.class;
    }

}
