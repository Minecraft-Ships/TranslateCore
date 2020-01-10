package org.core.world.position.block.entity.container.dropper;

import org.core.inventory.inventories.general.block.dispenser.DropperInventory;
import org.core.world.position.block.entity.container.ContainerTileEntity;

public interface DropperTileEntity extends ContainerTileEntity {

    @Override
    DropperInventory getInventory();

    @Override
    DropperTileEntitySnapshot getSnapshot();
}
