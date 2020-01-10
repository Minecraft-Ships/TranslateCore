package org.core.world.position.block.entity.container.furnace;

import org.core.inventory.inventories.general.block.FurnaceInventory;
import org.core.world.position.block.entity.container.ContainerTileEntity;

public interface FurnaceTileEntity extends ContainerTileEntity {

    @Override
    FurnaceInventory getInventory();

    @Override
    FurnaceTileEntitySnapshot getSnapshot();
}
