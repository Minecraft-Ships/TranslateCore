package org.core.world.position.block.entity.container;

import org.core.inventory.inventories.BlockAttachedInventory;
import org.core.world.position.block.entity.TileEntity;

public interface ContainerTileEntity extends TileEntity {

    BlockAttachedInventory getInventory();

}
