package org.core.inventory.inventories.general.block.dispenser;

import org.core.inventory.inventories.BlockAttachedInventory;
import org.core.inventory.inventories.snapshots.block.dispenser.DispenserBasedInventorySnapshot;
import org.core.inventory.parts.Grid3x3;

public interface DispenserBasedInventory extends BlockAttachedInventory {

    Grid3x3 getItems();

    @Override
    DispenserBasedInventorySnapshot createSnapshot();
}
