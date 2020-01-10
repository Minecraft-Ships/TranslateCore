package org.core.inventory.inventories.general.block;

import org.core.inventory.inventories.BlockAttachedInventory;
import org.core.inventory.inventories.snapshots.block.UnknownBlockAttachedInventorySnapshot;

public interface UnknownBlockAttachedInventory extends BlockAttachedInventory {

    @Override
    UnknownBlockAttachedInventorySnapshot createSnapshot();
}
