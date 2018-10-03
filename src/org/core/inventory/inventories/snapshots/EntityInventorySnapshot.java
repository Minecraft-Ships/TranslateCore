package org.core.inventory.inventories.snapshots;

import org.core.entity.Entity;
import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.BasicEntityInventory;

public interface EntityInventorySnapshot <E extends Entity> extends InventorySnapshot, BasicEntityInventory {

    public void apply(E entity);
}
