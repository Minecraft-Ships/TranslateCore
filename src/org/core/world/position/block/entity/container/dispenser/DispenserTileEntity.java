package org.core.world.position.block.entity.container.dispenser;

import org.core.inventory.inventories.general.block.dispenser.DispenserInventory;
import org.core.world.position.block.entity.container.ContainerTileEntity;

public interface DispenserTileEntity extends ContainerTileEntity {

    @Override
    DispenserInventory getInventory();

    @Override
    DispenserTileEntitySnapshot getSnapshot();
}
