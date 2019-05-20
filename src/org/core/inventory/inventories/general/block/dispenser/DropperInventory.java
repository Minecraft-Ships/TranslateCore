package org.core.inventory.inventories.general.block.dispenser;

import org.core.inventory.inventories.snapshots.block.dispenser.DropperInventorySnapshot;

public interface DropperInventory extends DispenserBasedInventory {

    @Override
    DropperInventorySnapshot createSnapshot();
}
