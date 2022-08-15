package org.core.world.position.block.entity.container.furnace;

import org.core.inventory.inventories.live.block.LiveFurnaceInventory;
import org.core.world.position.block.entity.LiveTileEntity;

public interface LiveFurnaceTileEntity extends FurnaceTileEntity, LiveTileEntity {

    @Override
    LiveFurnaceInventory getInventory();
}
