package org.core.entity.living;

import org.core.inventory.Inventory;

public interface InventoryHoldingEntity extends LivingEntity {

    public Inventory getInventory();

}
