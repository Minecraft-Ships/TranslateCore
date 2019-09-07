package org.core.world.position.block.entity.container.dropper;

import org.core.world.position.block.entity.TileEntitySnapshot;

public interface DropperTileEntitySnapshot extends DropperTileEntity, TileEntitySnapshot<LiveDropperTileEntity> {

    @Override
    default Class<LiveDropperTileEntity> getDeclaredClass(){
        return LiveDropperTileEntity.class;
    }
}
