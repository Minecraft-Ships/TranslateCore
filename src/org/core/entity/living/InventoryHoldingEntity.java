package org.core.entity.living;

import org.core.inventory.Inventory;

public interface InventoryHoldingEntity <I extends Inventory> extends LivingEntity {

    public I getInventory();
}
