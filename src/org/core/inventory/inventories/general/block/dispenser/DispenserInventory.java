package org.core.inventory.inventories.general.block.dispenser;

import org.core.inventory.inventories.snapshots.block.dispenser.DispenserInventorySnapshot;

public interface DispenserInventory extends DispenserBasedInventory {

    @Override
    DispenserInventorySnapshot createSnapshot();
}
