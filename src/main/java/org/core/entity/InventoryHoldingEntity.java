package org.core.entity;

import org.core.entity.living.LivingEntity;
import org.core.inventory.Inventory;

public interface InventoryHoldingEntity<E extends Entity<?>> extends LivingEntity<E> {

    Inventory getInventory();

}
