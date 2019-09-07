package org.core.world.position.block.entity.container.dispenser;

import org.core.world.position.block.entity.TileEntitySnapshot;

public interface DispenserTileEntitySnapshot extends DispenserTileEntity, TileEntitySnapshot<LiveDispenserTileEntity> {

    @Override
    default Class<LiveDispenserTileEntity> getDeclaredClass(){
        return LiveDispenserTileEntity.class;
    }
}
