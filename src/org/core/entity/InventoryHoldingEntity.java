package org.core.entity;

import org.core.entity.living.LivingEntity;
import org.core.inventory.Inventory;

public interface InventoryHoldingEntity extends LivingEntity {

    public Inventory getInventory();

}
