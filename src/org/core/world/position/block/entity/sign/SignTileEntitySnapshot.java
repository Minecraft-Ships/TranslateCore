package org.core.world.position.block.entity.sign;

import org.core.world.position.block.entity.TileEntitySnapshot;

public interface SignTileEntitySnapshot extends SignTileEntity, TileEntitySnapshot<LiveSignTileEntity> {

    @Override
    default Class<LiveSignTileEntity> getDeclaredClass(){
        return LiveSignTileEntity.class;
    }

}
