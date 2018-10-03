package org.core.inventory.inventories;

import org.core.inventory.inventories.snapshots.ZombieInventorySnapshot;

public interface ZombieInventory extends BasicEntityInventory {

    @Override
    public ZombieInventorySnapshot createSnapshot();
}
