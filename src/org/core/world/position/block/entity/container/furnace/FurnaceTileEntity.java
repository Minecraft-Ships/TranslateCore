package org.core.world.position.block.entity.container.furnace;

import org.core.inventory.inventories.FurnaceInventory;
import org.core.world.position.block.entity.container.ContainerTileEntity;

public interface FurnaceTileEntity extends ContainerTileEntity {

    @Override
    public FurnaceInventory getInventory();

    @Override
    public FurnaceTileEntitySnapshot getSnapshot();
}
