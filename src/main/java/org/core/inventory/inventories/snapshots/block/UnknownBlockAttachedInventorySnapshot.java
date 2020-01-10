package org.core.inventory.inventories.snapshots.block;

import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.general.block.UnknownBlockAttachedInventory;

public interface UnknownBlockAttachedInventorySnapshot extends UnknownBlockAttachedInventory, InventorySnapshot {

    void apply(UnknownBlockAttachedInventory ubai);
}
