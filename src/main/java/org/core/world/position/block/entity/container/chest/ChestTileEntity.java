package org.core.world.position.block.entity.container.chest;

import org.core.inventory.inventories.general.block.ChestInventory;
import org.core.world.position.block.entity.container.ContainerTileEntity;

public interface ChestTileEntity extends ContainerTileEntity {

    @Override
    ChestInventory getInventory();

    @Override
    ChestTileEntitySnapshot getSnapshot();
}
